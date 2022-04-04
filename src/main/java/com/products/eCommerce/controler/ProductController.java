package com.products.eCommerce.controler;

import com.products.eCommerce.entity.CartDetails;
import com.products.eCommerce.entity.OrderDetails;
import com.products.eCommerce.entity.ProcessingDetails;
import com.products.eCommerce.model.CartModel;
import com.products.eCommerce.model.OrderModel;
import com.products.eCommerce.model.ProductModel;
import com.products.eCommerce.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private FulfilmentService fulfilmentService;


    @RequestMapping(value = "/add/product",method = RequestMethod.POST)
    public void add(@RequestBody ProductModel productModel){
        productService.addProduct(productModel);
    }

    @RequestMapping(value = "/add/{skuCode}/{quantity}",method = RequestMethod.POST)
    public String add(@PathVariable Integer skuCode, @PathVariable Integer quantity){
        return inventoryService.addInventory(skuCode,quantity);
    }

    @RequestMapping(value = "/add/cart/{cartCode}/{quantity}",method = RequestMethod.POST)
    public String addCart(@PathVariable Integer cartCode,@PathVariable Integer quantity){
        return cartService.addCart(cartCode, quantity);
    }

    @RequestMapping(value = "/viewCart",method = RequestMethod.GET)
    public List<CartModel> viewCart(CartDetails cr){
        return cartService.viewCart(cr);
    }

    @RequestMapping(value = "/add/order/{skuCode}/{quantity}",method = RequestMethod.POST)
    public String addOrd(@PathVariable Integer skuCode,@PathVariable Integer quantity){
        return orderService.addOrder(skuCode,quantity);
    }

    @RequestMapping(value = "/get/status/{orderCode}",method = RequestMethod.GET)
    public OrderModel getOrd(@PathVariable Integer orderCode){
        return orderService.getOrder(orderCode);
    }

    @RequestMapping(value = "/get/process/{orderCode}",method = RequestMethod.GET)
    public String getPro(@PathVariable Integer orderCode){
        return fulfilmentService.getProcess(orderCode);
    }

    @RequestMapping(value = "/get/packing/{orderCode}",method = RequestMethod.GET)
    public String getPack(@PathVariable Integer orderCode){
        return fulfilmentService.getPacking(orderCode);
    }

    @RequestMapping(value = "/get/shipping/{orderCode}",method = RequestMethod.GET)
    public String getShip(@PathVariable Integer orderCode){
        return fulfilmentService.getShipping(orderCode);
    }

    @RequestMapping(value = "/get/delivered/{orderCode}",method = RequestMethod.GET)
    public String getDeliver(@PathVariable Integer orderCode){
        return fulfilmentService.getDelivered(orderCode);
    }

    @RequestMapping(value = "/get/returned/{orderCode}",method = RequestMethod.GET)
    public String getReturn(@PathVariable Integer orderCode){
        return fulfilmentService.getReturned(orderCode);
    }

}
