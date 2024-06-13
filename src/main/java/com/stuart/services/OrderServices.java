package com.stuart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stuart.model.Order;
import com.stuart.repositories.OrderRepository;

@Service
public class OrderServices {
    
    @Autowired 
    private OrderRepository orderRepository; 
    
        //GET ALL
       public List<Order> findAllOrders() {
        return orderRepository.findAll();
        }
        
        //GET 
        public Optional<Order> findOrderById(Long id) {
            return orderRepository.findById(id);
        }
        
        //POST
        public Order saveOrder(Order order) {
            return orderRepository.save(order);
        }
        
      //DELETE
        public void deleteOrderById(Long id) {
            orderRepository.deleteById(id);
        }
}
