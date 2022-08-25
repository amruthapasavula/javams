package com.ecommerce.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.product.dto.ProductDto;
import com.ecommerce.product.model.Product;
import com.ecommerce.product.service.ProductServiceRepo;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductServiceRepo pSRepo;
	
	
	
	public ProductController(ProductServiceRepo pSRepo) {
		super();
		this.pSRepo = pSRepo;
	}


	@PostMapping("/saveProduct")
	public ResponseEntity<String> saveProducts(@RequestBody ProductDto pDto)
	{
		return new ResponseEntity<>(pSRepo.addProduct(pDto),HttpStatus.OK);
	}

	@GetMapping("/get")
	public List<Product> getProduct()
	{
		return pSRepo.getProducts();
	}
	
	@GetMapping("/getProduct/{productId}")
	public ResponseEntity<?> getProductById(@PathVariable int productId)
	{
		if(pSRepo.getProductById(productId)==null)
		{
			return new ResponseEntity<>("no product is found with the product_id you entered...",HttpStatus.NOT_FOUND);
		}
		else
		{
			return new ResponseEntity<>(pSRepo.getProductById(productId),HttpStatus.OK);
		}
	}
	
	@PutMapping("/updateProduct/{productId}")
	public ResponseEntity<String> updateProductById(@RequestBody ProductDto pDto,@PathVariable int productId)
	{
		return new ResponseEntity<>(pSRepo.updateProduct(pDto, productId),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteProduct/{productId}")
	public ResponseEntity<String> deleteProductById(@PathVariable int productId)
	{
		return new ResponseEntity<>(pSRepo.deleteProduct(productId),HttpStatus.OK);
	}
	
	

}
