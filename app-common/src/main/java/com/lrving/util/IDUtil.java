package com.lrving.util;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;

import java.util.Properties;

/**
 * Created by wangBaiChuan 2019-03-22.
 */
public class IDUtil
{
    private static SnowflakeIdWorker snowflakeIdWorker;

    static {
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("application.yml"));
        Properties yml=yaml.getObject();
        String workid = yml.getProperty("app.snowflake.worker-id");
        String dataid = yml.getProperty("app.snowflake.datacenter-id");
        snowflakeIdWorker = new SnowflakeIdWorker(Long.valueOf(workid),Long.valueOf(dataid));

    }

    /**
     * 获取下一个id
     */
    public static Long nextLongId()
    {
        return snowflakeIdWorker.nextId();
    }

    public static String nextStrId()
    {
        return nextLongId().toString();

    }

}
