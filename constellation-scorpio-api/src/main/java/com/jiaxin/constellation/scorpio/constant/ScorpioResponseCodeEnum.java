package com.jiaxin.constellation.scorpio.constant;

import com.jiaxin.constellation.scorpio.response.Response;

import lombok.Getter;

/**
 * xanfer业务返回码
 *
 * @author hongkai.wang
 * @date 2020-01-06 11:16
 */
public enum ScorpioResponseCodeEnum {
    /**
     * 返回码
     */
    JDBC_EXCEPTION("数据库连接异常"),
    IO_EXCEPTION("IO异常"),
    INVALID_PARAM("无效的入参"),
    INVALID_CONFIG("无效的配置"),
    REQUEST_REMOTE_SERVER_FAILED("请求远端服务器异常"),
    UPGRADED_APP_NOT_CONFIGURED("未配置需升级的app"),
    BEAN_TRANSFORM_EXCEPTION("Bean类型转换异常"),
    NO_NEED_TO_UPGRADE("脚本/数据与服务端一致，无需升级"),
    ;

    @Getter
    private final String message;

    static {
        for (ScorpioResponseCodeEnum codeEnum : ScorpioResponseCodeEnum.values()) {
            Response.RESPONSE_MAP.put(codeEnum.name(), codeEnum.getMessage());
        }
    }

    ScorpioResponseCodeEnum(String message) {
        this.message = message;
    }

}
