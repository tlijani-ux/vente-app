package com.java.vente.app.controllers;

import com.java.vente.app.DTO.CustomersDTO;
import com.java.vente.app.models.Customers;
import com.java.vente.app.services.CustomersService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor

@RequestMapping("/vente/customers")
public class CustomersController {

    @Autowired
    CustomersService customersService;

    @GetMapping
    public ResponseEntity<List<Customers>> getAllCustomers(){
        return ResponseEntity.ok(customersService.getAllCustomers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customers> getCustomersById(@PathVariable Long id){
        return customersService.getCustomerById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CustomersDTO createCustomer(@Valid @RequestBody CustomersDTO customerDTO){
        return customersService.createCustomer(customerDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CustomersDTO> updateCustomer(@PathVariable Long  id, @Valid @RequestBody CustomersDTO customerDTO){
        return ResponseEntity.ok(customersService.updateCustomer(id,customerDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id){
        customersService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }
}
