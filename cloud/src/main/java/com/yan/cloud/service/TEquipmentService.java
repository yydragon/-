package com.yan.cloud.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yan.cloud.entity.Query;
import com.yan.cloud.entity.TEquipment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 设备表 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-11-26
 */
public interface TEquipmentService extends IService<TEquipment> {

    IPage getEquipmentList(Integer val);

    void addEquipment(TEquipment equipment);

    void deleteEquipment(String equipmentSeq);

    void editEquipment(TEquipment equipment);

    void deleteBatch(List<String> asList);

    IPage getQueryList(Query query);

    IPage getSelectQuery(Integer val);

    List getAllEquipment();
}
