package com.ecommerce.microcommerce.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.microcommerce.model.Product;

@RestController
public class ProductController {

	@GetMapping("/Produits")
	public String listeProduits() {
		
		return "Un exemple de produit";
		
	}
	
	@GetMapping("/Produits/{id}")
	public Product afficheUnProduit(@PathVariable int id) {
		
		Product product = new Product(id, new String("Aspirateur"), 100);
		
		return product;
		
	}
	
}
