package com.jiaxin.constellation.scorpio.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jiaxin.gong
 * @date 2020/6/20 19:11
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ConstellationException extends RuntimeException{
    /**
     * 返回码
     */
    private String code;
    /**
     * 返回信息
     */
    private String message;

    /**
     * 可变参数的数组
     */
    private Object[] args;

    public ConstellationException() {
        super();
    }

    public ConstellationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConstellationException(Throwable cause) {
        super(cause);
    }

    public ConstellationException(final String code) {
        this.code = code;
    }

    public ConstellationException(final String code, final Object... args) {
        this.code = code;
        this.args = args;
    }

    public ConstellationException(final String code, final String message, final Object... args) {
        this.code = code;
        this.message = message;
        this.args = args;
    }

}
