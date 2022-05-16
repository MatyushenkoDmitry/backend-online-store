package com.example.postgrescodefirst.Online.Store.service;

import com.example.postgrescodefirst.Online.Store.dto.AddToCartDTO;
import com.example.postgrescodefirst.Online.Store.dto.DeleteFromCartDTO;
import com.example.postgrescodefirst.Online.Store.model.ShoppingCartItem;

public interface IShoppingCartItemService {

    Iterable<ShoppingCartItem> addToCart(AddToCartDTO addToCartDTO);

    Iterable<ShoppingCartItem> deleteFromCart(DeleteFromCartDTO deleteFromCartDTO);

    Iterable<ShoppingCartItem> ByUserId(long userId);
}
