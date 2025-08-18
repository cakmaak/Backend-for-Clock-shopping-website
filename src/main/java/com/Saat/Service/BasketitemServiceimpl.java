package com.Saat.Service;

import java.net.Authenticator;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.CorsFilter;
import com.Saat.Dto.DtoBasketitem;
import com.Saat.Dto.DtoProduct;
import com.Saat.Entity.Basket;
import com.Saat.Entity.BasketItem;
import com.Saat.Entity.BasketitemRequest;
import com.Saat.Entity.Order;
import com.Saat.Entity.Product;
import com.Saat.Entity.User;
import com.Saat.Repository.BasketitemRepository;
import com.Saat.Repository.UserRepository;

@Service
public class BasketitemServiceimpl implements IBasketitem {

    private final CorsFilter corsFilter;

    private final SecurityFilterChain securityFilterChain;
	@Autowired 
	BasketitemRepository basketitemRepository;
	
	@Autowired
	IProductService productService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	IBasketService basketService;
	
	@Autowired
	IUserService userService;

    BasketitemServiceimpl(SecurityFilterChain securityFilterChain, CorsFilter corsFilter) {
        this.securityFilterChain = securityFilterChain;
        this.corsFilter = corsFilter;
    }

	@Override
	public DtoBasketitem saveBasketitem(BasketitemRequest request) {
		 
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth == null || !auth.isAuthenticated() || auth.getPrincipal().equals("anonymousUser")) {
		    throw new RuntimeException("Lütfen giriş yapınız.");
		}

		Object principal = auth.getPrincipal();
		String email;

		if (principal instanceof User) {
		    email = ((User) principal).getEmail();
		} else if (principal instanceof UserDetails) {
		    email = ((UserDetails) principal).getUsername(); 
		} else {
		    throw new RuntimeException("Bilinmeyen principal tipi: " + principal.getClass().getName());
		}

		User user = userService.getUserbyEmail(email);

		    
		    

		    
		     Basket basket = basketService.getOrCreateBasketByUser(user);

		     
		     
		     Long productId = Long.valueOf(request.getProductid());
		    DtoProduct dtoProduct = productService.findbyProductid(productId);
		    Product product = new Product();
		    product =productService.referenceProduct(productId);
		    

		    
		    BasketItem basketItem = new BasketItem();
		    basketItem.setFiyat(dtoProduct.getFiyat());
		    basketItem.setIndirim(dtoProduct.getIndirim());
		    basketItem.setOlusturmatarihi(LocalDateTime.now());
		    basketItem.setProduct(product);
		    basketItem.setBasket(basket); 
		    basketItem.setAdet(request.getQuantity());
		    
		    
		    basketitemRepository.save(basketItem);

		    DtoBasketitem dtoBasketitem=new DtoBasketitem();
		    dtoBasketitem.setProductId(product.getId());
		    dtoBasketitem.setProductIsim(product.getIsim());
		    dtoBasketitem.setFiyat(product.getFiyat());
		    dtoBasketitem.setAdet(request.getQuantity());
		    dtoBasketitem.setIndirim(product.getIndirim());
		    dtoBasketitem.setBasketid(basket.getId());
		    
		    
		    
		return dtoBasketitem;
	}

	@Override
	public Basket deleteBasketItem(Long id) {
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
	    
	    User user=userService.getUserbyEmail(email);
	    
	    Basket basket=basketService.getOrCreateBasketByUser(user);
	    
	    
	    
	    Optional<BasketItem> basketOptional = basketitemRepository.findById(id);
	    
	    System.out.println("Kullanıcı: " + user.getEmail());
	    System.out.println("Kullanıcının Sepeti: " + basket.getId());
	    System.out.println("Silinmek istenen BasketItem ID: " + id);
	    System.out.println("BasketItem'in basket_id'si: " + basketOptional.get().getBasket().getId());
	    
	    
	    if (basketOptional.isEmpty()) {
	    	throw new RuntimeException("Sepette ürün bulunamadı");
			
		}
	    
	    BasketItem basketItem=basketOptional.get();
	    if (!basketItem.getBasket().getId().equals(basket.getId())) {
	    	throw new RuntimeException("Bu ürün sizin sepetinize ait değil.");
			
		}
	  
	    basketitemRepository.delete(basketItem);
	    
	    
	    
	    
		return basket ;




	

	
	
	
	
	

	}

	@Override
	public List<BasketItem> findBasketItem() {
		
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
	    
	    User user=userService.getUserbyEmail(email);
	    
	    Basket basket=basketService.getOrCreateBasketByUser(user);
	    
	    List<BasketItem> basketItems=basket.getBasketItems();
	   
	    
	    if(basketItems.isEmpty()) {
	    	return Collections.emptyList();
	    }
	    	
	    
	    return basketItems;
		
		
		
		
	}




	
	
	}
