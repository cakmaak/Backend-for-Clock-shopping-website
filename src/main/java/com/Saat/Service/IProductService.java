package com.Saat.Service;

import java.util.List;

import com.Saat.Dto.DtoProduct;
import com.Saat.Entity.Product;

public interface IProductService  {
	
	public DtoProduct saveProduct(Product product);
	public DtoProduct findbyProductid(Long id);
	public DtoProduct updateProduct(Product newproduct,Long id);
	public Product referenceProduct(Long id);
	public List<Product> getAllproducts();
	public String updateurl(Long id ,String url);
	public DtoProduct deleteproduct(Long id);

}
