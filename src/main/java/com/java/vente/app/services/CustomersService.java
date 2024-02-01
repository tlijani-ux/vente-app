package com.java.vente.app.services;

import com.java.vente.app.DTO.CustomersDTO;
import com.java.vente.app.models.Customers;
import com.java.vente.app.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomersService {

    @Autowired
    private  CustomersRepository customersRepository;

    public CustomersDTO createCustomer(CustomersDTO customersDTO){
        Customers customer= convertToEntity(customersDTO);
        return convertToDTO(customersRepository.save(customer));
    }
    public List<Customers> getAllCustomers(){
        return customersRepository.findAll();
    }
    public Optional<Customers> getCustomerById(Long id){
        return customersRepository.findById(id);
    }
    public Customers save(Customers customer){
        return customersRepository.save(customer);
    }
    public CustomersDTO updateCustomer(Long id , CustomersDTO customersDTO){
        return customersRepository.findById(id).map(c->{
            c.setCustomer_name(customersDTO.getCustomer_name());
            c.setCustomer_code(customersDTO.getCustomer_code());
            c.setCustomer_address(customersDTO.getCustomer_address());
            c.setIs_active(String.valueOf(customersDTO.getIs_active()));
            c.setLast_order_date(customersDTO.getLast_order_date());
            c.setPic((customersDTO.getPic()));
            return convertToDTO(customersRepository.save(c));
        }).orElseThrow(()->new RuntimeException("Customer not found with id " + id));
    }

    public void deleteCustomer(Long id){
        customersRepository.deleteById(id);

    }

    private CustomersDTO convertToDTO(Customers customer){
        CustomersDTO customerDTO =  new CustomersDTO();
        customerDTO.setCustomer_address(customer.getCustomer_address());
        customerDTO.setCustomer_code(customer.getCustomer_code());
        customerDTO.setCustomer_name(customer.getCustomer_name());
        customerDTO.setCustomer_phone(customer.getCustomer_phone());
        customerDTO.setIs_active(customer.getIs_active());
        customerDTO.setLast_order_date(customer.getLast_order_date());
        customerDTO.setPic(customer.getPic());
        return customerDTO;
    }

    private Customers convertToEntity(CustomersDTO customerDTO){
        Customers customer =  new Customers();
        customer.setCustomer_address(customerDTO.getCustomer_address());
        customer.setCustomer_code(customerDTO.getCustomer_code());
        customer.setCustomer_name(customerDTO.getCustomer_name());
        customer.setCustomer_phone(customerDTO.getCustomer_phone());
        customer.setIs_active(String.valueOf(customerDTO.getIs_active()));

        customer.setLast_order_date(customerDTO.getLast_order_date());
        customer.setPic(customerDTO.getPic());
        return customer;
    }



}
