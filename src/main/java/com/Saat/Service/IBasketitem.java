package com.Saat.Service;

import java.util.List;

import org.hibernate.sql.Delete;

import com.Saat.Dto.DtoBasketitem;
import com.Saat.Entity.Basket;
import com.Saat.Entity.BasketItem;
import com.Saat.Entity.BasketitemRequest;
import com.Saat.Entity.Order;
import com.Saat.Entity.Product;

public interface IBasketitem  {
	public DtoBasketitem saveBasketitem(BasketitemRequest request);
	public List<BasketItem> findBasketItem();
	public Basket deleteBasketItem(Long id);
	
	

}
