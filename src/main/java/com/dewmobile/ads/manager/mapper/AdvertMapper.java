package com.dewmobile.ads.manager.mapper;

import com.dewmobile.ads.common.AdsShowReport;
import com.dewmobile.ads.common.AdvertReport;
import com.dewmobile.ads.common.AppAdvert;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import java.util.List;

@Mapper
@Component
public interface AdvertMapper {

    @Select("select date,impression,click,ctr,download,install,cvr,price,spent from ads_show_reports where campaign_name = #{cname} and date >= #{start} and date <= #{end} order by date desc")
    List<AdsShowReport> getAdsShowReport(
            @Param("cname") String campaignName,
            @Param("start") String startTime,
            @Param("end") String endTime
    );

    @Select("select campaign_n from campaigns where account_id = (select id from accounts where login = #{login})")
    List<String> getAccountCampaigns(@Param("login") String accountName);

    @Select("select password from accounts where login = #{login}")
    String getPassword(@Param("login") String username);

    @Select("select * from daily_advert_app where date = #{date} and mid = #{mid}")
    List<AppAdvert> getAppAdvertByMid(
            @Param("date") String date,
            @Param("mid") String mid
    );

    @Select("select * from advert_reports where date = #{date} and mid = #{mid}")
    List<AdvertReport> getAdvertReportsByMid(
            @Param("date") String date,
            @Param("mid") String mid
    );

    @Select("select * from advert_reports where date = #{date}")
    List<AdvertReport> getAdvertReports(
            @Param("date") String date
    );

    @Delete("delete from ads_show_reports where date > #{date}")
    int deleteAdsShowReport(
            @Param("date") String date
    );

    @Delete("delete from advert_reports where date > #{date}")
    int deleteAdvertReport(
            @Param("date") String date
    );

    @Delete("delete from advert_reports_origin where date > #{date}")
    int deleteAdvertOriginReport(
            @Param("date") String date
    );

    @Delete("delete from detail_reports_origin where date > #{date}")
    int deleteDetailReportOrigin(
            @Param("date") String date
    );
}
