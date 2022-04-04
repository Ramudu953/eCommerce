package com.products.eCommerce.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class InventoryDetails {
    @Id
    private Integer skuCode;
    private Integer quantity;
    @OneToOne(cascade = CascadeType.ALL)
    private SkuProductDetails skuProductDetails;
    @OneToOne(mappedBy = "inventoryDetails")
    private OrderDetails orderDetails;

    public InventoryDetails() {
    }

    public Integer getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(Integer skuCode) {
        this.skuCode = skuCode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public SkuProductDetails getSkuProductDetails() {
        return skuProductDetails;
    }

    public void setSkuProductDetails(SkuProductDetails skuProductDetails) {
        this.skuProductDetails = skuProductDetails;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }
}
