package com.example.postgrescodefirst.Online.Store.repository;

import com.example.postgrescodefirst.Online.Store.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Integer> {
}
