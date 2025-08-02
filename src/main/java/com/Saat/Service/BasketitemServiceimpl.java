package com.Saat.Service;

import java.net.Authenticator;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.Saat.Dto.DtoBasketitem;
import com.Saat.Dto.DtoProduct;
import com.Saat.Entity.Basket;
import com.Saat.Entity.BasketItem;
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
	public DtoBasketitem saveBasketitem(Long id,int quant) {
		
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		    String email = auth.getName();

		    
		    User user =userService.getUserbyEmail(email);

		    
		     Basket basket = basketService.getOrCreateBasketByUser(user);

		    
		    DtoProduct dtoProduct = productService.findbyProductid(id);
		    Product product = new Product();
		    BeanUtils.copyProperties(dtoProduct, product);

		    
		    BasketItem basketItem = new BasketItem();
		    basketItem.setFiyat(dtoProduct.getFiyat());
		    basketItem.setIndirim(dtoProduct.getIndirim());
		    basketItem.setOlusturmatarihi(LocalDateTime.now());
		    basketItem.setProduct(product);
		    basketItem.setBasket(basket); 
		    basketItem.setAdet(quant);
		    
		    
		    basketitemRepository.save(basketItem);

		    DtoBasketitem dtoBasketitem=new DtoBasketitem();
		    dtoBasketitem.setProductId(product.getId());
		    dtoBasketitem.setProductIsim(product.getIsim());
		    dtoBasketitem.setFiyat(product.getFiyat());
		    dtoBasketitem.setAdet(quant); 
		    dtoBasketitem.setIndirim(product.getIndirim());
		    dtoBasketitem.setBasketid(basket.getId());
		
		
		
		
		
		
		
		
		
		return dtoBasketitem ;
	}

}
