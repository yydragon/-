package com.yan.cloud.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yan.cloud.entity.TProduct;
import com.yan.cloud.entity.TProductOrder;
import com.yan.cloud.entity.TProductPlan;
import com.yan.cloud.mapper.TProductOrderMapper;
import com.yan.cloud.service.TProductOrderService;
import com.yan.cloud.service.TProductPlanService;
import com.yan.cloud.service.TProductService;
import com.yan.cloud.utils.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 生产计划表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-11-26
 */
@RestController
@RequestMapping("/plan")
public class TProductPlanController {

    @Resource
    private TProductPlanService planService;

    @Resource
    private TProductOrderService orderService;

    @Resource
    private TProductService productService;

    @GetMapping("list")
    public R getPlanList(@RequestParam("val") Integer val){
        IPage list = planService.getPlanList(val);
        return R.ok().data("data",list);
    }

    @PostMapping("editPlan")
    public R editPlanById(@RequestBody TProductPlan plan){
        planService.editPlanById(plan);
        return R.ok();
    }

    @GetMapping("deletePlan")
    public R deletePlan(@RequestParam("id") Integer id ){
        planService.deletePlan(id);
        return R.ok();
    }

    @PostMapping("addPlan")
    public R addPlan(@RequestBody TProductPlan plan){
        planService.addPlan(plan);
        return R.ok();
    }

    @RequestMapping("deleteBatch")
    public R deleteMul(@RequestBody String[] dels){
        planService.deleteBatch(Arrays.asList(dels));
        return R.ok();
    }

    @GetMapping("selectQuery")
    public R getSelectQuery(@RequestParam("val") Integer val){
        IPage list = planService.getSelectQuery(val);
        return R.ok().data("data",list);
    }

    @PostMapping("switch")
    public R updatePlanStatusBySwitch(@RequestBody TProductPlan planStatus){
        planService.updatePlanStatusBySwitch(planStatus);
        if (planStatus.getPlanStatus()==20){
            TProductOrder orderSeq = orderService.getOne(new QueryWrapper<TProductOrder>().eq("order_seq", planStatus.getOrderId()));
            orderSeq.setOrderStatus(40);
            orderService.updateById(orderSeq);
        }
        if (planStatus.getPlanStatus()==10){
            TProductOrder orderSeq = orderService.getOne(new QueryWrapper<TProductOrder>().eq("order_seq", planStatus.getOrderId()));
            orderSeq.setOrderStatus(20);
            orderService.updateById(orderSeq);
        }
        return R.ok();
    }

    @GetMapping("getStartedPlan")
    public R getStartedPlan(){
        List<TProductPlan> planStatusList = planService.list(new QueryWrapper<TProductPlan>().eq("plan_status", 20));
        return R.ok().data("data",planStatusList);
    }

    @GetMapping("getProductByPlanSeq")
    public R getProductByPlanSeq(@RequestParam("val") String val){
        TProductPlan productPlan = planService.getOne(new QueryWrapper<TProductPlan>().eq("plan_seq", val));
        TProduct product = productService.getOne(new QueryWrapper<TProduct>().eq("product_num", productPlan.getProductId()));
        return R.ok().data("product",product);
    }


    @GetMapping("getPlanByPlanSeq")
    public R getPlanByPlanSeq(@RequestParam("val") String val){
        TProductPlan productPlan = planService.getOne(new QueryWrapper<TProductPlan>().eq("plan_seq", val));
        return R.ok().data("productPlan",productPlan);
    }
}

