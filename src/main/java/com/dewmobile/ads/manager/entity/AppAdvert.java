package com.dewmobile.ads.manager.entity;

import lombok.Data;

/**
 * @author zc
 * @date 2018-11-11
 */
@Data
public class AppAdvert implements Cloneable {
    private String date;
    private int pid;
    private String appname;
    private String pkg;
    private String mid;
    private int display;
    private int download;
    private int downloadSuccess;
    private int totalInstall;
    private double payout;
    private int install_sum;

    public AppAdvert combine(AppAdvert appAdvert) {
        this.display = this.display + appAdvert.getDisplay();
        this.download = this.download + appAdvert.getDownload();
        this.downloadSuccess = this.downloadSuccess + appAdvert.getDownloadSuccess();
        this.totalInstall = this.totalInstall + appAdvert.getTotalInstall();
        this.install_sum = this.install_sum + appAdvert.getInstall_sum();
        if (this.payout == 0) {
            this.payout = this.payout + appAdvert.getPayout();
        }
        return this;
    }

    @Override
    public String toString() {
        return "AppAdvert{" +
                "date='" + date + '\'' +
                ", pid=" + pid +
                ", appname='" + appname + '\'' +
                ", pkg='" + pkg + '\'' +
                ", mid='" + mid + '\'' +
                ", display=" + display +
                ", click=" + download +
                ", downloadSuccess=" + downloadSuccess +
                ", totalInstall=" + totalInstall +
                ", payout=" + payout +
                ", install_sum=" + install_sum +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
