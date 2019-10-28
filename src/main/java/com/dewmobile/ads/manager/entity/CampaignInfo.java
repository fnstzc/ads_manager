package com.dewmobile.ads.manager.entity;

import lombok.Data;

import java.util.Objects;

@Data
public class CampaignInfo {
    private long id;
    private String campaign_n;
    private int model;
    private double price;
    private String pkgname;
    private String tracker_url;
    private String object_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CampaignInfo)) return false;
        CampaignInfo that = (CampaignInfo) o;
        return getId() == that.getId() &&
                getModel() == that.getModel() &&
                Double.compare(that.getPrice(), getPrice()) == 0 &&
                Objects.equals(getCampaign_n(), that.getCampaign_n()) &&
                Objects.equals(getPkgname(), that.getPkgname()) &&
                Objects.equals(getTracker_url(), that.getTracker_url()) &&
                Objects.equals(getObject_id(), that.getObject_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCampaign_n(), getModel(), getPrice(), getPkgname(), getTracker_url(), getObject_id());
    }

    @Override
    public String toString() {
        return "CampaignInfo{" +
                "id=" + id +
                ", campaign_n='" + campaign_n + '\'' +
                ", model=" + model +
                ", price=" + price +
                ", pkgname='" + pkgname + '\'' +
                ", tracker_url='" + tracker_url + '\'' +
                ", object_id='" + object_id + '\'' +
                '}';
    }
}
