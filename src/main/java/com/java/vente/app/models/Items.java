package com.java.vente.app.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name="items")
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long item_id;

    private boolean is_available;
    private String item_name;
    private String item_code;
    private Date last_re_stock;
    private Double price;
    private Double stock;

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public boolean isIs_available() {
        return is_available;
    }

    public void setIs_available(boolean is_available) {
        this.is_available = is_available;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_code() {
        return item_code;
    }

    public void setItem_code(String item_code) {
        this.item_code = item_code;
    }

    public Serializable getLast_re_stock() {
        // Convert Date to String using SimpleDateFormat
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return last_re_stock != null ? dateFormat.format(last_re_stock) : null;
    }
    public void setLast_re_stock(Date last_re_stock) {
        this.last_re_stock = last_re_stock;
    }

    public String getPrice() {
        return String.valueOf(price);

    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStock() {
        return String.valueOf(stock);
    }
    public void setStock(Double stock) {
        this.stock = stock;
    }
}
