package com.java.vente.app.controllers;


import com.java.vente.app.DTO.OrdersDTO;
import com.java.vente.app.models.Orders;
import com.java.vente.app.services.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/vente/orders")
public class OrdersController {

    @Autowired
    OrderService orderService;


    @GetMapping
    public ResponseEntity<List<Orders>> getAllOrders(){
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public OrdersDTO createOrder(@PathVariable  OrdersDTO orderDTO){
        return orderService.createOrder(orderDTO);
    }


    @PutMapping("/{id}")
    public ResponseEntity<OrdersDTO> updateOrder(@PathVariable Long id , @Valid @RequestBody OrdersDTO orderDto){
        return ResponseEntity.ok(orderService.updateOrders(id,orderDto));
    }

    @DeleteMapping("/id")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }









}
