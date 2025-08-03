package com.Saat.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Saat.Dto.DtoBasketitem;
import com.Saat.Entity.Basket;
import com.Saat.Entity.BasketitemRequest;
import com.Saat.Entity.User;
import com.Saat.Service.IBasketitem;



@RestController
@RequestMapping("/saatciapo")
public class BasketitemControllerimpl implements IBasketitemController {
	
	
	@Autowired
	IBasketitem basketitem;
	
	

		
	@PostMapping("/addtobasket")
	@Override
	public DtoBasketitem saveBasketitem(@RequestBody  BasketitemRequest request) {
		
		
		
		
		return basketitem.saveBasketitem(request);
	}



	
	
	
	


}
