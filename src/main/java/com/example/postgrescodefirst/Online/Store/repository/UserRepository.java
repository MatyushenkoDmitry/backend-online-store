package com.example.postgrescodefirst.Online.Store.repository;

import com.example.postgrescodefirst.Online.Store.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
