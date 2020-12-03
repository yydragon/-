package com.yan.cloud.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 设备与产品对应表
 * </p>
 *
 * @author testjava
 * @since 2020-11-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TEquipmentProduct对象", description="设备与产品对应表")
public class TEquipmentProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID标识")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "设备ID")
    private String equipmentId;

    @ApiModelProperty(value = "产品ID")
    private String productId;

    @ApiModelProperty(value = "产能")
    private Integer yield;

    @ApiModelProperty(value = "产能单位  10：天  20：月  30：年  40：小时")
    private Integer unit;

    @ApiModelProperty(value = "工厂ID")
    private Integer factoryId;

    private String equipmentName;

    private String productName;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableLogic
    private Integer isDelete;

    private String productImgUrl;

    private String equipmentImgUrl;
}
