package com.Saat.Controller;

import java.util.List;

import com.Saat.Dto.DtoProduct;
import com.Saat.Entity.Product;

public interface IProductController {
	
	public DtoProduct saveProduct(Product product);
	public DtoProduct updateProduct(Product newproduct,Long id);
	public DtoProduct findbyProductid(Long id);
	public List<Product> getAllproducts();
	public String updateurl(Long id ,String url);
	public DtoProduct deleteproduct(Long id);
	


}
