package com.whohim.wf.result;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.whohim.wf.helper.Jsonable;
import lombok.Builder;
import lombok.Value;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

/**
 * Http响应对象
 *
 * @param <T> 数据对象类型
 */
@Builder
@Value
@JsonAutoDetect(fieldVisibility = ANY)
public class Response<T> implements Jsonable {

    public static final String SUCCESS_CODE = "0";
    public static final String SUCCESS_MSG = "success";

    String code; // 响应码
    String msg; // 响应描述
    T data; // 数据对象

    /**
     * 成功响应
     *
     * @param data 数据对象
     * @param <T>  数据对象类型
     * @return 成功的响应对象
     */
    public static <T> Response<T> success(T data) {
        return Response.<T>builder().code(SUCCESS_CODE).msg(SUCCESS_MSG).data(data).build();
    }

    /**
     * 失败响应（默认无数据对象返回）
     *
     * @param code 响应码
     * @param msg  响应描述
     * @param <T>  数据对象类型
     * @return 失败的响应对象
     */
    public static <T> Response<T> failure(String code, String msg) {
        return Response.<T>builder().code(code).msg(msg).build();
    }

}
