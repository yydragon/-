package com.yan.cloud.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 生产调度表
 * </p>
 *
 * @author testjava
 * @since 2020-11-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TProductSchedule对象", description="生产调度表")
public class TProductSchedule implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID标识")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "有效标识  0：有效  1：无效")
    private Integer flag;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "创建人ID")
    private Integer createUserid;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "修改人ID")
    private Integer updateUserid;

    @ApiModelProperty(value = "工单编号")
    private String scheduleSeq;

    @ApiModelProperty(value = "工单数量")
    private Integer scheduleCount;

    @ApiModelProperty(value = "工单状态 10：未开始   20：生产中  30：已完成")
    private Integer scheduleStatus;

    @ApiModelProperty(value = "计划ID")
    private String planId;

    @ApiModelProperty(value = "产品ID")
    private String productId;

    @ApiModelProperty(value = "设备ID")
    private String equipmentId;

    @ApiModelProperty(value = "开始日期")
    private Date startDate;

    @ApiModelProperty(value = "结束日期")
    private Date endDate;

    @ApiModelProperty(value = "工厂ID")
    private Integer factoryId;

    @TableLogic
    private Integer isDelete;
}
