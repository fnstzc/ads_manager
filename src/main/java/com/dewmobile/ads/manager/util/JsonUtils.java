package com.dewmobile.ads.manager.util;

import com.alibaba.fastjson.JSONObject;
import com.dewmobile.ads.manager.entity.AdsShowReport;

public class JsonUtils {

    public static JSONObject toJson(String key, Object value) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(key, value);
        return jsonObj;
    }

    public static JSONObject toJson(AdsShowReport adsShowReport) {
        JSONObject jsonObject = new JSONObject(true);
        jsonObject.put("date", adsShowReport.getDate());
        jsonObject.put("impression", adsShowReport.getImpression());
        jsonObject.put("click", adsShowReport.getClick());
        jsonObject.put("ctr", adsShowReport.getCtr());
        jsonObject.put("downloaded", adsShowReport.getDownload_success());
        jsonObject.put("install", adsShowReport.getInstall());
        jsonObject.put("cvr", adsShowReport.getCvr());
        jsonObject.put("price", adsShowReport.getPrice());
        jsonObject.put("spent", adsShowReport.getSpent());
        return jsonObject;
    }


}
