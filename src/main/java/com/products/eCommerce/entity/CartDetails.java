package com.products.eCommerce.entity;

import javax.persistence.*;

@Entity
public class CartDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartCode;
    private Integer quantity;
    @OneToOne
    private SkuProductDetails skuProductDetails;

    public CartDetails() {
    }

    public Integer getCartCode() {
        return cartCode;
    }

    public void setCartCode(Integer cartCode) {
        this.cartCode = cartCode;
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
}
