package com.yan.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yan.cloud.entity.Query;
import com.yan.cloud.entity.TEquipment;
import com.yan.cloud.entity.TProduct;
import com.yan.cloud.mapper.TEquipmentMapper;
import com.yan.cloud.service.TEquipmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 设备表 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-11-26
 */
@Service
public class TEquipmentServiceImpl extends ServiceImpl<TEquipmentMapper, TEquipment> implements TEquipmentService {

    @Override
    public IPage getEquipmentList(Integer val) {
        Page<TEquipment> page = new Page<>(val,10);
        IPage<TEquipment> selectPage = baseMapper.selectPage(page, null);
        return selectPage;
    }

    @Override
    public void addEquipment(TEquipment equipment) {
        equipment.setEquipmentSeq(UUID.randomUUID().toString().substring(0,4));
        equipment.setIsDelete(0);
        baseMapper.insert(equipment);
    }

    @Override
    public void deleteEquipment(String equipmentSeq) {
        baseMapper.delete(new QueryWrapper<TEquipment>().eq("equipment_seq",equipmentSeq));
    }

    @Override
    public void editEquipment(TEquipment equipment) {
        baseMapper.update(equipment,new QueryWrapper<TEquipment>().eq("equipment_seq",equipment.getEquipmentSeq()));
    }

    @Override
    public void deleteBatch(List<String> asList) {
        baseMapper.deleteBatchByIds(asList);

    }

    @Override
    public IPage getQueryList(Query query) {
        Page<TEquipment> page = new Page<>(1,10);
        QueryWrapper<TEquipment> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(query.getFlag())){
            wrapper.like("equipment_name",query.getName());
        wrapper.and(wrapper1->wrapper1.eq("flag",query.getFlag()));
        }else{
            wrapper.like("equipment_name",query.getName());
        }

//        wrapper.and(wrapper1->wrapper1.eq("flag",query.getFlag()));
        IPage<TEquipment> iPage = baseMapper.selectPage(page, wrapper);
        return iPage;
    }

    @Override
    public IPage getSelectQuery(Integer val) {
        Page<TEquipment> page = new Page<>(1,10);
        IPage<TEquipment> iPage = baseMapper.selectPage(page, new QueryWrapper<TEquipment>().eq("equipment_status", val));
        return iPage;
    }

    @Override
    public List getAllEquipment() {
        List<TEquipment> equipments = baseMapper.selectList(new QueryWrapper<TEquipment>().eq("equipment_status", 10));
        return equipments;
    }
}
