package com.java.vente.app.DTO;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
public class CustomersDTO {

    @NotBlank(message = "Customer code is required")
    @Size(max = 50 , message = "Customer code must be at least 50 charachters")
    private String customer_code;

    @NotBlank(message = "Customer name is required")
    @Size(max = 50 , message = "Customer name must be at least 50 charachters")
    private String customer_name;

    @NotBlank(message = "Customer address is required")
    @Size(max = 50 , message = "Customer address must be at least 50 charachters")
    private String customer_address;

    @NotBlank(message = "Customer phone is required")
    @Pattern(regexp = "\\d{8,12}" , message = "Customer phone must be valid number with 8 to 12 digit")
    private String customer_phone;

    @NotNull(message = "Is active flag is required")
    private Boolean is_active;

    private Date last_order_date;

    @NotBlank(message = "PIC is required")
    private String pic;

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

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public @NotNull(message = "Is active flag is required") Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
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

    public void setPic(String pic) {
        this.pic = pic;
    }
}
