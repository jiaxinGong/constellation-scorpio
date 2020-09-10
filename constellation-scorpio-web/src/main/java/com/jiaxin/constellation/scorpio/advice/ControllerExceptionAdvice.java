package com.jiaxin.constellation.scorpio.advice;

import com.jiaxin.constellation.scorpio.exception.ConstellationException;
import com.jiaxin.constellation.scorpio.response.Response;
import com.jiaxin.constellation.scorpio.response.enums.ResponseCodeTypeEnum;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.ValidationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 15307
 */
@RestControllerAdvice
@Slf4j
public class ControllerExceptionAdvice {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response<Map<String, String>> methodArgumentNotValidHandler(Exception exception) throws Exception {

        Response<Map<String, String>> response = new Response<Map<String, String>>();

        // SpringMVC层参数的校验异常
        if (exception instanceof MethodArgumentNotValidException) {
            Map<String, String> fieldAndMessage = new HashMap<String, String>(16);

            MethodArgumentNotValidException methodArgumentNotValidException =
                (MethodArgumentNotValidException)exception;
            List<FieldError> errors = methodArgumentNotValidException.getBindingResult().getFieldErrors();
            for (FieldError fieldError : errors) {
                fieldAndMessage.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            // 获取第一条校验异常信息
            String message = null;
            if (errors != null && !errors.isEmpty()) {
                message = errors.get(0).getDefaultMessage();
            }
            if (StringUtils.isEmpty(message)) {
                message = ResponseCodeTypeEnum.PARAMETER_ERROR.getMessage();
            }
            response.setCode(ResponseCodeTypeEnum.PARAMETER_ERROR.getCode());
            response.setMessage(message);
            response.setResult(fieldAndMessage);
        }
        // SpringMVC自带的参数绑定校验的异常
        else if (exception instanceof BindException) {
            Map<String, String> fieldAndMessage = new HashMap<String, String>(16);

            BindException bindException = (BindException)exception;
            for (FieldError fieldError : bindException.getBindingResult().getFieldErrors()) {
                fieldAndMessage.put(fieldError.getField(), fieldError.getDefaultMessage());
            }

            response.setCode(ResponseCodeTypeEnum.PARAMETER_ERROR.getCode());
            response.setMessage(ResponseCodeTypeEnum.PARAMETER_ERROR.getMessage());
            response.setResult(fieldAndMessage);

        }
        // Java原生参数校验异常
        else if (exception instanceof ValidationException) {
            response.setCode(ResponseCodeTypeEnum.PARAMETER_ERROR.getCode());
            response.setMessage(ResponseCodeTypeEnum.PARAMETER_ERROR.getMessage());
        }
        // RPC远程调用的异常
        // else if (exception instanceof RpcException) {
        // response.setCode(ResponseCodeTypeEnum.PARAMETER_ERROR.getCode());
        // response.setMessage(ResponseCodeTypeEnum.PARAMETER_ERROR.getMessage());
        // }
        // WelabException统一异常
        else if (exception instanceof ConstellationException) {
            ConstellationException constellationException = (ConstellationException)exception;
            // 默认设置一下未知错误的返回异常
            response.setCode(ResponseCodeTypeEnum.FAILURE.getCode());
            response.setMessage(ResponseCodeTypeEnum.FAILURE.getMessage());

            // 如果截获的异常不包含code，则统一返回上边的未知错误
            if (constellationException.getCode() != null) {
                // message和args都为空
                if (StringUtils.isBlank(constellationException.getMessage())
                    && ArrayUtils.isEmpty(constellationException.getArgs())) {
                    String message = Response.RESPONSE_MAP.get(constellationException.getCode());
                    if (message != null) {
                        response.setCode(constellationException.getCode());
                        response.setMessage(message);
                    }
                }
                // message不为空，args为空
                else if (StringUtils.isNotBlank(constellationException.getMessage())
                    && ArrayUtils.isEmpty(constellationException.getArgs())) {
                    response.setCode(constellationException.getCode());
                    response.setMessage(constellationException.getMessage());
                }
                // message为空，args不为空
                else if (StringUtils.isBlank(constellationException.getMessage())
                    && ArrayUtils.isNotEmpty(constellationException.getArgs())) {
                    String message = Response.RESPONSE_MAP.get(constellationException.getCode());
                    if (message != null) {
                        response.setCode(constellationException.getCode());
                        response.setMessage(String.format(message, constellationException.getArgs()));
                    }
                }
                // message和args都不为空
                else {
                    response.setCode(constellationException.getCode());
                    response.setMessage(String.format(constellationException.getMessage(), constellationException.getArgs()));
                }
            }
        }
        // 其它统一报未知错误
        else {
            response.setCode(ResponseCodeTypeEnum.FAILURE.getCode());
            if (exception != null) {
                response.setMessage(exception.getMessage());
            } else {
                response.setMessage(ResponseCodeTypeEnum.FAILURE.getMessage());
            }
        }

        // 方便调试，将异常统一打印出来
        log.warn(exception.getMessage(), exception);

        return response;

    }
}
