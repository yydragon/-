package com.yan.cloud.mapper;

import com.yan.cloud.entity.TProduct;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 用于定义产品 Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2020-11-26
 */
public interface TProductMapper extends BaseMapper<TProduct> {

    void deleteBatchByIds(List<String> asList);
}
