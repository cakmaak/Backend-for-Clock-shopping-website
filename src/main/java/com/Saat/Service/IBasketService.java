package com.Saat.Service;

import com.Saat.Dto.DtoUser;
import com.Saat.Entity.Basket;
import com.Saat.Entity.User;

public interface IBasketService  {
	
	public Basket getOrCreateBasketByUser(User user);
	public int setquantityinbasket(Long basketitemid,  int newquantity); 
	
	
	

}
