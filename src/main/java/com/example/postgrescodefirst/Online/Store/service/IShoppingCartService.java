package com.example.postgrescodefirst.Online.Store.service;

import com.example.postgrescodefirst.Online.Store.model.ShoppingCart;

import java.util.List;

public interface IShoppingCartService {

    List<ShoppingCart> findAll();

    ShoppingCart findByUserId(long userId);

    ShoppingCart add(ShoppingCart cartToAdd);

    ShoppingCart createForUser(long userId);

}
