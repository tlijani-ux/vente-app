package com.java.vente.app.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long order_id;

    private Double quantity;
    private Double total_price;
    private Double order_code;

    @Temporal(TemporalType.TIMESTAMP)
    private Date order_date;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customers customer_code;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Items item_code;

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

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Customers getCustomer_code() {
        return customer_code;
    }

    public void setCustomer_code(Customers customer_code) {
        this.customer_code = customer_code;
    }

    public Items getItem_code() {
        return item_code;
    }

    public void setItem_code(Items item_code) {
        this.item_code = item_code;
    }
}
