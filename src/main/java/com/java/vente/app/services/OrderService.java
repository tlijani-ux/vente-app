package com.java.vente.app.services;


import com.java.vente.app.DTO.OrdersDTO;
import com.java.vente.app.models.Items;
import com.java.vente.app.repositories.CustomersRepository;
import com.java.vente.app.repositories.ItemsRepository;
import com.java.vente.app.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private CustomersRepository customersRepository;

    @Autowired
    private ItemsRepository itemsRepository;

    public OrdersDTO createOrder(OrdersDTO ordersDTO){
        Optional<Items> item = itemsRepository.findById(ordersDTO.getItem_code().getItem_id());




    }





}
