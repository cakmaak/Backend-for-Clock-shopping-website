package com.Saat.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Saat.Service.IBasketService;

@RestController
@RequestMapping("/saatciapo")
public class BasketControllerimpl implements IBasketController {
	
	@Autowired
	IBasketService basketService;

	@Override
	@PutMapping("/basketitem/setquantity/{basketitemid}")
	public int setquantityinbasket(@PathVariable  Long basketitemid,@RequestParam int newquantity) {
		
		return basketService.setquantityinbasket(basketitemid, newquantity) ;
	}

}
