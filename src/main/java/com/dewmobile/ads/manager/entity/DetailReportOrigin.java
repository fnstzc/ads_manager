package com.dewmobile.ads.manager.entity;

import lombok.Data;

/**
 * @author zc
 *
 * @date 2019-03-11
 */
@Data
public class DetailReportOrigin {

    private int id;
    private String mid;
    private long campaign_id;
    private String campaign_name;
    private String company;
    private String pkg;
    private String app_name;
    private String url;
    private String country;
    private String province;
    private String city;
    private String carrier_op;
    private String date;
    private int display;
    private int click;
    private int download;
    private int download_success;
    private int transfer_success;
    private int install;
    private int install_success;

    public DetailReportOrigin(String mid, long campaign_id, String campaign_name, String company, String pkg, String app_name, String url, String country, String province, String city, String carrier_op, String date, int display, int click, int download, int download_success, int transfer_success, int install, int install_success) {
        this.mid = mid;
        this.campaign_id = campaign_id;
        this.campaign_name = campaign_name;
        this.company = company;
        this.pkg = pkg;
        this.app_name = app_name;
        this.url = url;
        this.country = country;
        this.province = province;
        this.city = city;
        this.carrier_op = carrier_op;
        this.date = date;
        this.display = display;
        this.click = click;
        this.download = download;
        this.download_success = download_success;
        this.transfer_success = transfer_success;
        this.install = install;
        this.install_success = install_success;
    }
}
