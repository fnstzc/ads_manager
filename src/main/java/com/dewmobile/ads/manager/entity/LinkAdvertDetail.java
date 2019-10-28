package com.dewmobile.ads.manager.entity;

import lombok.Data;

@Data
public class LinkAdvertDetail {
    private String date;
    private String country;
    private String province;
    private String city;
    private String carrierOp;
    private String url;
    private int display;
    private int click;
}
