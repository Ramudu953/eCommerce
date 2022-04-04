package com.products.eCommerce.service;

import com.products.eCommerce.entity.CartDetails;
import com.products.eCommerce.entity.InventoryDetails;
import com.products.eCommerce.entity.OrderDetails;
import com.products.eCommerce.model.OrderModel;
import com.products.eCommerce.repository.CartDetailsRepository;
import com.products.eCommerce.repository.InventoryDetailsRepository;
import com.products.eCommerce.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;
    @Autowired
    private InventoryDetailsRepository inventoryDetailsRepository;
    @Autowired
    private CartDetailsRepository cartDetailsRepository;

    public String addOrder(Integer skuCode,Integer quantity){
        Optional<InventoryDetails> inventoryDetails = inventoryDetailsRepository.findById(skuCode);
        if(inventoryDetails.isPresent()){
            if(inventoryDetails.get().getQuantity()>=quantity){
                OrderDetails orderDetails = new OrderDetails();
                orderDetails.setQuantity(quantity);
                orderDetails.setStatus("RECEIVED");
                orderDetails.setInventoryDetails(inventoryDetails.get());
                orderDetailsRepository.save(orderDetails);
                inventoryDetails.get().setQuantity(inventoryDetails.get().getQuantity()-quantity);
                inventoryDetailsRepository.save(inventoryDetails.get());
                Optional<CartDetails> cd = cartDetailsRepository.findById(inventoryDetails.get().getSkuCode());
                if (cd.isPresent()){
                    cartDetailsRepository.deleteById(inventoryDetails.get().getSkuProductDetails().getSkuCode());
                }
                return "ORDER RECEIVED";
            }
            else
                return "OUT OF QUANTITY";
        }
        return "OUT OF STOCK";
    }

    public OrderModel getOrder(Integer orderCode){
        Optional<OrderDetails> od = orderDetailsRepository.findById(orderCode);
        if (od.isPresent()){
            OrderModel om = new OrderModel();
            om.setProductCode(od.get().getInventoryDetails().getSkuProductDetails().getProductDetails().getProductCode());
            om.setProductName(od.get().getInventoryDetails().getSkuProductDetails().getProductDetails().getProductName());
            om.setSkuCode(od.get().getInventoryDetails().getSkuProductDetails().getSkuCode());
            om.setSize(od.get().getInventoryDetails().getSkuProductDetails().getSize());
            om.setPrice(od.get().getInventoryDetails().getSkuProductDetails().getSkuPriceDetails().getPrice());
            om.setQuantity(od.get().getInventoryDetails().getQuantity());
            om.setStatus(od.get().getStatus());
            return om;
        }
        return null;
     }
}
