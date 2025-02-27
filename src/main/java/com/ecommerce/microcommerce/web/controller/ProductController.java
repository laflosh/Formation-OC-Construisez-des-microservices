package com.ecommerce.microcommerce.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.model.Product;

@RestController
public class ProductController {

	@Autowired
	private ProductDao productDao;
	
	@GetMapping("/Produits")
	public List<Product> listeProduits() {
		
		return productDao.findAll();
		
	}
	
	@GetMapping("/Produits/{id}")
	public Product afficheUnProduit(@PathVariable int id) {
		
		return productDao.findById(id);
		
	}
	
}
