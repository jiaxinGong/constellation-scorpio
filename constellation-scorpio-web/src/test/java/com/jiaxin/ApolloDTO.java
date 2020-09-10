package com.jiaxin;

import java.io.Serializable;
import java.util.Map;

import lombok.Data;

/**
 * @author jiaxin.gong
 * @date 2020/6/19
 */
@Data
public class ApolloDTO implements Serializable {
    private static final long serialVersionUID = -5486808275955499089L;
    /**
     * 应用标识
     */
    private String appId;
    /**
     * 集群名称
     */
    private String cluster;
    /**
     * 命名空间名称
     */
    private String namespaceName;

    /**
     * 发布key
     */
//    private String releaseKey;
    /**
     * k v配置
     */
    private Map<String, String> configurations;

    /**
     * 概要信息
     */
    private String summaryInfo;
}
