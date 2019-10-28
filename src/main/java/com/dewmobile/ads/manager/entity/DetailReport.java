package com.dewmobile.ads.manager.entity;


import lombok.Data;

/**
 * 暂时没有对城市占比图进行假数据编辑，此类暂时不用
 *
 * */
@Data
public class DetailReport extends DetailReportOrigin {

    private int displayReal;
    private int clickReal;
    private int downloadReal;
    private int downlodaSuccessReal;
    private int transferSuccessReal;
    private int installReal;
    private int installSuccessReal;

    public DetailReport(String mid, long campaignId, String campaignName, String company, String pkg, String appName, String url, String country, String province, String city, String carrierOp, String date, int display, int click, int download, int downloadSuccess, int transferSuccess, int install, int installSuccess, int displayReal, int clickReal, int downloadReal, int downlodaSuccessReal, int transferSuccessReal, int installReal, int installSuccessReal) {
        super(mid, campaignId, campaignName, company, pkg, appName, url, country, province, city, carrierOp, date, display, click, download, downloadSuccess, transferSuccess, install, installSuccess);
        this.displayReal = displayReal;
        this.clickReal = clickReal;
        this.downloadReal = downloadReal;
        this.downlodaSuccessReal = downlodaSuccessReal;
        this.transferSuccessReal = transferSuccessReal;
        this.installReal = installReal;
        this.installSuccessReal = installSuccessReal;
    }
}
