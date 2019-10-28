package com.dewmobile.ads.manager.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * accesskey请求体
 *
 * @author zc
 * @date 2019-10-22
 */
@Data
public class KeyApplyReq {
    @JsonProperty("loginname")
    private String loginName;
}
