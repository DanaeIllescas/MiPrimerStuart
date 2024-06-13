package com.stuart.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stuart.model.Product;
import com.stuart.repositories.ProductRepository;


@Service
public class ProductServices {
    @Autowired 
    private ProductRepository productRepository; 
    
    //GET ALL
    //Podria borrarse
     public List<Product> findAllProducts() {
     return productRepository.findAll();
       }
        
    //GET 
        public Optional<Product> findProductById(Long id) { // se cambia a long
            return productRepository.findById(id);
        }
        
        //POST
        public Product saveProduct(Product product) {
            return productRepository.save(product);
        }
        
        //PUT
        
        
        //DELETE
        public void deleteProductById(Long id) {
            productRepository.deleteById(id);
        }

}


