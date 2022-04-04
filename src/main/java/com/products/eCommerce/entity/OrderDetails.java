package com.products.eCommerce.entity;

import javax.persistence.*;

@Entity
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderCode;
    private String status;
    private Integer quantity;

    @OneToOne(cascade = CascadeType.ALL)
    private InventoryDetails inventoryDetails;

    public OrderDetails() {
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public InventoryDetails getInventoryDetails() {
        return inventoryDetails;
    }

    public void setInventoryDetails(InventoryDetails inventoryDetails) {
        this.inventoryDetails = inventoryDetails;
    }

}
