package com.example.postgrescodefirst.Online.Store.service;

import com.example.postgrescodefirst.Online.Store.model.Category;

import java.util.List;

public interface ICategoryService {


    List<Category> findAll();

    Category find(int id);
}
