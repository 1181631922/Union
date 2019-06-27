package com.education.union.dao;

import com.education.union.model.SupplierOrder;

public interface SupplierOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SupplierOrder record);

    int insertSelective(SupplierOrder record);

    SupplierOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SupplierOrder record);

    int updateByPrimaryKey(SupplierOrder record);
}