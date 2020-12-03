package com.yan.cloud.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yan.cloud.entity.TProductSchedule;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 生产调度表 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-11-26
 */
public interface TProductScheduleService extends IService<TProductSchedule> {

    IPage getScheduleList(Integer val);

    void addSchedule(TProductSchedule schedule);

    void deleteSchedule(Integer id);

    IPage getSelectQuery(Integer val);

    void editScheduleById(TProductSchedule schedule);

    void updateScheduleStatusBySwitch(TProductSchedule scheduleStatus);

    void deleteBatch(List<String> asList);
}
