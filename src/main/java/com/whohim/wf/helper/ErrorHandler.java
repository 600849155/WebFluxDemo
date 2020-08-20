package com.whohim.wf.helper;

import com.whohim.wf.exception.DemoException;
import com.whohim.wf.result.Response;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * 错误处理器
 */
@AllArgsConstructor
@Slf4j
@Component
public class ErrorHandler {

    public static final String COMMON_ERR_RESP_CODE = "0000";

    public <T> Response<T> handleFlowResponseException(Throwable throwable) {
        log.error(throwable.getMessage(), throwable);
        if (throwable instanceof DemoException) {
            DemoException exception = (DemoException) throwable;
            return Response.failure(exception.getRespCode().getCode(), exception.getMessage());
        } else {
            return Response.failure(COMMON_ERR_RESP_CODE, throwable.getMessage());
        }
    }

}
