package com.example.postgrescodefirst.Online.Store.mapper;


import com.example.postgrescodefirst.Online.Store.dto.UserDTO;
import com.example.postgrescodefirst.Online.Store.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static UserDTO dtoFromUser(User user)
    {
        return new UserDTO(
                user.getId(),
                user.getName()
        );

    }
    public static List<UserDTO> dtoFromUser(List<User> users)
    {
        List<UserDTO> userDTOs = new ArrayList<UserDTO>();

        for (User user: users)
        {

            userDTOs.add(dtoFromUser(user));
        }
        return userDTOs;
    }
}
