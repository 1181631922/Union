package com.education.union.dao;

import com.education.union.model.ClassSupplier;

public interface ClassSupplierMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ClassSupplier record);

    int insertSelective(ClassSupplier record);

    ClassSupplier selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClassSupplier record);

    int updateByPrimaryKey(ClassSupplier record);
}