package com.dewmobile.ads.manager.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zc
 * @date 2018-11-01
 */
@Data
@NoArgsConstructor
public class AdvertReportOrigin implements Cloneable {
    private int id;
    private int pid;
    private String mid;
    private long campaign_id;
    private String campaign_name;
    private String banner;
    private String app_icon;
    private String app_name;
    private String package_name;
    private String url;
    private String date;
    private int impression;
    private int click;
    private double ctr;
    private int download;
    private int download_success;
    private int install_tot;
    private int install_sum;
    private int install_avg;
    private double cvr;
    private double price;
    private double spent;

    public AdvertReportOrigin(int pid, String mid, long campaign_id, String campaign_name, String banner, String app_icon, String app_name, String package_name, String url, String date, int impression, int click, double ctr, int download, int download_success, int install_tot, int install_sum, int install_avg, double cvr, double price, double spent) {
        this.pid = pid;
        this.mid = mid;
        this.campaign_id = campaign_id;
        this.campaign_name = campaign_name;
        this.banner = banner;
        this.app_icon = app_icon;
        this.app_name = app_name;
        this.package_name = package_name;
        this.url = url;
        this.date = date;
        this.impression = impression;
        this.click = click;
        this.ctr = ctr;
        this.download = download;
        this.download_success = download_success;
        this.install_tot = install_tot;
        this.install_sum = install_sum;
        this.install_avg = install_avg;
        this.cvr = cvr;
        this.price = price;
        this.spent = spent;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}