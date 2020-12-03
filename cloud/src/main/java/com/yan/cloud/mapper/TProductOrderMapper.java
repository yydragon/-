package com.yan.cloud.mapper;

import com.yan.cloud.entity.TProductOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2020-11-26
 */
public interface TProductOrderMapper extends BaseMapper<TProductOrder> {

    void deleteBatchByIds(List<String> asList);


}
