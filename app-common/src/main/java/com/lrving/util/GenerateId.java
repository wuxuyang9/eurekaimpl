package com.lrving.util;

import lombok.Data;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Properties;

/**
 * @program: V1.1.10.1
 * @description 雪花算法生成器封装
 * @author: luolang
 * @create: 2019-01-20 15:26
 **/

@Component
@Data
//@ConfigurationProperties(prefix = "app.snowflake",ignoreUnknownFields = false)
public class GenerateId implements IdentifierGenerator, Configurable {
    /* @Autowired
     private SessionFactory sessionFactory;*/
    public String dataCenterID;
    public String idLength;

    /*private String workerId = "0";
    private String datacenterId = "0";*/

    private SnowflakeIdWorker snowflakeIdWorker;

    /*@Autowired
    private AppConfig appConfig;*/

    /**
     * 加载配置文件中的数据初始化snowflakeworker类
     */
    @Override
    public void configure(Type type, Properties properties, ServiceRegistry serviceRegistry) throws MappingException {
        //加载配置文件
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("application.yml"));
        Properties yml=yaml.getObject();
        String workid = yml.getProperty("app.snowflake.worker-id");
        String dataid = yml.getProperty("app.snowflake.datacenter-id");
        snowflakeIdWorker = new SnowflakeIdWorker(Long.valueOf(workid),Long.valueOf(dataid));
    }

    /**
     * hibernate自定义主键生成规则必须实现 IdentifierGenerator  generate 为默认方法
     */
    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        return snowflakeIdWorker.nextId();
//        return dataCenterID + idLength;
    }
}
