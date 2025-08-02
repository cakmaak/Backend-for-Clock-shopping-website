package com.Saat.Controller;

import com.Saat.Dto.DtoProduct;
import com.Saat.Entity.Product;

public interface IProductController {
	
	public DtoProduct saveProduct(Product product);
	public DtoProduct findbyProductid(Long id);


}
