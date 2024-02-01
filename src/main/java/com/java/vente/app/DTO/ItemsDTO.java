package com.java.vente.app.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
public class ItemsDTO {

    @NotNull(message = "is_available field is required")
    private Boolean is_available;

    @NotNull(message = "item_name is required")
    @Size(min = 3, max = 50, message = "item_name name must be between 3 and 50 characters")
    private String item_name;

    @NotNull(message = "item_code name is required")
    @Size(min = 1, max = 50, message = "item_name name must be between 1 and 50 characters")
    private String item_code;

    @NotNull(message = "last_re_stock field is required")
    private Date last_re_stock;

    @NotNull(message = "price field is required")
    @Positive(message = "price must be a positive value")
    private Double price;

    @NotNull(message = "stock field is required")
    @Positive(message = "stock must be a positive value")
    private Double stock;

    public Boolean getIs_available() {
        return is_available;
    }

    public void setIs_available(Boolean is_available) {
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

    public Date getLast_re_stock() {
        return last_re_stock;
    }

    public void setLast_re_stock(Date last_re_stock) {
        this.last_re_stock = last_re_stock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getStock() {
        return stock;
    }

    public void setStock(Double stock) {
        this.stock = stock;
    }

    public Object setLast_re_stock(Double aDouble) {
        return null ;
    }
}
