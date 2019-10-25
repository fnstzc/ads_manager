package com.dewmobile.ads.manager.controller;

import com.dewmobile.ads.manager.body.QueryAdsReq;
import com.dewmobile.ads.manager.body.ResultBody;
import com.dewmobile.ads.manager.handler.AdvertHandler;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * 广告数据控制类
 *
 * @author zc
 * @date 2019-10-22
 */
@RestController
@RequestMapping("/adplat/data")
public class AdvertController {

    private final AdvertHandler advertHandler;

    public AdvertController(AdvertHandler advertHandler) {
        this.advertHandler = advertHandler;
    }

    @PostMapping(value = "/advert")
    public Mono<ResultBody> getAdsShowReportData(@RequestBody QueryAdsReq req) {
        return advertHandler.getAdsShowReportData(req);
    }

}
