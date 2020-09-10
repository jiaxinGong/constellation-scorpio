package com.jiaxin.constellation.scorpio.exception;

import com.jiaxin.constellation.scorpio.constant.ScorpioResponseCodeEnum;
import com.jiaxin.constellation.scorpio.response.enums.ResponseCodeTypeEnum;

/**
 * @author jiaxin.gong
 * @date 2020/6/20 19:55
 */
public class ScorpioException extends ConstellationException {
    public ScorpioException() {
        super();
    }

    public ScorpioException(String message, Throwable cause) {
        super(message, cause);
        super.setMessage(message);
    }

    public ScorpioException(Throwable cause) {
        super(cause);
    }

    public ScorpioException(String code) {
        super(code);
    }

    public ScorpioException(String code, Object... args) {
        super(code, args);
    }

    public ScorpioException(String code, String message, Object... args) {
        super(code, message, args);
    }

    public ScorpioException(ScorpioResponseCodeEnum codeEnum) {
        this(codeEnum.name(), codeEnum.getMessage());
    }

    public ScorpioException(ScorpioResponseCodeEnum codeEnum, String msg) {
        this(codeEnum.name(), msg);
    }

    public ScorpioException(ResponseCodeTypeEnum systemResponseEnum) {
        this(systemResponseEnum.getCode(), systemResponseEnum.getMessage());
    }
}
