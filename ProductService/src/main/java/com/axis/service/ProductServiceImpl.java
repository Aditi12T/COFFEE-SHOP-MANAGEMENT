package com.axis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.exception.ProductNotFound;
import com.axis.model.Product;
import com.axis.repository.ProductRepository;
import com.axis.utils.AppConstants;


@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRepository productRepository;
	/*
	 * @Description: This method is used  to add a product
	 * @Param: It takes product parameter
	 * @Returns:It returns products
	 * @Author:Aditi
	 * @Created Date: 19 Dec 2022
	 * 
	 */

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(int product_id) {
		// TODO Auto-generated method stub
		return productRepository.findById(product_id).orElseThrow(()-> new ProductNotFound(AppConstants.PRODUCT_NOT_FOUND_MESSAGE));
	}

	@Override
	public Product updateProduct(int product_id, Product product) {
		// TODO Auto-generated method stub
		Product prod=productRepository.findById(product_id).orElseThrow(()-> new ProductNotFound(AppConstants.PRODUCT_NOT_FOUND_MESSAGE));
		prod.setProduct_name(product.getProduct_name());
		prod.setProduct_category(product.getProduct_category());
		prod.setProduct_price(product.getProduct_price());	
		
		
		return productRepository.save(prod);
	}

	

	@Override
	public String deleteProduct(int productId) {
		// TODO Auto-generated method stub
		Product prod=productRepository.findById(productId).orElseThrow(()-> new ProductNotFound(AppConstants.PRODUCT_NOT_FOUND_MESSAGE));
		productRepository.delete(prod);
		return AppConstants.PRODUCT_DELETE_MESSAGE;
	}
}