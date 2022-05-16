package com.example.postgrescodefirst.Online.Store.service;


import com.example.postgrescodefirst.Online.Store.dto.GoodsAddDTO;
import com.example.postgrescodefirst.Online.Store.dto.GoodsEditDTO;
import com.example.postgrescodefirst.Online.Store.model.Category;
import com.example.postgrescodefirst.Online.Store.model.Goods;
import com.example.postgrescodefirst.Online.Store.model.Manufacturer;
import com.example.postgrescodefirst.Online.Store.model.Unit;
import com.example.postgrescodefirst.Online.Store.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GoodsService implements IGoodsService {


    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IManufacturerService manufacturerService;

    @Autowired
    private IUnitService unitService;


    @Override
    public List<Goods> findAll() {
        return (List<Goods>) goodsRepository.findAll();
    }

    @Override
    public Goods find(int id) {

        try {
            return goodsRepository.findById(id).get();

        } catch (Exception ex) {
            Goods noSuchGoods = new Goods(
                    id,
                    new Category(0, "No Such Category"),
                    new Manufacturer(0, "No Such Manufacturer"),
                    new Unit(0, "No Such Unit"),
                    "No Such name",
                    new BigDecimal(0.00),
                    ""
            );
            return noSuchGoods;
        }

    }

    @Override
    public boolean edit(GoodsEditDTO goodsToEditDTO) {

        Goods goodsToUpdate;
        try {
            goodsToUpdate = goodsRepository.findById(goodsToEditDTO.getId()).get();

            goodsToUpdate.setCategory(categoryService.find(goodsToEditDTO.getCategory_id()));
            goodsToUpdate.setManufacturer(manufacturerService.find(goodsToEditDTO.getManufacturer_id()));
            goodsToUpdate.setUnit(unitService.find(goodsToEditDTO.getUnit_id()));

            goodsToUpdate.setName(goodsToEditDTO.getName());
            goodsToUpdate.setPrice(goodsToEditDTO.getPrice());
            goodsToUpdate.setPicture_url(goodsToEditDTO.getPicture_url());

            goodsRepository.save(goodsToUpdate);
            return true;

        } catch (NoSuchElementException ex) {
            return false;
        }
    }


    @Override
    public boolean delete(int id) {
        Goods goodsToDelete;

        try {
            goodsToDelete = goodsRepository.findById(id).get();
            goodsRepository.delete(goodsToDelete);
            return true;

        } catch (NoSuchElementException ex) {

            return false;
        }
    }

    @Override
    public Goods add(GoodsAddDTO newGoodsDTO)
    {

        Goods newGoods = new Goods();

        newGoods.setCategory(categoryService.find(newGoodsDTO.getCategory_id()));
        newGoods.setManufacturer(manufacturerService.find(newGoodsDTO.getManufacturer_id()));
        newGoods.setUnit(unitService.find(newGoodsDTO.getUnit_id()));
        newGoods.setName(newGoodsDTO.getName());
        newGoods.setPrice(newGoodsDTO.getPrice());
        newGoods.setPicture_url(newGoodsDTO.getPicture_url());

        goodsRepository.save(newGoods);
        return newGoods;
    }

}

