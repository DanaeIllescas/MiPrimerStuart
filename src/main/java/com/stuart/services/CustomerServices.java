package com.stuart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stuart.model.Customer;
import com.stuart.repositories.CustomerRepository;

@Service

public class CustomerServices {
    @Autowired 
    private CustomerRepository customerRepository; 
    
    //GET ALL
        public List<Customer> findAllCustomer() {
            return customerRepository.findAll();
        }
        
        //GET 
        public Optional<Customer> findCustomerById(Long id) { // se cambia a long
            return customerRepository.findById(id);
        }
        
        //POST
        public Customer saveCustomer(Customer customer) {
            return customerRepository.save(customer);
        }
        
        //PUT
        
        
        //DELETE
        public void deleteCustomerById(Long id) {
            customerRepository.deleteById(id);
        }
}