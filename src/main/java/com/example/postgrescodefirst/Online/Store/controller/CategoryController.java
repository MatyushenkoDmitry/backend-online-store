package com.example.postgrescodefirst.Online.Store.controller;


import com.example.postgrescodefirst.Online.Store.model.Category;
import com.example.postgrescodefirst.Online.Store.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;




    @GetMapping("/categories")
    public Iterable<Category> getAllCategories()
    {
        return categoryService.findAll();
    }


    @GetMapping("/categories/{id}")
    public Category getById(@PathVariable(name = "id") int id)
    {
        return categoryService.find(id);
    }




}
