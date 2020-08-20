package com.whohim.wf.response;

import com.fasterxml.jackson.annotation.JsonValue;

import java.text.DecimalFormat;

/**
 * @author WhomHim
 * @description
 * @date Create in 2020-8-20 22:45:21
 */
public enum TestCode {
    TEST("test");

    private static final String PATTERN = "0000";
    private static final DecimalFormat FORMAT = new DecimalFormat("0000");
    private String message;

    @JsonValue
    public String getCode() {
        return this.ordinal() == 0 ? "0" : "11" + FORMAT.format((long)this.ordinal());
    }

    public String getRespMessage(Object... objects) {
        return objects != null && objects.length > 0 ? String.format(this.getMessage(), objects) : this.getMessage();
    }

    private TestCode(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
