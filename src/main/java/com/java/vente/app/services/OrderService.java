package com.java.vente.app.services;
import com.java.vente.app.DTO.ItemsDTO;
import com.java.vente.app.DTO.OrdersDTO;
import com.java.vente.app.models.Customers;
import com.java.vente.app.models.Items;
import com.java.vente.app.models.Orders;
import com.java.vente.app.repositories.CustomersRepository;
import com.java.vente.app.repositories.ItemsRepository;
import com.java.vente.app.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private CustomersRepository customersRepository;
    @Autowired
    private ItemsRepository itemsRepository;

    public OrdersDTO createOrder(OrdersDTO orderDTO){
        Optional<Items> item = itemsRepository.findById(orderDTO.getItem_code().getItem_id());
        if (item.isPresent()) {
            //supp que getPrice() retourne une chaîne de caractères
            String priceAsString = String.valueOf(item.get().getPrice());
            double price = Double.parseDouble(priceAsString);
            String stockAsString = String.valueOf(item.get().getStock());
            double stock = Double.parseDouble(stockAsString);
            orderDTO.setTotal_price(price * orderDTO.getQuantity());

            Items selectedItem = item.get();
            selectedItem.setStock(stock - orderDTO.getQuantity());
        }

        Orders order= convertToEntity(orderDTO);
        order.setOrder_date(new Date(System.currentTimeMillis()));
        OrdersDTO savedOrder  = convertToDTO(ordersRepository.save(order));

        Optional<Customers> customer = customersRepository.findById(savedOrder.getCustomer_code().getCustomer_id());
        if (customer.isPresent()){
            Customers updatedCustomer = customer.get();
            updatedCustomer.setLast_order_date(savedOrder.getOrder_date());
            updatedCustomer.setIs_active(String.valueOf(true));
            customersRepository.save(updatedCustomer);
        }

        return savedOrder;
    }

    public List<Orders> getAllOrders(){
        return ordersRepository.findAll();
    }

    public Optional<Orders> getOrderById(Long id){
        return ordersRepository.findById(id);
    }

    public OrdersDTO updateOrders(Long id , OrdersDTO orderDTO){

        return ordersRepository.findById(id).map(o->{

            o.setOrder_date(orderDTO.getOrder_date());
            o.setOrder_code(orderDTO.getOrder_code());
            o.setTotal_price(orderDTO.getTotal_price());
            o.setQuantity(orderDTO.getQuantity());
            o.setCustomer_code(orderDTO.getCustomer_code());
            o.setItem_code(orderDTO.getItem_code());

            Optional<Items> item = itemsRepository.findById(orderDTO.getItem_code().getItem_id());
            if (item.isPresent()){
                String priceAsString = String.valueOf(item.get().getPrice());
                double price = Double.parseDouble(priceAsString);
                o.setTotal_price(price * orderDTO.getQuantity());

                Items selectedItem = item.get();
                  // Supposons que getStock() retourne une chaîne de caractères
                String stockAsString = String.valueOf(selectedItem.getStock());
                  // Convertir la chaîne en double
                double stock = Double.parseDouble(stockAsString);
                  // Effectuer l'opération de soustraction
                selectedItem.setStock(stock - orderDTO.getQuantity());            }

            Optional<Customers> customer = customersRepository.findById(orderDTO.getCustomer_code().getCustomer_id());
            if (customer.isPresent()){
                Customers updatedCustomer= customer.get();
                updatedCustomer.setLast_order_date(orderDTO.getOrder_date());
                updatedCustomer.setIs_active(String.valueOf(true));
                customersRepository.save(updatedCustomer);
            }

            return convertToDTO(ordersRepository.save(o));
        }).orElseThrow(()->new RuntimeException("Order not found with id" + id));
    }

    public void deleteOrder(Long id){
        ordersRepository.deleteById(id);
    }

    private OrdersDTO convertToDTO(Orders order){
        OrdersDTO orderDTO = new OrdersDTO();
        orderDTO.setOrder_date(order.getOrder_date());
        orderDTO.setOrder_code(order.getOrder_code());
        orderDTO.setTotal_price(order.getTotal_price());
        orderDTO.setQuantity(order.getTotal_price());
        orderDTO.setCustomer_code(order.getCustomer_code());
        orderDTO.setItem_code(order.getItem_code());
        return orderDTO;

    }

    private Orders convertToEntity(OrdersDTO orderDTO){

        Orders order= new Orders();

        order.setOrder_date(orderDTO.getOrder_date());
        order.setOrder_code(orderDTO.getOrder_code());
        order.setQuantity(order.getQuantity());
        order.setCustomer_code(orderDTO.getCustomer_code());
        order.setItem_code(orderDTO.getItem_code());
        order.setTotal_price(orderDTO.getTotal_price());
        return order;
    }

}
