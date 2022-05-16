package com.example.postgrescodefirst.Online.Store.controller;


import com.example.postgrescodefirst.Online.Store.dto.GoodsAddDTO;
import com.example.postgrescodefirst.Online.Store.dto.GoodsEditDTO;
import com.example.postgrescodefirst.Online.Store.model.Goods;
import com.example.postgrescodefirst.Online.Store.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;



    @GetMapping("/goods")
    public Iterable<Goods> getAllGoods()
    {
        return goodsService.findAll();
    }


    @GetMapping("/goods/{id}")
    public Goods getById(@PathVariable(name = "id")int id)
    {
        return goodsService.find(id);
    }


    @PostMapping("/goods")
    public Goods addGoods(@RequestBody GoodsAddDTO newGoodsDTO)
    {
        return goodsService.add(newGoodsDTO);
    }


    @DeleteMapping("/goods/{id}")
    public boolean deleteGoods(@PathVariable(name = "id") int id)
    {
        return goodsService.delete(id);
    }



    @PutMapping ("/goods")
    public boolean editGoods(@RequestBody GoodsEditDTO updateGoods)
    {
        return goodsService.edit(updateGoods);
    }

}
