package com.java.vente.app.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name="orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long order_id;

    private Double quantity;
    private Double total_price;
    private Double order_code;
    private Double order_date;

    @ManyToMany
    @JoinColumn(name = "customer_id" , nullable = false)
    private Customers customer_code;

    @ManyToMany
    @JoinColumn(name = "item_id" , nullable = false)
    private Customers item_code;

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
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

    public Double getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Double order_date) {
        this.order_date = order_date;
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
}
