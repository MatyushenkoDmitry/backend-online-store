package com.example.postgrescodefirst.Online.Store.repository;

import com.example.postgrescodefirst.Online.Store.model.ShoppingCartItem;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartItemRepository extends CrudRepository<ShoppingCartItem,Long> {
}
