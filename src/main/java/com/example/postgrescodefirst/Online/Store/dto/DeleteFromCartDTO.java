package com.example.postgrescodefirst.Online.Store.dto;



public class DeleteFromCartDTO {

    private Long user_id;

    private Integer goods_id;

    private Integer quantity;

    public DeleteFromCartDTO() {
    }

    public DeleteFromCartDTO(Long user_id, Integer goods_id, Integer quantity) {
        this.user_id = user_id;
        this.goods_id = goods_id;
        this.quantity = quantity;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
