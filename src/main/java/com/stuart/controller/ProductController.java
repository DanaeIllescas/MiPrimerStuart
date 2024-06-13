package com.stuart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stuart.model.Product;
import com.stuart.services.ProductServices;

@RestController
	@RequestMapping("/api/product/") 
	
	public class ProductController {
	    @Autowired // inyeccion de dependencia de servicios
	    private ProductServices productService;
	    
	    //GET
	   @GetMapping 
	   public List<Product> getAllProducts() {
	   return productService.findAllProducts();
	   }
	    
	    @GetMapping("{id}")
	    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
	        return productService.findProductById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }
	    
	    //POST
	    @PostMapping
	    public Product createProduct(@RequestBody Product product) {
	        return productService.saveProduct(product);
	    }
	    
	    //PUT
	    
	    //DELETE
	    //primero encontrar entidad y despues eliminar sino crear un (else) un not found
	    @DeleteMapping("{id}")
	    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
	        return productService.findProductById(id)
	                .map(product -> {
	                    productService.deleteProductById(id);
	                    return ResponseEntity.ok().<Void>build();
	                })
	                .orElse(ResponseEntity.notFound().build());
	    }
	}