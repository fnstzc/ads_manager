package com.dewmobile.ads.manager.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AccessKeyMapper {

    /**
     * 获取accesskey
     * @param account 客户名称
     * @return accesskey
     */
    @Select("select accesskey from account_accesskey where account = #{account}")
    String getAccessKey(@Param("account") String account);

    /**
     * 获取客户名称
     * @param accessKey key
     * @return 客户名称
     */
    @Select("select account from account_accesskey where accesskey = #{accesskey}")
    String getAccountName(@Param("accesskey") String accessKey);

    /**
     * 插入accesskey和客户的对应关系
     * @param accountName 客户名称
     * @param accessKey accesskey
     * @return 成功插入条数
     */
    @Insert("insert into account_accesskey (account, accesskey) values (#{account}, #{accesskey})")
    int insertAccessKey(@Param("account") String accountName, @Param("accesskey") String accessKey);
}
