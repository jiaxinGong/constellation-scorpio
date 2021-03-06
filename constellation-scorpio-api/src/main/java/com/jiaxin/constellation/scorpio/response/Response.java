/**
 * @Title: Response.java
 * @Copyright: © 2017 我来贷
 * @Company: 深圳卫盈智信科技有限公司
 */

package com.jiaxin.constellation.scorpio.response;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.jiaxin.constellation.scorpio.response.enums.ResponseCodeTypeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一返回对象
 * 
 * @author 15307
 * @param <T>
 */
@Data
@NoArgsConstructor
public class Response<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 返回码。默认返回成功
     */
    protected String code = ResponseCodeTypeEnum.SUCCESS.getCode();

    /**
     * 返回码信息
     */
    protected String message = ResponseCodeTypeEnum.SUCCESS.getMessage();

    /**
     * 返回结果
     */
    protected T result;

    /**
     * 返回成功
     *
     * @param <T>
     * @return
     */
    public static <T> Response<T> success() {
        return new Response<>();
    }

    /**
     * 返回成功
     *
     * @param result
     *            返回结果
     * @param <T>
     * @return
     */
    public static <T> Response<T> success(T result) {
        Response<T> response = new Response<>();
        response.setResult(result);

        return response;
    }

    /**
     * 判断请求是否成功
     *
     * @return 请求是否成功的结果
     */
    public static boolean isSuccess(Response<?> response) {
        if (response == null) {
            return false;
        }
        return ResponseCodeTypeEnum.SUCCESS.getCode().equals(response.getCode());
    }

    /**
     * 返回码、返回信息映射
     */
    public static final Map<String, String> RESPONSE_MAP = new HashMap<String, String>();

    /**
     * 根据错误码返回错误码和错误信息
     * 
     * @param code
     *            错误码
     */
    public Response(String code) {
        this.code = code;
        this.message = RESPONSE_MAP.get(code);
    }

    /**
     * 根据错误码和返回结果组装返回码、返回信息和返回结果
     * 
     * @param code
     *            错误码
     * @param result
     *            返回结果
     */
    public Response(String code, T result) {
        this.code = code;
        this.message = RESPONSE_MAP.get(code);
        this.result = result;
    }

    /**
     * 根据错误码、返回信息和返回结果组装返回码、返回信息和返回结果
     * 
     * @param code
     *            错误码
     * @param message
     *            错误信息
     * @param result
     *            返回结果
     */
    public Response(String code, String message, T result) {
        this.code = code;
        // 兼容下自定义的返回码没有缓存到统一返回对象的情况
        this.message = RESPONSE_MAP.get(code) == null ? message : (RESPONSE_MAP.get(code) + ":" + message);
        this.result = result;
    }
}