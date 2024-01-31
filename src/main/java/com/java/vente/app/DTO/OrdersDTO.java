package com.java.vente.app.DTO;


import com.java.vente.app.models.Customers;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrdersDTO {


    @NotNull(message = "Quantity field is required")
    @Positive(message = "Quantity must be greater than 0 ")
    private Double quantity;

    private Date order_date;

    @NotNull(message = "Total price field is required")
    @Positive(message = "Total price  must be greater than 0")
    private Double total_price;

    @NotNull(message = "Order code field is required")
    @Size(min = 1,message = "Order code  must be not empty")
    private Double order_code;


    @NotNull(message = "Customer code cannot be null")
    private Customers customer_code;

    @NotNull(message = "Item code cannot be null")
    private Customers item_code;

    private List<ItemsDTO> items;

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    public Double getOrder_code() {
        return order_code;
    }

    public void setOrder_code(Double order_code) {
        this.order_code = order_code;
    }

    public Customers getCustomer_code() {
        return customer_code;
    }

    public void setCustomer_code(Customers customer_code) {
        this.customer_code = customer_code;
    }

    public Customers getItem_code() {
        return item_code;
    }

    public void setItem_code(Customers item_code) {
        this.item_code = item_code;
    }

    public List<ItemsDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemsDTO> items) {
        this.items = items;
    }
}
