package com.java.vente.app.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@Entity
@Table(name="customers")
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customer_id;
    private String customer_code;
    private String customer_name;
    private String customer_address;
    private String customer_phone;
    private String is_active;
    private Date last_order_date;
    private String pic;

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_code() {
        return customer_code;
    }

    public void setCustomer_code(String customer_code) {
        this.customer_code = customer_code;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    public Date getLast_order_date() {
        return last_order_date;
    }

    public void setLast_order_date(Date last_order_date) {
        this.last_order_date = last_order_date;
    }

    public String getPic() {
        return pic;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
