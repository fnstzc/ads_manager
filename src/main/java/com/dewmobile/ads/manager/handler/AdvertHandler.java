package com.dewmobile.ads.manager.handler;

import com.alibaba.fastjson.JSONArray;
import com.dewmobile.ads.manager.body.QueryAdsReq;
import com.dewmobile.ads.manager.body.ResultBody;
import com.dewmobile.ads.manager.mapper.AdvertMapper;
import com.dewmobile.ads.manager.util.JsonUtils;
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

        if (StringUtils.isEmpty(req.getAccesskey()) || StringUtils.isEmpty(req.getCampaign())) {
            return Mono.just(ResultBody.badRequest("param is incomplete!"));
        }
        String accountName = authHandler.getAccountName(req.getAccesskey());
        if (StringUtils.isEmpty(accountName)) {
            rb = ResultBody.badRequest("account is not exist!");
        } else {
            // 首先检查请求的campaign是否属于该account账户名下，不是则失败
            Optional<String> campaignName = advertMapper.findAccountCampaigns(accountName).stream()
                    .filter(cname -> cname.equals(req.getCampaign())).findFirst();
            if (campaignName.isPresent()) {

                rb = ResultBody.success(getAdsReports(req));
            } else {
                rb = ResultBody.badRequest("campaign is not found!");
            }
        }
        return Mono.just(rb);
    }

    private JSONArray getAdsReports(QueryAdsReq req) {
        JSONArray jsonArray = new JSONArray();
        advertMapper.findAdsShowReport(req.getCampaign(), req.getStartTime(), req.getEndTime()).stream()
                .map(JsonUtils::toJson).forEach(jsonArray::add);
        return jsonArray;
    }

    private JSONArray getAdsRatios(QueryAdsReq req) {
        JSONArray jsonArray = new JSONArray();
        long campaignId = advertMapper.findCampaignId(req.getCampaign());
        List<String> countrys = advertMapper.findAdsCountrys(campaignId);

        return jsonArray;
    }
}
