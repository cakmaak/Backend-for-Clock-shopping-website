package com.Saat.Service;

import java.util.List;

import com.Saat.Dto.DtoOrderitem;
import com.Saat.Entity.Order;
import com.Saat.Entity.User;

public interface IOrderitemService {
	
	public String saveOrderitemfromBasket();
	public List<Order> findOrderitem();
	

}
