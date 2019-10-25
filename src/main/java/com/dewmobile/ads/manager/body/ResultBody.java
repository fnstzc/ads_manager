package com.dewmobile.ads.manager.body;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 封装返回的响应体
 *
 * @author zc
 * @date 2019-10-24
 */
@Data
@AllArgsConstructor
public class ResultBody {
    private int status;
    private String message;
    private Object result;

    public static ResultBody success(Object result) {
        return new ResultBody(200, "success", result);
    }

    public static ResultBody badRequest(String message) {
        return new ResultBody(400, message, new JSONObject());
    }
}
