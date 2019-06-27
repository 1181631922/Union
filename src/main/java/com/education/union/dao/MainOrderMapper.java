package com.education.union.dao;

import com.education.union.model.MainOrder;

public interface MainOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MainOrder record);

    int insertSelective(MainOrder record);

    MainOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MainOrder record);

    int updateByPrimaryKey(MainOrder record);
}