package com.example.postgrescodefirst.Online.Store.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name="goods")
public class Goods implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;



    @ManyToOne
    @JoinColumn(name = "manufacturer_id",referencedColumnName = "id")
    private Manufacturer manufacturer;



    @ManyToOne
    @JoinColumn(name = " unit_id",referencedColumnName = "id")
    private Unit unit;


    private  String name;

    private BigDecimal price;

    private  String picture_url;

    public Goods() {
    }

    public Goods(Integer id, Category category, Manufacturer manufacturer, Unit unit, String name, BigDecimal price, String picture_url) {
        this.id = id;
        this.category = category;
        this.manufacturer = manufacturer;
        this.unit = unit;
        this.name = name;
        this.price = price;
        this.picture_url = picture_url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return Objects.equals(id, goods.id) && Objects.equals(name, goods.name) && Objects.equals(price, goods.price) && Objects.equals(picture_url, goods.picture_url) && Objects.equals(category, goods.category) && Objects.equals(manufacturer, goods.manufacturer) && Objects.equals(unit, goods.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, picture_url, category, manufacturer, unit);
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", category=" + category +
                ", manufacturer=" + manufacturer +
                ", unit=" + unit +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", picture_url='" + picture_url + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }


}
