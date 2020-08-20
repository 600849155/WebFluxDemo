package com.whohim.wf.service.impl;

import com.whohim.wf.exception.DemoException;
import com.whohim.wf.model.demo;
import org.springframework.stereotype.Service;

import static com.whohim.wf.response.TestCode.TEST;

/**
 * @author WhomHim
 * @description
 * @date Create in 2020-4-7 22:19:53
 */
@Service
public class FluxQueryService implements com.whohim.wf.service.FluxQueryService {

    @Override
    public demo getUser() {
        return null;
    }

    @Override
    public String getHello() {
        String a = "hello";
        if ("hello".equals(a)) {
            throw new DemoException(TEST, "exception!");
        }
        return "hello";
    }
}
