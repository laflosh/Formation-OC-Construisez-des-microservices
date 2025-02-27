package com.ecommerce.microcommerce.web.controller;

import java.net.URI;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping("/Product")
	public ResponseEntity<Product> ajouterProduit(@RequestBody Product product) {
		
		Product productAdded = productDao.save(product);
		
		if(Objects.isNull(productAdded)) {
			
			return ResponseEntity.noContent().build();
			
		}
		
		URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(productAdded.getId())
					.toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
}
