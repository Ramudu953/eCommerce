package com.products.eCommerce.entity;

import javax.persistence.*;

@Entity
public class SkuPriceDetails {
    @Id
    private Integer skuCode;
    private Integer price;
    @OneToOne(cascade = CascadeType.ALL)
    private SkuProductDetails skuProductDetails;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "skuProductDetails")
    private CartDetails cartDetails;

    public SkuPriceDetails() {
    }

    public Integer getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(Integer skuCode) {
        this.skuCode = skuCode;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public SkuProductDetails getSkuProductDetails() {
        return skuProductDetails;
    }

    public void setSkuProductDetails(SkuProductDetails skuProductDetails) {
        this.skuProductDetails = skuProductDetails;
    }

    public CartDetails getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(CartDetails cartDetails) {
        this.cartDetails = cartDetails;
    }
}
