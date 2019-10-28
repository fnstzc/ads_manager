package com.dewmobile.ads.manager.body;

import com.dewmobile.ads.manager.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 数据请求体
 *
 * @author zc
 * @date 2019-10-22
 */
@Data
public class QueryAdsReq {
    @JsonProperty("starttime")
    private String startTime;
    @JsonProperty("endtime")
    private String endTime;
    private String accesskey;
    private String campaign;

    {
        startTime = DateUtils.defaultStartTime();
        endTime = DateUtils.defaultEndTime();
    }
}
