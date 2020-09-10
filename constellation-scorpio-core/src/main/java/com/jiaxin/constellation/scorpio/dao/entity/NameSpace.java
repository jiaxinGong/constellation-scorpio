package com.jiaxin.constellation.scorpio.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 命名空间
 * </p>
 *
 * @author jiaxin.gong
 * @since 2020-06-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Namespace对象", description = "命名空间")
@TableName("namespace")
public class NameSpace implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增主键")
    @TableId(value = "Id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "AppID")
    @TableField("AppId")
    private String appId;

    @ApiModelProperty(value = "Cluster Name")
    @TableField("ClusterName")
    private String clusterName;

    @ApiModelProperty(value = "Namespace Name")
    @TableField("NamespaceName")
    private String nameSpaceName;

    @ApiModelProperty(value = "1: deleted, 0: normal")
    @TableField("IsDeleted")
    private Boolean isDeleted;

    @ApiModelProperty(value = "创建人邮箱前缀")
    @TableField("DataChange_CreatedBy")
    private String dataChangeCreatedBy;

    @ApiModelProperty(value = "创建时间")
    @TableField("DataChange_CreatedTime")
    private LocalDateTime dataChangeCreatedTime;

    @ApiModelProperty(value = "最后修改人邮箱前缀")
    @TableField("DataChange_LastModifiedBy")
    private String dataChangeLastModifiedBy;

    @ApiModelProperty(value = "最后修改时间")
    @TableField("DataChange_LastTime")
    private LocalDateTime dataChangeLastTime;

}
