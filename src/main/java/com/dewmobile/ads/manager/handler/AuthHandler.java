package com.dewmobile.ads.manager.handler;

import com.alibaba.fastjson.JSONObject;
import com.dewmobile.ads.manager.body.KeyApplyReq;
import com.dewmobile.ads.manager.body.ResultBody;
import com.dewmobile.ads.manager.mapper.AccessKeyMapper;
import com.dewmobile.ads.manager.mapper.AdvertMapper;
import com.dewmobile.ads.manager.util.JsonUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * 权限验证相关处理
 *
 * @author zc
 * @date 2019-10-22
 */
@Component
public class AuthHandler {

    private final AdvertMapper advertMapper;
    private final AccessKeyMapper accessKeyMapper;

    public AuthHandler(AdvertMapper advertMapper, AccessKeyMapper accessKeyMapper) {
        this.advertMapper = advertMapper;
        this.accessKeyMapper = accessKeyMapper;
    }

    String getAccountName(String accessKey) {
        return accessKeyMapper.getAccountName(accessKey);
    }

    public Mono<ResultBody> assiginAccessKey(KeyApplyReq req) {
        ResultBody rb;
        String password = advertMapper.getPassword(req.getLoginName());
        if (StringUtils.isEmpty(password) || !password.equals(req.getPassword())) {
            rb = ResultBody.badRequest("loginname or password is wrong!");
        } else {
            String accessKey = accessKeyMapper.getAccessKey(req.getLoginName());
            if (StringUtils.isEmpty(accessKey)) {
                accessKey = UUID.randomUUID().toString().replaceAll("-", "");
                accessKeyMapper.insertAccessKey(req.getLoginName(), accessKey);
            }

            rb = ResultBody.success(JsonUtil.toJson("accesskey", accessKey));
        }
        return Mono.just(rb);
    }
}
