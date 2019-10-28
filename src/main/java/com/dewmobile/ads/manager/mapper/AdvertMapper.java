package com.dewmobile.ads.manager.mapper;

import com.dewmobile.ads.manager.entity.AdsShowReport;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface AdvertMapper {

    @Select("select date,impression,click,ctr,download,install,cvr,price,spent from ads_show_reports where campaign_name = #{cname} and date >= #{start} and date <= #{end} order by date desc")
    List<AdsShowReport> findAdsShowReport(
            @Param("cname") String campaignName,
            @Param("start") String startTime,
            @Param("end") String endTime
    );

    @Select("select campaign_n from campaigns where account_id = (select id from accounts where login = #{login})")
    List<String> findAccountCampaigns(@Param("login") String accountName);

    @Select("select password from accounts where login = #{login}")
    String findPassword(@Param("login") String username);

    @Select("select id from campaigns where campaign_n = #{cname}")
    long findCampaignId(@Param("cname") String campaignName);

    @Select("select ads_country from formula where campaign_id = #{cid}")
    List<String> findAdsCountrys(@Param("cid") long campaignId);

    @Select("select cities from campaigns where id = #{cid}")
    List<String> findCity(@Param("cid") long campaignId);

    @Select("select distinct city from detail_report_origin where campaign_id = #{cid} and country = #{country} and date = #{date}")
    List<String> findCityFromDetailReport(@Param("cid") long campaignId, @Param("country") String country, @Param("date") String date);

    @Select({"<script>",
            "select SUM(`display`) sum_impression, SUM(`click`) sum_click, SUM(`install_success`) sum_install ",
            "from `detail_reports_origin` ",
            "where campaign_id = #{campaignId} and date = #{date} and country in ",
                "<foreach collection='countrys' item='country' open='(' separator=',' close=')'>",
                    "#{country}",
                "</foreach>",
            " group by country",
            "</script>"})
    Map<String, Integer> findCityRadios(@Param("cid") long campaignId, @Param("countrys") List<String> countrys, @Param("date") String date);
}
