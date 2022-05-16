package com.example.postgrescodefirst.Online.Store.service;

import com.example.postgrescodefirst.Online.Store.model.Unit;

import java.util.List;

public interface IUnitService {


    List<Unit> findAll();

    Unit find(int id);
}
