package com.Saat.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.Saat.Dto.DtoOrderitem;
import com.Saat.Entity.Basket;
import com.Saat.Entity.BasketItem;
import com.Saat.Entity.Order;
import com.Saat.Entity.OrderItem;
import com.Saat.Entity.User;
import com.Saat.Enums.Status;
import com.Saat.Repository.BasketRepository;
import com.Saat.Repository.BasketitemRepository;
import com.Saat.Repository.OrderRepository;
import com.Saat.Repository.UserRepository;

import ch.qos.logback.core.joran.conditional.IfAction;

@Service
public class OrderitemServiceimpl implements IOrderitemService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	IUserService userService;
	
	@Autowired
	BasketRepository basketRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	IBasketService basketService;
	

	@Override
	public String saveOrderitemfromBasket() {
		
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
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
		User user=userService.getUserbyEmail(email);
		
		Basket basket=basketService.getOrCreateBasketByUser(user);
		
		if(basket.getBasketItems().isEmpty()) {
			throw new RuntimeException("sepetiniz boş");
			
			
			
		}
		
		Order orderr=new Order();
		orderr.setUser(user);
		orderr.setStatus(Status.Sipariş_verildi);
		orderr.setOlusturmatarihi(LocalDateTime.now());
		
		
		List<OrderItem> orderItems=new ArrayList<>();
		BigDecimal toplamtutarBigDecimal=BigDecimal.ZERO;
		
		
		for(BasketItem bi:basket.getBasketItems()) {
			OrderItem oi=new OrderItem();
			oi.setAdet(bi.getAdet());
			oi.setEklenmetarihi(LocalDateTime.now());
			oi.setIndirim(bi.getIndirim());
			oi.setToplamfiyat(bi.getFiyat().multiply(BigDecimal.valueOf(bi.getAdet())));
			oi.setProduct(bi.getProduct());
			oi.setOrder(orderr);
			
			toplamtutarBigDecimal=toplamtutarBigDecimal.add(oi.getToplamfiyat());
			
			orderItems.add(oi);
			
			DtoOrderitem dtoOrderitem=new DtoOrderitem();
			BeanUtils.copyProperties(oi, dtoOrderitem);
			
			
			
		
		
		
		
	}
		
		orderr.setItemlist(orderItems);
		orderr.setToplamtutar(toplamtutarBigDecimal);
		
		basket.setIsactive(false);
		basketRepository.save(basket);
		
		
		orderRepository.save(orderr);
		
		
		return "Sipariş başarıyla oluşturuldu";
		

	
}


	@Override
	public List<Order> findOrderitem() {
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
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
		User user=userService.getUserbyEmail(email);
		
		List<Order> orders=orderRepository.findByUser(user);
		

		
		return orders ;
	}
}


















