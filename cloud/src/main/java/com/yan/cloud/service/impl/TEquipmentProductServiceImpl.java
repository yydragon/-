package com.yan.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yan.cloud.entity.TEquipment;
import com.yan.cloud.entity.TEquipmentProduct;
import com.yan.cloud.entity.TProduct;
import com.yan.cloud.entity.TProductOrder;
import com.yan.cloud.mapper.TEquipmentMapper;
import com.yan.cloud.mapper.TEquipmentProductMapper;
import com.yan.cloud.mapper.TProductMapper;
import com.yan.cloud.service.TEquipmentProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 设备与产品对应表 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-11-26
 */
@Service
public class TEquipmentProductServiceImpl extends ServiceImpl<TEquipmentProductMapper, TEquipmentProduct> implements TEquipmentProductService {

    @Resource
    private TProductMapper productMapper;

    @Resource
    private TEquipmentMapper equipmentMapper;

    @Override
    public IPage getList(Integer val) {
        Page<TEquipmentProduct> page = new Page<>(val,10);
        IPage<TEquipmentProduct> list = baseMapper.selectPage(page, null);
        return list;
    }

    @Override
    public void addForm(TEquipmentProduct form) {
        TProduct product = productMapper.selectOne(new QueryWrapper<TProduct>().eq("product_num",form.getProductId()));
        TEquipment equipment = equipmentMapper.selectOne(new QueryWrapper<TEquipment>().eq("equipment_seq", form.getEquipmentId()));
        System.out.println(form);
        form.setProductImgUrl(product.getProductImgUrl());
        form.setEquipmentImgUrl(equipment.getEquipmentImgUrl());
        form.setProductName(product.getProductName());
        form.setEquipmentName(equipment.getEquipmentName());
        form.setIsDelete(0);
        baseMapper.insert(form);
    }

    @Override
    public void deleteProductEquipmentLink(TEquipmentProduct record) {
        baseMapper.deleteById(record.getId());
    }

    @Override
    public IPage queryResult(String val) {
        Page<TEquipmentProduct> page = new Page<>(1,10);
        IPage<TEquipmentProduct> list = baseMapper.selectPage(page,new QueryWrapper<TEquipmentProduct>().like("product_name", val).or().like("equipment_name", val));
        return list;
    }

    @Override
    public void deleteBatch(List<String> asList) {
        baseMapper.deleteBatchIds(asList);
    }
}
