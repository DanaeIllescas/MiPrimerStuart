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

import com.stuart.model.Customer;
import com.stuart.services.CustomerServices;

@RestController
    @RequestMapping("/api/customer/") //Esta es una clase de URL, Redirecciona.
    
    public class CustomerController {
        @Autowired // inyección de dependencia de servicios
        private CustomerServices customerService;
        
        //GET
        @GetMapping 
        public List<Customer> getAllCustomers() {
            return customerService.findAllCustomer();
        }
        
        @GetMapping("{id}")
        public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
            return customerService.findCustomerById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }
        
        //POST
        @PostMapping
        public Customer createCustomer(@RequestBody Customer customer) {
            return customerService.saveCustomer(customer);
        }
        
        //PUT
        
        //DELETE
        //primero encontrar entidad y despues eliminar sino crear un (else) un not found
        @DeleteMapping("{id}")
        public ResponseEntity<Void> deleteCustomer(@PathVariable("id")Long id) {
            return customerService.findCustomerById(id)
                    .map(customer -> { 
                        customerService.deleteCustomerById(id);
                        return ResponseEntity.ok().<Void>build();
                    })
                    .orElse(ResponseEntity.notFound().build());
        }
    }