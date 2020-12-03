package com.yan.cloud.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yan.cloud.entity.TEquipmentProduct;
import com.yan.cloud.entity.TProductOrder;
import com.yan.cloud.service.TEquipmentProductService;
import com.yan.cloud.service.TEquipmentService;
import com.yan.cloud.service.TProductService;
import com.yan.cloud.utils.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 设备与产品对应表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-11-26
 */
@RestController
@RequestMapping("/equipment-product")
public class TEquipmentProductController {

    @Resource
    private TEquipmentProductService service;

    @Resource
    private TProductService productService;

    @Resource
    TEquipmentService equipmentService;

    @GetMapping("list")
    public R getList(@RequestParam("val") Integer val){
        IPage list = service.getList(val);
        return R.ok().data("data",list);
    }

    @GetMapping("getProduct")
    public R getAllProduct(){
        IPage list = productService.getAllProduct();
        return R.ok().data("data",list);
    }

    @GetMapping("getEquipment")
    public R getAllEquipment(){
        List list = equipmentService.getAllEquipment();
        return R.ok().data("data",list);
    }

    @PostMapping("addForm")
    public R addForm(@RequestBody TEquipmentProduct form){
        service.addForm(form);
        return R.ok();
    }

    @PostMapping("deleteRecord")
    public R deleteProductEquipmentLink(@RequestBody TEquipmentProduct record){
        service.deleteProductEquipmentLink(record);
        return R.ok();
    }

    @GetMapping("query")
    public R queryResult(@RequestParam("val") String val){
        IPage list = service.queryResult(val);
        return R.ok().data("data",list);
    }

    @RequestMapping("deleteBatch")
    public R deleteMul(@RequestBody String[] dels){
        service.deleteBatch(Arrays.asList(dels));
        return R.ok();
    }

    @GetMapping(("getEquipmentSeqByProductSeq"))
    public R getEquipmentSeqByProductSeq(@RequestParam("val") String val){
        TEquipmentProduct equipmentProduct = service.getOne(new QueryWrapper<TEquipmentProduct>().eq("product_id", val));
        return R.ok().data("data",equipmentProduct);
    }
}

