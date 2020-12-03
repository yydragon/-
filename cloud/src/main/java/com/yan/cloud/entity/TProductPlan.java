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
 * 生产计划表
 * </p>
 *
 * @author testjava
 * @since 2020-11-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TProductPlan对象", description="生产计划表")
public class TProductPlan implements Serializable {

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

    @ApiModelProperty(value = "计划编号")
    private String planSeq;

    @ApiModelProperty(value = "订单ID")
    private String orderId;

    @ApiModelProperty(value = "产品ID")
    private String productId;

    @ApiModelProperty(value = "计划数量")
    private Integer planCount;

    @ApiModelProperty(value = "交货日期")
    private Date deliveryDate;

    @ApiModelProperty(value = "计划开始日期")
    private Date planStartDate;

    @ApiModelProperty(value = "计划结束日期")
    private Date planEndDate;

    @ApiModelProperty(value = "计划状态  10：未启动  20：已启动   30：已完成")
    private Integer planStatus;

    @ApiModelProperty(value = "工厂ID")
    private Integer factoryId;

    @TableLogic
    private Integer isDelete;


}
