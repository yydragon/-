package com.yan.cloud.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yan.cloud.entity.TProductSchedule;
import com.yan.cloud.service.TProductScheduleService;
import com.yan.cloud.service.TProductService;
import com.yan.cloud.utils.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * <p>
 * 生产调度表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-11-26
 */
@RestController
@RequestMapping("/schedule")
public class TProductScheduleController {

    @Resource
    private TProductScheduleService scheduleService;

    @GetMapping("list")
    public R getScheduleList(@RequestParam("val") Integer val){
        IPage list = scheduleService.getScheduleList(val);
        return R.ok().data("data",list);
    }

    @PostMapping("addSchedule")
    public R addSchedule(@RequestBody TProductSchedule schedule){
        scheduleService.addSchedule(schedule);
        return R.ok();
    }

    @GetMapping("delete")
    public R deleteProduct(@RequestParam("id") Integer id){
        scheduleService.deleteSchedule(id);
        return R.ok();
    }

    @GetMapping("selectQuery")
    public R getSelectQuery(@RequestParam("val") Integer val){
        IPage list = scheduleService.getSelectQuery(val);
        return R.ok().data("data",list);
    }

    @PostMapping("editSchedule")
    public R editPlanById(@RequestBody TProductSchedule schedule){
        scheduleService.editScheduleById(schedule);
        return R.ok();
    }

    @PostMapping("switch")
    public R updateScheduleStatusBySwitch(@RequestBody TProductSchedule scheduleStatus){
        scheduleService.updateScheduleStatusBySwitch(scheduleStatus);
        return R.ok();
    }

    @RequestMapping("deleteBatch")
    public R deleteMul(@RequestBody String[] dels){
        scheduleService.deleteBatch(Arrays.asList(dels));

        return R.ok();
    }

}

