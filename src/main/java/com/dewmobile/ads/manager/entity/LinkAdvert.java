package com.dewmobile.ads.manager.entity;

import lombok.Data;

/**
 * @author zc
 * @date 2018-11-11
 */
@Data
public class LinkAdvert implements Cloneable{
    private String date;
    private int pid;
    private String url;
    private int display;
    private int click;
    private double payout;

    public LinkAdvert combine(LinkAdvert linkAdvert) {
        this.display = this.display + linkAdvert.getDisplay();
        this.click = this.click + linkAdvert.getClick();
        if (this.payout == 0) {
            this.payout = this.payout + linkAdvert.getPayout();
        }
        return this;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
