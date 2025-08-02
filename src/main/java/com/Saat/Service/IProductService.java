package com.Saat.Service;

import com.Saat.Dto.DtoProduct;
import com.Saat.Entity.Product;

public interface IProductService  {
	
	public DtoProduct saveProduct(Product product);
	public DtoProduct findbyProductid(Long id);

}
