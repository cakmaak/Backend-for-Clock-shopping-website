package com.Saat.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.Saat.Entity.Order;

public interface IOrderController {
	
	public ResponseEntity<String> createOrderfrombasket();
	public List<Order> findOrderitem();

}
