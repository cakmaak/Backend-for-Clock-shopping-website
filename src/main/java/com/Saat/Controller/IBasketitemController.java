package com.Saat.Controller;

import java.util.List;

import com.Saat.Dto.DtoBasketitem;
import com.Saat.Entity.Basket;
import com.Saat.Entity.BasketItem;
import com.Saat.Entity.BasketitemRequest;
import com.Saat.Entity.User;

public interface IBasketitemController  {
	
	public DtoBasketitem saveBasketitem(BasketitemRequest request);
	public Basket deleteBasketItem(Long id);
	public List<BasketItem> findBasketItem();
}
