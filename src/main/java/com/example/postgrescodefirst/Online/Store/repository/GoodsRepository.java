package com.example.postgrescodefirst.Online.Store.repository;

import com.example.postgrescodefirst.Online.Store.model.Goods;
import org.springframework.data.repository.CrudRepository;

public interface GoodsRepository extends CrudRepository<Goods,Integer> {
}
