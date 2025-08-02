package com.Saat.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Saat.Dto.DtoProduct;
import com.Saat.Entity.Product;
import com.Saat.Service.IProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/saatciapo/product")
public class ProductController implements IProductController {
	
	@Autowired
	IProductService productService;

	
	
	@PostMapping("/saveproduct")
	@Override
	public DtoProduct saveProduct(@RequestBody @Valid Product product) {
		
		return productService.saveProduct(product);
	}
	
	
	@GetMapping("/findproduct/{id}")
	@Override
	public DtoProduct findbyProductid(@PathVariable  Long id) {
		// TODO Auto-generated method stub
		return productService.findbyProductid(id);
	}
	

}
