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
@ApiModel(value="TFactory对象", description="")
public class TFactory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "工厂ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "有效标识  0:有效   1:无效")
    private Integer flag;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建人ID")
    private Integer createUserid;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "修改人ID")
    private Integer updateUserid;

    @ApiModelProperty(value = "备注")
    private String bak;

    @ApiModelProperty(value = "工厂名称")
    private String factoryName;

    @ApiModelProperty(value = "工厂图片")
    private String factoryImgUrl;

    @ApiModelProperty(value = "工厂地址")
    private String factoryAddr;

    @ApiModelProperty(value = "工厂网址")
    private String factoryUrl;

    @ApiModelProperty(value = "工厂人数")
    private Integer factoryWorker;

    @ApiModelProperty(value = "工厂状态  0:正常  1:关闭")
    private Integer factoryStatus;


}
