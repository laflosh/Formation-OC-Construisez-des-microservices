package com.ecommerce.microcommerce.dao;

import java.util.List;

import com.ecommerce.microcommerce.model.Product;

public interface ProductDao {

	List<Product> findAll();
	
	Product findById(int id);
	
	Product save(Product product);
	
}
