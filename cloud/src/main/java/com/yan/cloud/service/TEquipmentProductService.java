package com.yan.cloud.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yan.cloud.entity.TEquipmentProduct;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yan.cloud.entity.TProductOrder;

import java.util.List;

/**
 * <p>
 * 设备与产品对应表 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-11-26
 */
public interface TEquipmentProductService extends IService<TEquipmentProduct> {

    IPage getList(Integer val);

    void addForm(TEquipmentProduct form);

    void deleteProductEquipmentLink(TEquipmentProduct record);

    IPage queryResult(String val);

    void deleteBatch(List<String> asList);
}
