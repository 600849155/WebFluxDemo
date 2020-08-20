package com.whohim.wf.exception;

import com.whohim.wf.response.TestCode;

/**
 * @author WhomHim
 * @description
 * @date Create in 2020-8-20 22:20:49
 */
public class DemoException extends RuntimeException {
    protected final TestCode respCode;

    public DemoException(TestCode respCode, Object... objects) {
        super(respCode.getRespMessage(objects));
        this.respCode = respCode;
    }

    DemoException(TestCode respCode, Throwable throwable, Object... objects) {
        super(respCode.getRespMessage(objects), throwable);
        this.respCode = respCode;
    }

    public TestCode getRespCode() {
        return this.respCode;
    }
}
