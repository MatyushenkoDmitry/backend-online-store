package com.example.postgrescodefirst.Online.Store.service;


import com.example.postgrescodefirst.Online.Store.dto.GoodsAddDTO;
import com.example.postgrescodefirst.Online.Store.dto.GoodsEditDTO;
import com.example.postgrescodefirst.Online.Store.model.Goods;


import java.util.List;

public interface IGoodsService {


    List<Goods> findAll();

    Goods find(int id);

    Goods add(GoodsAddDTO newGoodsDTO);

    boolean edit(GoodsEditDTO goodsToEdit);

    boolean delete(int id);
}
