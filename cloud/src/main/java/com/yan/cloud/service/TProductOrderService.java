package com.yan.cloud.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yan.cloud.entity.Query;
import com.yan.cloud.entity.Query2;
import com.yan.cloud.entity.TProductOrder;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-11-26
 */
public interface TProductOrderService extends IService<TProductOrder> {

    IPage getOrderList(Integer val);

    void addOrder(TProductOrder order);

    void editOrder(TProductOrder order);

    void deleteOrder(String orderSeq);

    void deleteBatch(List<String> asList);

    IPage getSelectQuery(Integer val);

    IPage getQueryList(Query2 query);

    void updateOrderStatusBySwitch(TProductOrder orderStatus);

    List getSuccessOrder();
}
