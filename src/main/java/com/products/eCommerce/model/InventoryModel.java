package com.products.eCommerce.model;

public class InventoryModel {
    private Integer skuCode;
    private Integer quantity;

    public InventoryModel() {
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
}
