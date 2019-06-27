package com.education.union.model;

public class MainOrder {
    private Integer id;

    private Integer userId;

    private Long price;

    private Integer status;

    private Integer sonOrderId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSonOrderId() {
        return sonOrderId;
    }

    public void setSonOrderId(Integer sonOrderId) {
        this.sonOrderId = sonOrderId;
    }
}