package com.whohim.wf.helper;

/**
 * Json辅助接口
 */
public interface Jsonable {

    /**
     * 输出Json字符串
     *
     * @return Json字符串
     */
    default String toJson() {
        return JsonHelper.toJson(this);
    }

}
