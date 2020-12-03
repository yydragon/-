package com.yan.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yan.cloud.entity.TProductSchedule;
import com.yan.cloud.mapper.TProductScheduleMapper;
import com.yan.cloud.service.TProductScheduleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 生产调度表 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-11-26
 */
@Service
public class TProductScheduleServiceImpl extends ServiceImpl<TProductScheduleMapper, TProductSchedule> implements TProductScheduleService {

    @Override
    public IPage getScheduleList(Integer val) {
        Page<TProductSchedule> page = new Page<>(val,10);
        IPage<TProductSchedule> iPage = baseMapper.selectPage(page, null);
        return iPage;
    }

    @Override
    public void addSchedule(TProductSchedule schedule) {
        schedule.setIsDelete(0);
        schedule.setScheduleSeq(UUID.randomUUID().toString().substring(0,4));
        baseMapper.insert(schedule);
    }

    @Override
    public void deleteSchedule(Integer id) {
        baseMapper.deleteById(id);
    }

    @Override
    public IPage getSelectQuery(Integer val) {
        Page<TProductSchedule> page = new Page<>(1,10);
        IPage<TProductSchedule> iPage = baseMapper.selectPage(page, new QueryWrapper<TProductSchedule>().eq("schedule_status", val));
        return iPage;
    }

    @Override
    public void editScheduleById(TProductSchedule schedule) {
        baseMapper.updateById(schedule);
    }

    @Override
    public void updateScheduleStatusBySwitch(TProductSchedule scheduleStatus) {
        baseMapper.updateById(scheduleStatus);
    }

    @Override
    public void deleteBatch(List<String> asList) {
        baseMapper.deleteBatchIds(asList);
    }


}
