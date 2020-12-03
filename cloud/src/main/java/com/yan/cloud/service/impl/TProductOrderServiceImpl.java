package com.yan.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yan.cloud.entity.*;
import com.yan.cloud.mapper.TProductMapper;
import com.yan.cloud.mapper.TProductOrderMapper;
import com.yan.cloud.service.TProductOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yan.cloud.service.TProductPlanService;
import com.yan.cloud.service.TProductScheduleService;
import com.yan.cloud.service.TProductService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-11-26
 */
@Service
public class TProductOrderServiceImpl extends ServiceImpl<TProductOrderMapper, TProductOrder> implements TProductOrderService {

    @Resource
    private TProductMapper productMapper;

    @Resource
    TProductPlanService planService;

    @Resource
    TProductScheduleService scheduleService;

    @Override
    public IPage getOrderList(Integer val) {
        Page<TProductOrder> page = new Page<>(val,10);
        IPage<TProductOrder> iPage = baseMapper.selectPage(page,null);
        return iPage;
    }

    @Override
    public void addOrder(TProductOrder order) {
//        TProduct product_num = productMapper.selectOne(new QueryWrapper<TProduct>().eq("product_num", order.getProductId()));

        order.setOrderSeq(UUID.randomUUID().toString().substring(0,4));

        order.setIsDelete(0);
        baseMapper.insert(order);
    }

    @Override
    public void editOrder(TProductOrder order) {
        baseMapper.update(order,new QueryWrapper<TProductOrder>().eq("order_seq",order.getOrderSeq()));
    }

    @Override
    public void deleteOrder(String orderSeq) {
        baseMapper.delete(new QueryWrapper<TProductOrder>().eq("order_seq",orderSeq));
    }

    @Override
    public void deleteBatch(List<String> asList) {
        baseMapper.deleteBatchByIds(asList);
    }

    @Override
    public IPage getSelectQuery(Integer val) {
        Page<TProductOrder> page = new Page<>(1,10);
        IPage<TProductOrder> iPage = baseMapper.selectPage(page, new QueryWrapper<TProductOrder>().eq("order_status", val));
        return iPage;
    }

    @Override
    public IPage getQueryList(Query2 query) {
        Page<TProductOrder> page = new Page<>(1,10);
        String name = query.getProductName();
        Integer status = query.getOrderStatus();
        TProduct product = productMapper.selectOne(new QueryWrapper<TProduct>().eq("product_name", name));
        String productNum = product.getProductNum();
        QueryWrapper<TProductOrder> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(status)){
            wrapper.like("product_id",productNum);
            wrapper.and(wrapper1->wrapper1.eq("order_status",status));
        }else{
            wrapper.like("product_id",productNum);
        }
        IPage<TProductOrder> iPage = baseMapper.selectPage(page, wrapper);
        return iPage;
    }

    @Override
    public void updateOrderStatusBySwitch(TProductOrder orderStatus) {
        baseMapper.update(orderStatus,new QueryWrapper<TProductOrder>().eq("order_seq",orderStatus.getOrderSeq()));
        if (orderStatus.getOrderStatus()==50){
            TProductPlan orderId = planService.getOne(new QueryWrapper<TProductPlan>().eq("order_id", orderStatus.getOrderSeq()));
            orderId.setPlanStatus(30);
            System.out.println(orderId);
            planService.updateById(orderId);
            TProductSchedule productId = scheduleService.getOne(new QueryWrapper<TProductSchedule>().eq("product_id", orderStatus.getProductId()));
            productId.setScheduleStatus(30);
            scheduleService.updateById(productId);
        }
        if (orderStatus.getOrderStatus()==40){
            TProductPlan orderId = planService.getOne(new QueryWrapper<TProductPlan>().eq("order_id", orderStatus.getOrderSeq()));
            orderId.setPlanStatus(20);
            System.out.println(orderId);
            planService.updateById(orderId);
            TProductSchedule productId = scheduleService.getOne(new QueryWrapper<TProductSchedule>().eq("product_id", orderStatus.getProductId()));
            productId.setScheduleStatus(20);
            scheduleService.updateById(productId);
        }
    }

    @Override
    public List getSuccessOrder() {
        List<TProductOrder> list = baseMapper.selectList(new QueryWrapper<TProductOrder>().eq("order_status", 20));
        return list;
    }
}
