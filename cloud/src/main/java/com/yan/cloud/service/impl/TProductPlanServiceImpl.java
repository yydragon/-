package com.yan.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yan.cloud.entity.TProductOrder;
import com.yan.cloud.entity.TProductPlan;
import com.yan.cloud.mapper.TProductOrderMapper;
import com.yan.cloud.mapper.TProductPlanMapper;
import com.yan.cloud.service.TProductPlanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 生产计划表 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-11-26
 */
@Service
public class TProductPlanServiceImpl extends ServiceImpl<TProductPlanMapper, TProductPlan> implements TProductPlanService {

    @Resource
    private TProductOrderMapper orderMapper;
    @Override
    public IPage getPlanList(Integer val) {
        Page<TProductPlan> page = new Page<>(val,10);
        IPage<TProductPlan> iPage = baseMapper.selectPage(page, null);
        return iPage;
    }

    @Override
    public void editPlanById(TProductPlan plan) {
        baseMapper.updateById(plan);
    }

    @Override
    public void deletePlan(Integer id) {
        baseMapper.deleteById(id);
    }

    @Override
    public void addPlan(TProductPlan plan) {
        TProductOrder order = orderMapper.selectOne(new QueryWrapper<TProductOrder>().eq("order_seq", plan.getOrderId()));
        Date endDate = order.getEndDate();

        plan.setDeliveryDate(endDate);
        plan.setPlanSeq(UUID.randomUUID().toString().substring(0,4));
        plan.setIsDelete(0);
        baseMapper.insert(plan);


    }

    @Override
    public void deleteBatch(List<String> asList) {
        baseMapper.deleteBatchIds(asList);
    }

    @Override
    public IPage getSelectQuery(Integer val) {
        Page<TProductPlan> page = new Page<>(1,10);
        IPage<TProductPlan> iPage = baseMapper.selectPage(page, new QueryWrapper<TProductPlan>().eq("plan_status", val));
        return iPage;
    }

    @Override
    public void updatePlanStatusBySwitch(TProductPlan planStatus) {
        baseMapper.updateById(planStatus);
    }
}
