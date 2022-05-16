package com.example.postgrescodefirst.Online.Store.service;

import com.example.postgrescodefirst.Online.Store.dto.UserDTO;
import com.example.postgrescodefirst.Online.Store.model.User;

import java.util.List;

public interface IUserService {


    List<UserDTO> findAll();

    UserDTO find(long id);

    User add(User newUser);

    boolean edit(User userToEdit);

    boolean delete(long id);
}
