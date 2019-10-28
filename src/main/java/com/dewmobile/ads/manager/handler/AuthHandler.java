package com.dewmobile.ads.manager.handler;

import com.dewmobile.ads.manager.body.KeyApplyReq;
import com.dewmobile.ads.manager.body.ResultBody;
import com.dewmobile.ads.manager.mapper.AccessKeyMapper;
import com.dewmobile.ads.manager.mapper.AdvertMapper;
import com.dewmobile.ads.manager.util.JsonUtils;
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

    private final AccessKeyMapper accessKeyMapper;

    public AuthHandler(AccessKeyMapper accessKeyMapper) {
        this.accessKeyMapper = accessKeyMapper;
    }

    String getAccountName(String accessKey) {
        return accessKeyMapper.getAccountName(accessKey);
    }

    public Mono<ResultBody> assiginAccessKey(KeyApplyReq req) {
        if (StringUtils.isEmpty(req.getLoginName())) {
            return Mono.just(ResultBody.badRequest("login name is missing!"));
        }
        String accessKey = accessKeyMapper.getAccessKey(req.getLoginName());
        if (StringUtils.isEmpty(accessKey)) {
            accessKey = UUID.randomUUID().toString().replaceAll("-", "");
            accessKeyMapper.insertAccessKey(req.getLoginName(), accessKey);
        }
        return Mono.just(ResultBody.success(JsonUtils.toJson("accesskey", accessKey)));
    }
}
