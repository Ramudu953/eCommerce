package com.products.eCommerce.service;

import com.products.eCommerce.entity.*;
import com.products.eCommerce.model.OrderModel;
import com.products.eCommerce.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FulfilmentService {
    @Autowired
    private ProcessingDetailsRepository processingDetailsRepository;
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;
    @Autowired
    private PackingDetailsRepository packingDetailsRepository;
    @Autowired
    private ShippingDetailsRepository shippingDetailsRepository;
    @Autowired
    private DeliveredDetailsRepository deliveredDetailsRepository;
    @Autowired
    private ReturnedDetailsRepository returnedDetailsRepository;
    @Autowired
    private InventoryDetailsRepository inventoryDetailsRepository;

   public String getProcess(Integer orderCode){
       Optional<OrderDetails> orderDetails = orderDetailsRepository.findById(orderCode);
       if(orderDetails.isPresent()){
           if("RECEIVED".equalsIgnoreCase(orderDetails.get().getStatus())){
           ProcessingDetails pd = new ProcessingDetails();
           pd.setOrderCode(orderCode);
           pd.setStatus("PROCESSING");
           processingDetailsRepository.save(pd);
               OrderModel om = new OrderModel();
               om.setProductCode(orderDetails.get().getInventoryDetails().getSkuProductDetails().getProductDetails().getProductCode());
               om.setProductName(orderDetails.get().getInventoryDetails().getSkuProductDetails().getProductDetails().getProductName());
               om.setSkuCode(orderDetails.get().getInventoryDetails().getSkuProductDetails().getSkuCode());
               om.setSize(orderDetails.get().getInventoryDetails().getSkuProductDetails().getSize());
               om.setPrice(orderDetails.get().getInventoryDetails().getSkuProductDetails().getSkuPriceDetails().getPrice());
               om.setQuantity(orderDetails.get().getInventoryDetails().getQuantity());
               om.setStatus(pd.getStatus());
               OrderDetails ord = orderDetailsRepository.getById(orderDetails.get().getOrderCode());
               ord.setStatus(pd.getStatus());
               orderDetailsRepository.save(ord);
           return "ORDER PROCESSING";
       }}
       return "ORDER CODE DOES NOT EXIST";
   }

   public String getPacking(Integer orderCode){
       Optional<OrderDetails> orderDetails = orderDetailsRepository.findById(orderCode);
       if(orderDetails.isPresent()){
           if("PROCESSING".equalsIgnoreCase(orderDetails.get().getStatus())){
               PackingDetails pd = new PackingDetails();
               pd.setOrderCode(orderCode);
               pd.setStatus("PACKING");
               packingDetailsRepository.save(pd);
               OrderModel od = new OrderModel();
               od.setProductCode(orderDetails.get().getInventoryDetails().getSkuProductDetails().getProductDetails().getProductCode());
               od.setProductName(orderDetails.get().getInventoryDetails().getSkuProductDetails().getProductDetails().getProductName());
               od.setSkuCode(orderDetails.get().getInventoryDetails().getSkuProductDetails().getSkuCode());
               od.setSize(orderDetails.get().getInventoryDetails().getSkuProductDetails().getSize());
               od.setPrice(orderDetails.get().getInventoryDetails().getSkuProductDetails().getSkuPriceDetails().getPrice());
               od.setQuantity(orderDetails.get().getInventoryDetails().getQuantity());
               od.setStatus(pd.getStatus());
               OrderDetails ord = orderDetailsRepository.getById(orderDetails.get().getOrderCode());
               ord.setStatus(pd.getStatus());
               orderDetailsRepository.save(ord);
               return "PRODUCT PACKING";
           }
       }
       return "ORDER CODE DOES NOT EXIST";
   }

    public String getShipping(Integer orderCode){
        Optional<OrderDetails> orderDetails = orderDetailsRepository.findById(orderCode);
        if(orderDetails.isPresent()){
            if("PACKING".equalsIgnoreCase(orderDetails.get().getStatus())){
                ShippingDetails sd = new ShippingDetails();
                sd.setOrderCode(orderCode);
                sd.setStatus("SHIPPING");
                shippingDetailsRepository.save(sd);
                OrderModel od = new OrderModel();
                od.setProductCode(orderDetails.get().getInventoryDetails().getSkuProductDetails().getProductDetails().getProductCode());
                od.setProductName(orderDetails.get().getInventoryDetails().getSkuProductDetails().getProductDetails().getProductName());
                od.setSkuCode(orderDetails.get().getInventoryDetails().getSkuProductDetails().getSkuCode());
                od.setSize(orderDetails.get().getInventoryDetails().getSkuProductDetails().getSize());
                od.setPrice(orderDetails.get().getInventoryDetails().getSkuProductDetails().getSkuPriceDetails().getPrice());
                od.setQuantity(orderDetails.get().getInventoryDetails().getQuantity());
                od.setStatus(sd.getStatus());
                OrderDetails ord = orderDetailsRepository.getById(orderDetails.get().getOrderCode());
                ord.setStatus(sd.getStatus());
                orderDetailsRepository.save(ord);
                return "PRODUCT SHIPPING";
            }
        }
        return "ORDER CODE DOES NOT EXIST";
    }

    public String getDelivered(Integer orderCode){
        Optional<OrderDetails> orderDetails = orderDetailsRepository.findById(orderCode);
        if(orderDetails.isPresent()){
            if("SHIPPING".equalsIgnoreCase(orderDetails.get().getStatus())){
                DeliveredDetails dd = new DeliveredDetails();
                dd.setOrderCode(orderCode);
                dd.setStatus("DELIVERED");
                deliveredDetailsRepository.save(dd);
                OrderModel od = new OrderModel();
                od.setProductCode(orderDetails.get().getInventoryDetails().getSkuProductDetails().getProductDetails().getProductCode());
                od.setProductName(orderDetails.get().getInventoryDetails().getSkuProductDetails().getProductDetails().getProductName());
                od.setSkuCode(orderDetails.get().getInventoryDetails().getSkuProductDetails().getSkuCode());
                od.setSize(orderDetails.get().getInventoryDetails().getSkuProductDetails().getSize());
                od.setPrice(orderDetails.get().getInventoryDetails().getSkuProductDetails().getSkuPriceDetails().getPrice());
                od.setQuantity(orderDetails.get().getInventoryDetails().getQuantity());
                od.setStatus(dd.getStatus());
                OrderDetails ord = orderDetailsRepository.getById(orderDetails.get().getOrderCode());
                ord.setStatus(dd.getStatus());
                orderDetailsRepository.save(ord);
                return "PRODUCT DELIVERED";
            }
        }
        return "ORDER CODE DOES NOT EXIST";
    }

    public String getReturned(Integer orderCode){
       Optional<OrderDetails> orderDetails = orderDetailsRepository.findById(orderCode);
       if(orderDetails.isPresent()){
           if("DELIVERED".equalsIgnoreCase(orderDetails.get().getStatus())){
               ReturnedDetails rd = new ReturnedDetails();
               rd.setOrderCode(orderCode);
               rd.setStatus("RETURNED");
               returnedDetailsRepository.save(rd);
               InventoryDetails inventoryDetails=inventoryDetailsRepository.getById(orderDetails.get().getInventoryDetails().getSkuCode());
               inventoryDetails.setQuantity(orderDetails.get().getQuantity()+inventoryDetails.getQuantity());
               inventoryDetailsRepository.save(inventoryDetails);
               OrderModel od = new OrderModel();
               od.setProductCode(orderDetails.get().getInventoryDetails().getSkuProductDetails().getProductDetails().getProductCode());
               od.setProductName(orderDetails.get().getInventoryDetails().getSkuProductDetails().getProductDetails().getProductName());
               od.setSkuCode(orderDetails.get().getInventoryDetails().getSkuProductDetails().getSkuCode());
               od.setSize(orderDetails.get().getInventoryDetails().getSkuProductDetails().getSize());
               od.setPrice(orderDetails.get().getInventoryDetails().getSkuProductDetails().getSkuPriceDetails().getPrice());
               od.setQuantity(orderDetails.get().getInventoryDetails().getQuantity());
               od.setStatus(rd.getStatus());
               OrderDetails ord = orderDetailsRepository.getById(orderDetails.get().getOrderCode());
               ord.setStatus(rd.getStatus());
               orderDetailsRepository.save(ord);
               return "PRODUCT RETURNED";
           }
       }
       return "ORDER CODE DOES NOT EXIST";
    }
}
