package com.example.postgrescodefirst.Online.Store.dto;


import java.math.BigDecimal;


public class GoodsAddDTO {

    private Integer category_id;

    private Integer manufacturer_id;

    private Integer unit_id;


    private  String name;

    private BigDecimal price;

    private  String picture_url;

    public GoodsAddDTO() {
    }

    public GoodsAddDTO(Integer category_id, Integer manufacturer_id, Integer unit_id, String name, BigDecimal price, String picture_url) {
        this.category_id = category_id;
        this.manufacturer_id = manufacturer_id;
        this.unit_id = unit_id;
        this.name = name;
        this.price = price;
        this.picture_url = picture_url;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public Integer getManufacturer_id() {
        return manufacturer_id;
    }

    public void setManufacturer_id(Integer manufacturer_id) {
        this.manufacturer_id = manufacturer_id;
    }

    public Integer getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(Integer unit_id) {
        this.unit_id = unit_id;
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
