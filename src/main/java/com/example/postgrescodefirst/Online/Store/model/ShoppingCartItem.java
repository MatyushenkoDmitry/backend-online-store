package com.example.postgrescodefirst.Online.Store.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="shopping_cart_items")
public class ShoppingCartItem implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "cart_id",referencedColumnName = "id")
    private ShoppingCart shoppingCart;



    @ManyToOne
    @JoinColumn(name = "goods_id",referencedColumnName = "id")
    private Goods goods;

    private Integer quantity;

    public ShoppingCartItem() {
    }

    public ShoppingCartItem(Long id, ShoppingCart shoppingCart, Goods goods, Integer quantity) {
        this.id = id;
        this.shoppingCart = shoppingCart;
        this.goods = goods;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCartItem cartItem = (ShoppingCartItem) o;
        return Objects.equals(id, cartItem.id) && Objects.equals(shoppingCart, cartItem.shoppingCart) && Objects.equals(goods, cartItem.goods) && Objects.equals(quantity, cartItem.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shoppingCart, goods, quantity);
    }

    @Override
    public String toString() {
        return "ShoppingCartItem{" +
                "id=" + id +
                ", shoppingCart=" + shoppingCart +
                ", goods=" + goods +
                ", quantity=" + quantity +
                '}';
    }
}
