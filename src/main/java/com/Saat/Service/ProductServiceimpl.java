package com.Saat.Service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Saat.Dto.DtoProduct;
import com.Saat.Entity.Product;
import com.Saat.Repository.ProductRepository;

@Service
public class ProductServiceimpl implements IProductService {
	
	@Autowired 
	ProductRepository productRepository;

	@Override
	public DtoProduct saveProduct(Product product) {
		Product productt=new Product();
		BeanUtils.copyProperties(product, productt);
		productRepository.save(product);
		DtoProduct dtoProduct=new DtoProduct();
		BeanUtils.copyProperties(productt, dtoProduct);
		
		
		return dtoProduct;
	}

	@Override
	public DtoProduct findbyProductid(Long id) {
		
		Optional<Product> optionalproduct =productRepository.findById(id);
		Product product=optionalproduct.get();
		DtoProduct dtoProduct=new DtoProduct(); 
		BeanUtils.copyProperties(product, dtoProduct);
		
		return dtoProduct;
	}

	@Override
	public Product referenceProduct(Long id) {
		
		Optional<Product> optional=productRepository.findById(id);
		
		Product product= optional.get();
		return product;
	}

}
