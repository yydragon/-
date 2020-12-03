package com.yan.cloud.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yan.cloud.entity.Query;
import com.yan.cloud.entity.TEquipment;
import com.yan.cloud.service.TEquipmentService;
import com.yan.cloud.utils.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 设备表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-11-26
 */
@RestController
@RequestMapping("/equipment")
public class TEquipmentController {

    @Resource
    private TEquipmentService equipmentService;

    @GetMapping("list")
    public R getEquipmentList(@RequestParam("val") Integer val){
        IPage list = equipmentService.getEquipmentList(val);
        return R.ok().data("data",list);
    }

    @PostMapping("query")
    public R getQueryList(@RequestBody Query query){
        IPage list = equipmentService.getQueryList(query);
        return R.ok().data("data",list);
    }

    @GetMapping("selectQuery")
    public R getSelectQuery(@RequestParam("val") Integer val){
        IPage list = equipmentService.getSelectQuery(val);
        return R.ok().data("data",list);
    }

    @PostMapping("add")
    public R addEquipment(@RequestBody TEquipment equipment){
        equipmentService.addEquipment(equipment);
        return R.ok();
    }

    @GetMapping("delete")
    public R deleteEquipment(@RequestParam("equipmentSeq") String equipmentSeq){
        equipmentService.deleteEquipment(equipmentSeq);
        return R.ok();
    }

    @RequestMapping("deleteBatch")
    public R deleteMul(@RequestBody String[] dels){
        equipmentService.deleteBatch(Arrays.asList(dels));
        System.out.println(Arrays.asList(dels));

        return R.ok();
    }

    @PostMapping("edit")
    public R editEquipment(@RequestBody TEquipment equipment){
        equipmentService.editEquipment(equipment);
        return R.ok();
    }

}

