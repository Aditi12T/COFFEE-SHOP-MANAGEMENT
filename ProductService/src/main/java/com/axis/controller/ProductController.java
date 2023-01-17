package com.axis.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.axis.model.Product;
import com.axis.service.ProductService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v2")
public class ProductController {
	

	@Autowired
	ProductService productService;
	
	@PostMapping("/addProduct")
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		Product product2 = productService.addProduct(product);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	@GetMapping("/getAllProducts")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> products = productService.getAllProducts();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK );
	}
	
	@GetMapping("/product/{product_id}")
	public  ResponseEntity<List<Product>> getProductsById(@PathVariable int product_id) {
		Product product = productService.getProductById(product_id);
		//orElseThrow(() -> new ResourceNotFoundException("Product not found with id :" + id));
		List<Product> products = new ArrayList<>();
		products.add(product);
		return ResponseEntity.ok(products);
	}
	
	@PutMapping("/product/{product_id}")
	public ResponseEntity<Product> updateProduct(@PathVariable int product_id,@RequestBody Product product){
		return new ResponseEntity<Product>(productService.updateProduct(product_id, product),HttpStatus.OK);
	}
	
	@DeleteMapping("/product/{product_id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int product_id){
		return new ResponseEntity<String>(productService.deleteProduct(product_id),HttpStatus.OK);
	}


}