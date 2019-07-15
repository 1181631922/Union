package com.education.union.model;

public class ShoppingSonOrder {
    private Integer id;

    private Integer goodsId;

    private Integer status;

    private Long price;

    private Integer shoppingOrderId;

    private Boolean deleteStatus;

    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getShoppingOrderId() {
        return shoppingOrderId;
    }

    public void setShoppingOrderId(Integer shoppingOrderId) {
        this.shoppingOrderId = shoppingOrderId;
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}