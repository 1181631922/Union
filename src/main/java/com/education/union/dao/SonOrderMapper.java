package com.education.union.dao;

import com.education.union.model.SonOrder;

public interface SonOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SonOrder record);

    int insertSelective(SonOrder record);

    SonOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SonOrder record);

    int updateByPrimaryKey(SonOrder record);
}