package com.example.postgrescodefirst.Online.Store.service;

import com.example.postgrescodefirst.Online.Store.model.Manufacturer;

import java.util.List;

public interface IManufacturerService {


    List<Manufacturer> findAll();

    Manufacturer find(int id);
}
