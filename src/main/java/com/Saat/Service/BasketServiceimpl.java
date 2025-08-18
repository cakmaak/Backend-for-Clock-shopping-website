package com.Saat.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;

import com.Saat.Dto.DtoBasketitem;
import com.Saat.Dto.DtoUser;
import com.Saat.Entity.Basket;
import com.Saat.Entity.BasketItem;
import com.Saat.Entity.User;
import com.Saat.Repository.BasketRepository;
import com.Saat.Repository.BasketitemRepository;
import com.Saat.Repository.UserRepository;

@Service
public class BasketServiceimpl implements IBasketService {

    private final SecurityFilterChain filterChain;

	@Autowired
	BasketRepository basketRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	IUserService userService;
	
	@Autowired
	BasketitemRepository basketitemRepository;
	
	
	
	

    BasketServiceimpl(SecurityFilterChain filterChain) {
        this.filterChain = filterChain;
    }

	@Override
	public Basket getOrCreateBasketByUser(User user) {
		
		Optional<Basket> optionalbasket=basketRepository.findByUser(user);
		
		if(optionalbasket.isPresent()) {
			return optionalbasket.get();
		}
		
		Basket newbasket =new Basket();
		newbasket .setUser(user);
		newbasket.setIsactive(true);
		newbasket.setOlusturmatarihi(LocalDateTime.now());
		basketRepository.save(newbasket);
		
		
		
		
		
		return newbasket ;
	}

	@Override
	public int setquantityinbasket(Long basketitemid,int newquantity) {
		
		    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		    if (auth == null || !auth.isAuthenticated() || auth.getPrincipal().equals("anonymousUser")) {
		        throw new RuntimeException("Lütfen giriş yapınız.");
		    }

		    String email;
		    Object principal = auth.getPrincipal();
		    if (principal instanceof UserDetails) {
		        email = ((UserDetails) principal).getUsername();
		    } else if (principal instanceof User) {
		        email = ((User) principal).getEmail();
		    } else {
		        throw new RuntimeException("Bilinmeyen principal tipi");
		    }

		    User user = userService.getUserbyEmail(email);
		    Basket basket = this.getOrCreateBasketByUser(user);

		    Optional<BasketItem> optionalItem =basketitemRepository.findById(basketitemid);
		    if (optionalItem.isEmpty()) {
		        throw new RuntimeException("Ürün bulunamadı.");
		    }

		    BasketItem item = optionalItem.get();

		    
		    if (!item.getBasket().getId().equals(basket.getId())) {
		        throw new RuntimeException("Bu ürün sizin sepetinize ait değil.");
		    }
		    
		    if (newquantity<=0) {
		    	basketitemRepository.delete(item);
				return 0;
			}

		    item.setAdet(newquantity);
		    basketitemRepository.save(item);
		    
		   
		
		
		
		return newquantity;
	}

	


}
		
		
		
		
	


