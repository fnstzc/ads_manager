package com.dewmobile.ads.manager.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 数据请求体
 *
 * @author zc
 * @date 2019-10-22
 */
@Data
@AllArgsConstructor
public class QueryAdsReq {
    @JsonProperty("starttime")
    private String startTime;
    @JsonProperty("endtime")
    private String endTime;

    private String accesskey;
    private String campaign;
    private String order;
    private int limit;
}
