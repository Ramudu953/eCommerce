package com.products.eCommerce.service;

import com.products.eCommerce.entity.CartDetails;
import com.products.eCommerce.entity.InventoryDetails;
import com.products.eCommerce.model.CartModel;
import com.products.eCommerce.repository.CartDetailsRepository;
import com.products.eCommerce.repository.InventoryDetailsRepository;
import com.products.eCommerce.repository.SkuProductDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartService {
    @Autowired
    private CartDetailsRepository cartDetailsRepository;
    @Autowired
    private SkuProductDetailsRepository skuProductDetailsRepository;
    @Autowired
    private InventoryDetailsRepository inventoryDetailsRepository;

    public String  addCart(Integer cartCode,Integer quantity){
        Optional<InventoryDetails> inventoryDetails = inventoryDetailsRepository.findById(cartCode);
        if(inventoryDetails.isPresent()){
            if(inventoryDetails.get().getQuantity()>=quantity) {
                CartDetails cartDetails = new CartDetails();
                cartDetails.setCartCode(cartCode);
                cartDetails.setQuantity(quantity);
                cartDetails.setSkuProductDetails(inventoryDetails.get().getSkuProductDetails());
                cartDetailsRepository.save(cartDetails);
                return "stock added to the cart";
            }
            return "out of stock";
        }
        else
            return "Cart Code Doesn't Exists";
    }

    public List<CartModel> viewCart(CartDetails cr){
        List<CartDetails> cartDetails = cartDetailsRepository.findAll();
        Integer[] totalPrice = {0};
        List<CartModel> cm = cartDetails.stream().map(cd->{
            totalPrice[0]+=(cd.getSkuProductDetails().getSkuPriceDetails().getPrice()*cd.getQuantity());
            CartModel cartModel = new CartModel();
            cartModel.setProductCode(cd.getSkuProductDetails().getProductDetails().getProductCode());
            cartModel.setProductName(cd.getSkuProductDetails().getProductDetails().getProductName());
            cartModel.setDescription(cd.getSkuProductDetails().getProductDetails().getDescription());
            cartModel.setSkuCode(cd.getSkuProductDetails().getSkuCode());
            cartModel.setSize(cd.getSkuProductDetails().getSize());
            cartModel.setPrice(cd.getSkuProductDetails().getSkuPriceDetails().getPrice());
            cartModel.setQuantity(cd.getQuantity());
            cartModel.setCartCode(cd.getCartCode());
            cartModel.setTotalPrice(totalPrice[0]);
            return cartModel;
        }).collect(Collectors.toList());
        return cm;
    }
}
