package com.yan.cloud.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yan.cloud.entity.Echarts;
import com.yan.cloud.entity.TProductOrder;
import com.yan.cloud.entity.TProductPlan;
import com.yan.cloud.service.*;
import com.yan.cloud.utils.R;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/echarts")
public class EchartsController {

    @Resource
    private TProductService productService;

    @Resource
    TEquipmentService equipmentService;

    @Resource
    TProductOrderService orderService;

    @Resource
    TProductPlanService planService;

    @Resource
    TProductScheduleService scheduleService;

    @GetMapping("count")
    public R getAllCount(){
        int products = productService.count(null);
        int equipments = equipmentService.count(null);
        int orders = orderService.count(null);
        int plans = planService.count(null);
        int schedules = scheduleService.count(null);
        ArrayList<Integer> counts = new ArrayList<>();
        counts.add(products);
        counts.add(equipments);
        counts.add(orders);
        counts.add(plans);
        counts.add(schedules);
        return R.ok().data("data",counts);
    }

    @GetMapping("getOrderStatus")
    public R getOrderStatus(){
        int weijiedan = orderService.count(new QueryWrapper<TProductOrder>().eq("order_status", 10));
        int yijiedan = orderService.count(new QueryWrapper<TProductOrder>().eq("order_status", 20));
        int yijujue = orderService.count(new QueryWrapper<TProductOrder>().eq("order_status", 30));
        int shengchanzho = orderService.count(new QueryWrapper<TProductOrder>().eq("order_status", 40));
        int yiwancheng = orderService.count(new QueryWrapper<TProductOrder>().eq("order_status", 50));

        Echarts echarts1 = new Echarts();
        echarts1.setValue(weijiedan);
        echarts1.setName("未接单");
        Echarts echarts2 = new Echarts();
        echarts2.setValue(yijiedan);
        echarts2.setName("已接单");
        Echarts echarts3 = new Echarts();
        echarts3.setValue(yijujue);
        echarts3.setName("已拒绝");
        Echarts echarts4 = new Echarts();
        echarts4.setValue(shengchanzho);
        echarts4.setName("生产中");
        Echarts echarts5 = new Echarts();
        echarts5.setValue(yiwancheng);
        echarts5.setName("已完成");
        ArrayList<Echarts> list = new ArrayList<>();
        list.add(echarts1);
        list.add(echarts2);
        list.add(echarts3);
        list.add(echarts4);
        list.add(echarts5);
        return R.ok().data("data",list);
    }

    @GetMapping("getPlanStauts")
    public R getPlanStauts(){
        int weiqidong = planService.count(new QueryWrapper<TProductPlan>().eq("plan_status", 10));
        int yiqidong = planService.count(new QueryWrapper<TProductPlan>().eq("plan_status", 20));
        int yiwancheng = planService.count(new QueryWrapper<TProductPlan>().eq("plan_status", 30));

        Echarts echarts1 = new Echarts();
        echarts1.setValue(weiqidong);
        echarts1.setName("未启动");
        Echarts echarts2 = new Echarts();
        echarts2.setValue(yiqidong);
        echarts2.setName("已启动");
        Echarts echarts3 = new Echarts();
        echarts3.setValue(yiwancheng);
        echarts3.setName("已完成");

        ArrayList<Echarts> list = new ArrayList<>();
        list.add(echarts1);
        list.add(echarts2);
        list.add(echarts3);
        return R.ok().data("data",list);
    }
}
