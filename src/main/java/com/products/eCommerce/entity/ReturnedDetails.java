package com.products.eCommerce.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReturnedDetails {
    @Id
    private Integer orderCode;
    private String status;

    public ReturnedDetails() {
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
