package com.dewmobile.ads.manager.handler;

import com.dewmobile.ads.manager.mapper.AdvertMapper;
import org.springframework.stereotype.Component;

@Component
public class AdvertHandler {

    private final AdvertMapper advertMapper;


    public AdvertHandler(AdvertMapper advertMapper) {
        this.advertMapper = advertMapper;
    }

}
