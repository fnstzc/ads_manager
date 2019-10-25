package com.dewmobile.ads.manager.handler;

import com.alibaba.fastjson.JSONArray;
import com.dewmobile.ads.manager.body.QueryAdsReq;
import com.dewmobile.ads.manager.body.ResultBody;
import com.dewmobile.ads.manager.mapper.AdvertMapper;
import com.dewmobile.ads.manager.util.JsonUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

import java.util.*;

/**
 * 广告数据相关处理
 *
 * @author zc
 * @date 2019-10-24
 */
@Component
public class AdvertHandler {

    private final AuthHandler authHandler;
    private final AdvertMapper advertMapper;

    public AdvertHandler(AuthHandler authHandler, AdvertMapper advertMapper) {
        this.authHandler = authHandler;
        this.advertMapper = advertMapper;
    }

    public Mono<ResultBody> getAdsShowReportData(QueryAdsReq req) {
        ResultBody rb;
        String accountName = authHandler.getAccountName(req.getAccesskey());
        if (StringUtils.isEmpty(accountName)) {
            rb = ResultBody.badRequest("account is not exist!");
        } else {
            // 首先检查请求的campaign是否属于该account账户名下，不是则失败
            Optional<String> campaignName = advertMapper.getAccountCampaigns(accountName).stream()
                    .filter(cname -> cname.equals(req.getCampaign())).findFirst();
            if (campaignName.isPresent()) {
                JSONArray jsonArray = new JSONArray();
                advertMapper.getAdsShowReport(req.getCampaign(), req.getStartTime(), req.getEndTime()).stream()
                        .map(JsonUtil::toJson).forEach(jsonArray::add);
                rb = ResultBody.success(jsonArray);
            } else {
                rb = ResultBody.badRequest("campaign is not found!");
            }
        }
        return Mono.just(rb);
    }

}
