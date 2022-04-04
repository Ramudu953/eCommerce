package com.products.eCommerce.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ShippingDetails {
    @Id
    private Integer orderCode;
    private String status;

    public ShippingDetails() {
    }

    public Integer getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(Integer orderCode) {
        this.orderCode = orderCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
