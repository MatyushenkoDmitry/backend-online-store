package com.example.postgrescodefirst.Online.Store.service;

import com.example.postgrescodefirst.Online.Store.dto.UserDTO;
import com.example.postgrescodefirst.Online.Store.mapper.UserMapper;
import com.example.postgrescodefirst.Online.Store.model.User;
import com.example.postgrescodefirst.Online.Store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<UserDTO> findAll() {

        List<User> allUsers = (List<User>) userRepository.findAll();

        return UserMapper.dtoFromUser(allUsers);
    }


    @Override
    public UserDTO find(long id) {

        try {

            User userById = userRepository.findById(id).get();


            return UserMapper.dtoFromUser(userById);

        }
        catch (NoSuchElementException ex)
        {


            return new UserDTO(
                    0L,
                    "No Such User"
            );
        }

    }

    @Override
    public User add(User newUser) {

        User addUser = userRepository.save(newUser);
        return addUser;
    }

    @Override
    public boolean edit(User userToEdit) {


        User userToUpdate;

        try {
            // ищим нашего user с помощью  userRepository.findById(id).get();
            //  userToUpdate это сущность связаная с базой данных.
            // userToUpdate (сущность ДБ) связываем  через userRepository userToEdit.

            userToUpdate = userRepository.findById( userToEdit.getId()).get();

            userToUpdate.setName(userToEdit.getName());
            userToUpdate.setLogin(userToEdit.getLogin());
            userToUpdate.setPassword(userToEdit.getPassword());

            userRepository.save(userToUpdate); // если мы его нашли то возвращаем true;Наш метод вызова тип boolean;

            return true;
        }
        catch (NoSuchElementException ex)
        {
            return false;
        }
    }

    @Override
    public boolean delete(long id){

        User userToDelete;

        try {
            // ищим нашего user с помощью  userRepository.findById(id).get();

            userToDelete = userRepository.findById(id).get();

            userRepository.delete(userToDelete); // если мы его нашли то возвращаем true;Наш метод вызова boolean;

            return true;
        }

        catch (NoSuchElementException ex) {
            return false;
        }
    }
}
