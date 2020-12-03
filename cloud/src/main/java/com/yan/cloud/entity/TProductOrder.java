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
 * 订单表
 * </p>
 *
 * @author testjava
 * @since 2020-11-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TProductOrder对象", description="订单表")
public class TProductOrder implements Serializable {

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

    @ApiModelProperty(value = "订单编号")
    private String orderSeq;

    @ApiModelProperty(value = "订单来源")
    private String orderSource;

    @ApiModelProperty(value = "产品ID")
    private String productId;

    @ApiModelProperty(value = "产品数量")
    private Integer productCount;

    @ApiModelProperty(value = "订单截止日期")
    private Date endDate;

    @ApiModelProperty(value = "订单状态 10：未接单  20：已接单  30：已拒绝  40：生产中  50：订单完成")
    private Integer orderStatus;

    @ApiModelProperty(value = "工厂ID")
    private Integer factoryId;

    @ApiModelProperty(value = "工厂产能")
    private Integer factoryYield;

    @TableLogic
    private Integer isDelete;


}
