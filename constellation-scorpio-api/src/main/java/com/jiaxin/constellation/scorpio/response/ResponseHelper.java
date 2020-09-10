package com.jiaxin.constellation.scorpio.response;

import com.jiaxin.constellation.scorpio.response.enums.ResponseCodeTypeEnum;

/**
 * 响应帮助类
 * @author 15307
 */
public final class ResponseHelper {

    public static boolean isSuccess(Response<?> response) {
        return response != null && (ResponseCodeTypeEnum.SUCCESS.getCode().equalsIgnoreCase(response.getCode()));
    }

    public static <T> Response<T> success() {
        return buildResponse(ResponseCodeTypeEnum.SUCCESS);
    }

    public static <T> Response<T> success(T result) {
        return buildResponse(ResponseCodeTypeEnum.SUCCESS, result);
    }

    public static <T> Response<T> invalidParam() {
        return buildResponse(ResponseCodeTypeEnum.PARAMETER_ERROR);
    }

    public static <T> Response<T> invalidParam(String msg) {
        return buildResponse(ResponseCodeTypeEnum.PARAMETER_ERROR, msg);
    }

    public static <T> Response<T> bizError() {
        return buildResponse(ResponseCodeTypeEnum.SYSTEM_BUSY);
    }

    public static <T> Response<T> bizError(String msg) {
        return buildResponse(ResponseCodeTypeEnum.SYSTEM_BUSY, msg);
    }

    public static <T> Response<T> bizError(T result) {
        return buildResponse(ResponseCodeTypeEnum.SYSTEM_BUSY, result);
    }

    public static <T> Response<T> bizError(String msg, T result) {
        return buildResponse(ResponseCodeTypeEnum.SYSTEM_BUSY, msg, result);
    }

    public static <T> Response<T> unknownError() {
        return buildResponse(ResponseCodeTypeEnum.FAILURE);
    }

    public static <T> Response<T> unknownError(String msg) {
        return buildResponse(ResponseCodeTypeEnum.FAILURE, msg);
    }

    public static <T> Response<T> buildResponse(ResponseCodeTypeEnum theEnum) {
        return buildResponse(theEnum.getCode(), theEnum.getMessage(), null);
    }

    public static <T> Response<T> buildResponse(ResponseCodeTypeEnum theEnum, String msg) {
        return buildResponse(theEnum.getCode(), msg, null);
    }

    public static <T> Response<T> buildResponse(ResponseCodeTypeEnum theEnum, T result) {
        return buildResponse(theEnum.getCode(), theEnum.getMessage(), result);
    }

    public static <T> Response<T> buildResponse(ResponseCodeTypeEnum theEnum, String msg, T result) {
        return buildResponse(theEnum.getCode(), msg, result);
    }

    public static <T> Response<T> buildResponse(String code, String msg, T result) {
        Response<T> response = new Response<>(code, msg, result);
        response.setCode(code);
        response.setMessage(msg);
        response.setResult(result);
        return response;
    }

    /**
     * copy response
     * 
     * @param otherResponse
     * @param <T>
     * @return
     */
    public static <T> Response<T> copyResponseWithoutData(Response<?> otherResponse) {
        return buildResponse(otherResponse.getCode(), otherResponse.getMessage(), null);
    }
}
