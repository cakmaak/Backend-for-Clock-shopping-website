package com.Saat.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Saat.Entity.Order;
import com.Saat.Service.IOrderitemService;

@RestController
@RequestMapping("/saatciapo")
public class OrderControllerimpl implements IOrderController {
	
	
	@Autowired
	IOrderitemService orderitemService;

	
	@PostMapping("/createorder")
	@Override
	public ResponseEntity<String> createOrderfrombasket() {
		
		String sonuc=orderitemService.saveOrderitemfromBasket();
		
		
		return ResponseEntity.ok(sonuc);
	}

	@GetMapping("/getorderitem")
	@Override
	public List<Order> findOrderitem() {

		return orderitemService.findOrderitem() ;
	}

	
	

}
