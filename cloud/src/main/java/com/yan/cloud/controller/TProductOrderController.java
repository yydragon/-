package com.yan.cloud.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yan.cloud.entity.Query;
import com.yan.cloud.entity.Query2;
import com.yan.cloud.entity.TProduct;
import com.yan.cloud.entity.TProductOrder;
import com.yan.cloud.service.TProductOrderService;
import com.yan.cloud.service.TProductService;
import com.yan.cloud.utils.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-11-26
 */
@RestController
@RequestMapping("/order")
public class TProductOrderController {
    @Resource
    private TProductOrderService orderService;

    @Resource
    private TProductService productService;

    @GetMapping("list")
    public R getOrderList(@RequestParam("val") Integer val){
        IPage list = orderService.getOrderList(val);
        return R.ok().data("data",list);
    }

    @GetMapping("selectQuery")
    public R getSelectQuery(@RequestParam("val") Integer val){
        IPage list = orderService.getSelectQuery(val);
        return R.ok().data("data",list);
    }

    @PostMapping("query")
    public R getQueryList(@RequestBody Query2 query){
        IPage list = orderService.getQueryList(query);
        return R.ok().data("data",list);
    }

    @PostMapping("add")
    public R addOrder(@RequestBody TProductOrder order){
        orderService.addOrder(order);
        return R.ok();
    }

    @PostMapping("edit")
    public R editOrder(@RequestBody TProductOrder order){
        orderService.editOrder(order);
        return R.ok();
    }

    @GetMapping("delete")
    public R deleteProduct(@RequestParam(value="orderSeq") String orderSeq){
        System.out.println(orderSeq);
        orderService.deleteOrder(orderSeq);
        return R.ok();
    }

    @RequestMapping("deleteBatch")
    public R deleteMul(@RequestBody String[] dels){
        orderService.deleteBatch(Arrays.asList(dels));
        System.out.println(Arrays.asList(dels));

        return R.ok();
    }

    @GetMapping("getProductByOrderSeq")
    public R getProductNameByProductSeq(@RequestParam("val") String val){
        TProductOrder one = orderService.getOne(new QueryWrapper<TProductOrder>().eq("order_seq", val));
        String productId = one.getProductId();
        TProduct product = productService.getOne(new QueryWrapper<TProduct>().eq("product_num", productId));
        return R.ok().data("product",product);
    }

    @GetMapping("getEndDateByOrderSeq")
    public R getEndDateByOrderSeq(@RequestParam String val){
        TProductOrder order = orderService.getOne(new QueryWrapper<TProductOrder>().eq("order_seq", val));
        return R.ok().data("data",order);
    }

    @PostMapping("switch")
    public R updateOrderStatusBySwitch(@RequestBody TProductOrder orderStatus){
        orderService.updateOrderStatusBySwitch(orderStatus);
        return R.ok();
    }

    @GetMapping("selectOrder")
    public R getSuccessOrder(){
        List list = orderService.getSuccessOrder();
        return R.ok().data("data",list);
    }
}


