package com.Saat.Service;

import com.Saat.Dto.DtoBasketitem;
import com.Saat.Entity.BasketItem;

public interface IBasketitem  {
	public DtoBasketitem saveBasketitem(Long id,int quant);

}
