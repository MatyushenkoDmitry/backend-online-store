package com.example.postgrescodefirst.Online.Store.controller;


import com.example.postgrescodefirst.Online.Store.dto.AddToCartDTO;
import com.example.postgrescodefirst.Online.Store.dto.DeleteFromCartDTO;
import com.example.postgrescodefirst.Online.Store.model.ShoppingCartItem;
import com.example.postgrescodefirst.Online.Store.service.IShoppingCartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartItemsController {


    @Autowired
    private IShoppingCartItemService cartItemService;



    @GetMapping("/cartitems/{userId}")
    public Iterable <ShoppingCartItem>  cartItemsByUserId(@PathVariable(name ="userId")long userId)
    {
        return cartItemService.ByUserId(userId);
    }




    @PostMapping("/cartitems")
    public Iterable  <ShoppingCartItem> addToCart(@RequestBody AddToCartDTO addToCartDTO)
    {
        return cartItemService.addToCart(addToCartDTO);
    }


    @DeleteMapping ("/cartitems")
    public Iterable  <ShoppingCartItem> deleteFromCart(@RequestBody DeleteFromCartDTO deleteFromCartDTO)
    {
        return cartItemService.deleteFromCart(deleteFromCartDTO);

    }



}
