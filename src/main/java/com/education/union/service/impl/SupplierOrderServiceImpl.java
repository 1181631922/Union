package com.education.union.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.education.union.dao.SupplierOrderMapper;
import com.education.union.model.SupplierOrder;
import com.education.union.service.SupplierOrderService;
import com.education.union.util.CommonUtil;
import com.education.union.util.SnowflakeUtil;
import com.education.union.util.constants.ErrorEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Author： fanyafeng
 * Data： 2019-06-28 22:17
 * Email: fanyafeng@live.cn
 */
@Service
public class SupplierOrderServiceImpl implements SupplierOrderService {

    @Resource
    private SupplierOrderMapper supplierOrderMapper;

    /**
     * 添加用户订单
     * 用户订单添加需要绑定用户id
     * 需要传入商品id
     * 手动生成创建时间和更新时间
     * 生成唯一订单id
     *
     * @param jsonObject
     */
    @Override
    public JSONObject addSupplierOrder(JSONObject jsonObject) {
        try {
            SupplierOrder supplierOrder=new SupplierOrder();
            supplierOrder.setUserId(jsonObject.getIntValue("userId"));
            supplierOrder.setSupplierId(jsonObject.getIntValue("supplierId"));
            supplierOrder.setCreateTime(new Date());
            supplierOrder.setUpdateTime(new Date());
            supplierOrder.setSupplierOrderId(SnowflakeUtil.getInstanceSnowflake().nextId());
            supplierOrder.setTimeStatus(50000);
            supplierOrder.setStatus(50000);
            supplierOrderMapper.insertSelective(supplierOrder);
            return CommonUtil.successJson();
        } catch (Exception e) {
//            e.printStackTrace();
            return CommonUtil.errorJson(ErrorEnum.E_400);
        }
    }
}
