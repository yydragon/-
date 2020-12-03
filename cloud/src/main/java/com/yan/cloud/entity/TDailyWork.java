package com.yan.cloud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author testjava
 * @since 2020-11-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TDailyWork对象", description="")
public class TDailyWork implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID标识")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "有效标识  0：有效  1：无效")
    private Integer flag;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建人ID")
    private Integer createUserid;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "修改人ID")
    private Integer updateUserid;

    @ApiModelProperty(value = "调度ID")
    private Integer scheduleId;

    @ApiModelProperty(value = "设备id")
    private Integer equipmentId;

    @ApiModelProperty(value = "设备序号")
    private String equipmentSeq;

    @ApiModelProperty(value = "加工开始时间")
    private Date startTime;

    @ApiModelProperty(value = "加工结束时间")
    private Date endTime;

    @ApiModelProperty(value = "加工数量")
    private Integer workingCount;

    @ApiModelProperty(value = "合格数量")
    private Integer qualifiedCount;

    @ApiModelProperty(value = "不合格数量")
    private Integer unqualifiedCout;

    @ApiModelProperty(value = "结束报工标识  0：是  1：否")
    private Integer completeFlag;

    @ApiModelProperty(value = "工厂ID")
    private Integer factoryId;

    @ApiModelProperty(value = "备注")
    private String bak;


}
