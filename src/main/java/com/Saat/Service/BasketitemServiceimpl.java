package com.Saat.Service;

import java.net.Authenticator;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.Saat.Dto.DtoBasketitem;
import com.Saat.Dto.DtoProduct;
import com.Saat.Entity.Basket;
import com.Saat.Entity.BasketItem;
import com.Saat.Entity.BasketitemRequest;
import com.Saat.Entity.Product;
import com.Saat.Entity.User;
import com.Saat.Repository.BasketitemRepository;
import com.Saat.Repository.UserRepository;

@Service
public class BasketitemServiceimpl implements IBasketitem {
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
		    email = ((UserDetails) principal).getUsername(); // Eğer email burada tutuluyorsa
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



	

	
	
	
	
	

}
