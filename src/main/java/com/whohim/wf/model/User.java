package com.whohim.wf.model;

import lombok.Data;

import java.util.Date;

/**
 * @author WhomHim
 * @description
 * @date Create in 2020-4-8 00:05:25
 */
@Data
public class User {
    private Integer uid;
    private String name;
    private Integer age;
    private Integer gender;
    private Date createTime;
}
