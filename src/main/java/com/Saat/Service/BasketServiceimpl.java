package com.Saat.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;

import com.Saat.Dto.DtoBasketitem;
import com.Saat.Dto.DtoUser;
import com.Saat.Entity.Basket;
import com.Saat.Entity.User;
import com.Saat.Repository.BasketRepository;
import com.Saat.Repository.UserRepository;

@Service
public class BasketServiceimpl implements IBasketService {

    private final SecurityFilterChain filterChain;

	@Autowired
	BasketRepository basketRepository;
	
	@Autowired
	UserRepository userRepository;

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

	


	
		
		
		
		
	}


