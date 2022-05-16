package com.example.postgrescodefirst.Online.Store.controller;


import com.example.postgrescodefirst.Online.Store.dto.UserDTO;
import com.example.postgrescodefirst.Online.Store.model.User;
import com.example.postgrescodefirst.Online.Store.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {


    @Autowired
    private IUserService userService;

    @GetMapping("/users")
    public Iterable<UserDTO> getAllUsers()
    {
        return userService.findAll();
    }



    @GetMapping("/users/{id}")
    public UserDTO getById(@PathVariable(name = "id")long id)
    {
        return  userService.find(id);
    }



    @PostMapping("/users")
    public User addUser(@RequestBody User newUser)
    {
        return userService.add(newUser);
    }


    @DeleteMapping("/users/{id}")
    public boolean deleteUser(@PathVariable(name = "id") long id)
    {
        return userService.delete(id);
    }


    @PutMapping ("/users")
    public boolean editUser(@RequestBody User updateUser)
    {
        return userService.edit( updateUser);
    }
}
