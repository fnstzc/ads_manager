package com.dewmobile.ads.manager.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author zc 2018-11-01
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AdvertReport extends AdvertReportOrigin {
    private int impression_real;
    private int click_real;
    private double ctr_real;
    private int download_real;
    private int download_success_real;
    private int install_tot_real;
    private int install_sum_real;
    private int install_avg_real;
    private double cvr_real;
    private double spent_real;

    public AdvertReport(int pid, String mid, long campaign_id, String campaign_name, String banner, String app_icon, String app_name, String package_name, String url, String date, int impression, int click, double ctr, int download, int download_success, int install_tot, int install_sum, int install_avg, double cvr, double price, double spent, int impression_real, int click_real, double ctr_real, int download_real, int download_success_real, int install_tot_real, int install_sum_real, int install_avg_real, double cvr_real, double spent_real) {
        super(pid, mid, campaign_id, campaign_name, banner, app_icon, app_name, package_name, url, date, impression, click, ctr, download, download_success, install_tot, install_sum, install_avg, cvr, price, spent);
        this.impression_real = impression_real;
        this.click_real = click_real;
        this.ctr_real = ctr_real;
        this.download_real = download_real;
        this.download_success_real = download_success_real;
        this.install_tot_real = install_tot_real;
        this.install_sum_real = install_sum_real;
        this.install_avg_real = install_avg_real;
        this.cvr_real = cvr_real;
        this.spent_real = spent_real;
    }
}