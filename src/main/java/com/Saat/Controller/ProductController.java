package com.Saat.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@PutMapping("/updateproduct/{id}")
	@Override
	public DtoProduct updateProduct(@RequestBody  Product newproduct,@PathVariable Long id) {
		
		
		
		return productService.updateProduct(newproduct, id);
	}

	@GetMapping("/getallproduct")
	@Override
	public List<Product> getAllproducts() {
		
		return productService.getAllproducts();
	}

	@PutMapping("/updateurl/{id}")
	@Override
	public String updateurl(@PathVariable Long id, @RequestParam String url) {
		
		
		
		return productService.updateurl(id, url);
	}

	@DeleteMapping("/delete/{id}")
	@Override
	public DtoProduct deleteproduct(@PathVariable Long id) {
		
		return productService.deleteproduct(id);
	}
	
	
	

}
