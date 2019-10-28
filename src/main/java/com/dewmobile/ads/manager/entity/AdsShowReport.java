package com.dewmobile.ads.manager.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdsShowReport extends AdvertReportOrigin {

    private int install;

    public AdsShowReport(int pid, String mid, long campaign_id, String campaign_name, String banner, String app_icon, String app_name, String package_name, String url, String date, int impression, int click, double ctr, int download, int download_success, int install_tot, int install_sum, int install_avg, double cvr, double price, double spent, int install) {
        super(pid, mid, campaign_id, campaign_name, banner, app_icon, app_name, package_name, url, date, impression, click, ctr, download, download_success, install_tot, install_sum, install_avg, cvr, price, spent);
        this.install = install;
    }
//
//    @Override
//    public String toString() {
//        final StringBuilder sb = new StringBuilder("AdsShowReport{");
//        sb.append("install=").append(install);
//        sb.append('}');
//        return sb.toString();
//    }
}
