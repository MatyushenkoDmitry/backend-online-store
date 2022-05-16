package com.example.postgrescodefirst.Online.Store.service;

import com.example.postgrescodefirst.Online.Store.model.ShoppingCart;
import com.example.postgrescodefirst.Online.Store.model.User;
import com.example.postgrescodefirst.Online.Store.repository.ShoppingCartRepository;
import com.example.postgrescodefirst.Online.Store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService implements IShoppingCartService{


    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<ShoppingCart> findAll()
    {

        return (List<ShoppingCart>) shoppingCartRepository.findAll();
    }


    //TODO:Включить в объект ShoppingCart список ShoppingCartItem для этой корзины.
    //TODO:Переделать процесс получения корзины по UserID через прямой запрос к базе данных.
    @Override
    public ShoppingCart findByUserId(long userId)

    {
        List<ShoppingCart> allCarts = (List<ShoppingCart>)shoppingCartRepository.findAll();

        ShoppingCart cartByUserId = null;

        for(ShoppingCart cart : allCarts)
        {
            if(cart.getUser().getId() == userId)
            {
                cartByUserId = cart;

                break;
            }
        }
        return cartByUserId;
    }


    @Override
    public ShoppingCart add(ShoppingCart cartToAdd)
    {
        shoppingCartRepository.save(cartToAdd);

        return cartToAdd;
    }


    @Override

    public ShoppingCart createForUser(long userId)
    {
        ShoppingCart cartForUser = new ShoppingCart();

        User userForCart = userRepository.findById(userId).get();

        cartForUser.setUser(userForCart);

        return add(cartForUser);
    }

}
