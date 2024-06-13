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

import com.stuart.model.Order;
import com.stuart.services.OrderServices;

@RestController
@RequestMapping("/api/order/") 
public class OrderController {
    
      @Autowired 
      private OrderServices orderService;
      
      //GET
  @GetMapping 
  public List<Order> getAllOrders() {
  return orderService.findAllOrders();
     }
      
      @GetMapping("{id}")
      public ResponseEntity<Order> getOrderById(@PathVariable("id") Long id) {
          return orderService.findOrderById(id)
                  .map(ResponseEntity::ok)
                  .orElse(ResponseEntity.notFound().build());
      }
      
      //POST
      @PostMapping
      public Order createOrder(@RequestBody Order order) {
          return orderService.saveOrder(order);
      }
      
      //PUT
      
      //DELETE
      //primero encontrar entidad y despues eliminar sino crear un (else) un not found
      @DeleteMapping("{id}")
      public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
          return orderService.findOrderById(id)
                  .map(order -> {
                      orderService.deleteOrderById(id);
                      return ResponseEntity.ok().<Void>build();
                  })
                  .orElse(ResponseEntity.notFound().build());
      }
 }
