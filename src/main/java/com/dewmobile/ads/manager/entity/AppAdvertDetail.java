package com.dewmobile.ads.manager.entity;

import lombok.Data;

@Data
public class AppAdvertDetail {

    private String date;
    private String mid;
    private String company;
    private String pkg;
    private String appname;
    private String country;
    private String province;
    private String city;
    private String carrier_op;
    private int display;
    private int click;
    private int download;
    private int download_success;
    private int transfer_success;
    private int install;
    private int install_success;

    public AppAdvertDetail combine(AppAdvertDetail appDetail) {
        this.display = this.display + appDetail.getDisplay();
        this.click = this.click + appDetail.getClick();
        this.download = this.download + appDetail.getDownload();
        this.download_success = this.download_success + appDetail.getDownload_success();
        this.transfer_success = this.transfer_success + appDetail.getTransfer_success();
        this.install_success = this.install_success + appDetail.getInstall_success();
        this.install = this.install + appDetail.getInstall();

        return this;
    }
}
