package com.education.union.dao;

import com.education.union.model.Image;

public interface ImageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Image record);

    int insertSelective(Image record);

    Image selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Image record);

    int updateByPrimaryKey(Image record);
}