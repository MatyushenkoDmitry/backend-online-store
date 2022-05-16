package com.example.postgrescodefirst.Online.Store.service;

import com.example.postgrescodefirst.Online.Store.dto.AddToCartDTO;
import com.example.postgrescodefirst.Online.Store.dto.DeleteFromCartDTO;
import com.example.postgrescodefirst.Online.Store.model.ShoppingCart;
import com.example.postgrescodefirst.Online.Store.model.ShoppingCartItem;
import com.example.postgrescodefirst.Online.Store.repository.ShoppingCartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ShoppingCartItemService implements IShoppingCartItemService{


    @Autowired
    private IShoppingCartService shoppingCartService;


    @Autowired
    private ShoppingCartItemRepository shoppingCartItemRepository;

    @Autowired
    private IGoodsService goodsService;



    @Override
    public Iterable<ShoppingCartItem> addToCart(AddToCartDTO addToCartDTO)
    {

        ShoppingCart userCart = shoppingCartService.findByUserId(addToCartDTO.getUser_id());


        if (userCart == null)

            userCart = shoppingCartService.createForUser(addToCartDTO.getUser_id());


        ShoppingCartItem itemByUserAndGoods = getByUserIdByGoodsId(addToCartDTO.getUser_id(),addToCartDTO.getGoods_id());


        if (itemByUserAndGoods == null) {

            ShoppingCartItem itemToAdd = new ShoppingCartItem();

            itemToAdd.setShoppingCart(userCart);
            itemToAdd.setGoods(goodsService.find(addToCartDTO.getGoods_id()));
            itemToAdd.setQuantity(addToCartDTO.getQuantity());


            shoppingCartItemRepository.save(itemToAdd);
        }
        else
        {

            itemByUserAndGoods.setQuantity(itemByUserAndGoods.getQuantity() + addToCartDTO.getQuantity());
            shoppingCartItemRepository.save(itemByUserAndGoods);
        }
        List<ShoppingCartItem> itemsByUser = getAllByUserId(addToCartDTO.getUser_id());

        return itemsByUser;
    }

    @Override
    public Iterable<ShoppingCartItem> deleteFromCart(DeleteFromCartDTO deleteFromCartDTO) {


        ShoppingCart userCart = shoppingCartService.findByUserId(deleteFromCartDTO.getUser_id());


        if (userCart == null)

            return new ArrayList<ShoppingCartItem>();



        ShoppingCartItem itemByUserAndGoods = getByUserIdByGoodsId(deleteFromCartDTO.getUser_id(), deleteFromCartDTO.getGoods_id());


        if (itemByUserAndGoods != null) {


            itemByUserAndGoods.setQuantity(itemByUserAndGoods.getQuantity() - deleteFromCartDTO.getQuantity());


            if (itemByUserAndGoods.getQuantity() <= 0)
            {
                shoppingCartItemRepository.delete(itemByUserAndGoods);
            }

            else
            {
                shoppingCartItemRepository.save(itemByUserAndGoods);
            }

        }

        List<ShoppingCartItem> itemsByUser = getAllByUserId(deleteFromCartDTO.getUser_id());

        return itemsByUser;
    }

    @Override
    public Iterable<ShoppingCartItem> ByUserId(long userId)
    {
        return getAllByUserId(userId);
    }



    private List<ShoppingCartItem> getAllByUserId(long userId)
    {


        ShoppingCart userCart = shoppingCartService.findByUserId(userId);


        List<ShoppingCartItem> allCartItems = (List<ShoppingCartItem>) shoppingCartItemRepository.findAll();


        List<ShoppingCartItem> itemsByUser = new ArrayList<ShoppingCartItem>();



        for (ShoppingCartItem cartItem : allCartItems) {


            if (cartItem.getShoppingCart().getId() == userCart.getId())
            {
                itemsByUser.add(cartItem);
            }
        }
        return  itemsByUser;
    }


    //TODO:Переделать поиск товара  в корзине пользователя на прямой запрос к базе данных.


    private ShoppingCartItem getByUserIdByGoodsId(long userId, int goodsId) {

        ShoppingCartItem itemByUserAndGoods = null;


        ShoppingCart userCart = shoppingCartService.findByUserId(userId);


        List<ShoppingCartItem> allCartItems = (List<ShoppingCartItem>) shoppingCartItemRepository.findAll();


        for (ShoppingCartItem cartItem : allCartItems) {
            if (

                    cartItem.getShoppingCart().getId() == userCart.getId() &&
                            cartItem.getGoods().getId() == goodsId
            )
            {

                itemByUserAndGoods = cartItem;


                break;
            }
        }
        return itemByUserAndGoods;
    }
}
