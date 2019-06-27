package com.education.union.dao;

import com.education.union.model.BuyGoods;

public interface BuyGoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BuyGoods record);

    int insertSelective(BuyGoods record);

    BuyGoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BuyGoods record);

    int updateByPrimaryKey(BuyGoods record);
}