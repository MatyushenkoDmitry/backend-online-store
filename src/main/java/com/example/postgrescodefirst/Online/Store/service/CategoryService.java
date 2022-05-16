package com.example.postgrescodefirst.Online.Store.service;

import com.example.postgrescodefirst.Online.Store.model.Category;
import com.example.postgrescodefirst.Online.Store.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CategoryService implements ICategoryService{


    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Category> findAll() {

        return  (List<Category>) categoryRepository.findAll() ;
    }

    @Override
    public Category find(int id) {
        try {
            return categoryRepository.findById(id).get();

        }
        catch (NoSuchElementException ex)
        {
            return new Category(0,"No Such Category" );
        }
    }

}
