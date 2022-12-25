package com.axis.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.exception.InvalidProductException;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProductById(int productID) {
		// TODO Auto-generated method stub
		return productRepository.findById(productID).orElseThrow(()-> new ProductNotFound(AppConstants.PRODUCT_NOT_FOUND_MESSAGE));
	}

	@Override
	public Product updateProduct(int productId, Product product) {
		// TODO Auto-generated method stub
		Product prod=productRepository.findById(productId).orElseThrow(()-> new ProductNotFound(AppConstants.PRODUCT_NOT_FOUND_MESSAGE));
		prod.setProductName(product.getProductName());
		prod.setProductCategory(product.getProductCategory());
		prod.setProductQuantity(product.getProductQuantity());
		prod.setProductPrice(product.getProductPrice());	
		
		
		
		
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
	
	
	