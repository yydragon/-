package com.yan.cloud.mapper;

import com.yan.cloud.entity.TEquipment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 设备表 Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2020-11-26
 */
public interface TEquipmentMapper extends BaseMapper<TEquipment> {

    void deleteBatchByIds(List<String> asList);
}
