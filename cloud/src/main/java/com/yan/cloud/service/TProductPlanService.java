package com.yan.cloud.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yan.cloud.entity.TProductPlan;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 生产计划表 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-11-26
 */
public interface TProductPlanService extends IService<TProductPlan> {

    IPage getPlanList(Integer val);

    void editPlanById(TProductPlan plan);

    void deletePlan(Integer id);

    void addPlan(TProductPlan plan);

    void deleteBatch(List<String> asList);

    IPage getSelectQuery(Integer val);

    void updatePlanStatusBySwitch(TProductPlan planStatus);
}
