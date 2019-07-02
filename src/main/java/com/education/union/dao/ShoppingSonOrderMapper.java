package com.education.union.dao;

import com.education.union.model.ShoppingSonOrder;

public interface ShoppingSonOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShoppingSonOrder record);

    int insertSelective(ShoppingSonOrder record);

    ShoppingSonOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShoppingSonOrder record);

    int updateByPrimaryKey(ShoppingSonOrder record);
}