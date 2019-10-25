package com.dewmobile.ads.manager.controller;

import com.dewmobile.ads.manager.body.KeyApplyReq;
import com.dewmobile.ads.manager.body.ResultBody;
import com.dewmobile.ads.manager.handler.AuthHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * 权限控制类
 *
 * @author zc
 * @date 2019-10-22
 */
@RestController
@RequestMapping("/adplat/auth")
public class AuthController {

    private final AuthHandler authHandler;

    public AuthController(AuthHandler authHandler) {
        this.authHandler = authHandler;
    }

    @PostMapping(value = "/apply")
    public Mono<ResultBody> assignAccessKey(@RequestBody KeyApplyReq req) {
        return authHandler.assiginAccessKey(req);
    }

}
