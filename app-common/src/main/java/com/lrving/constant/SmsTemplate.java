package com.lrving.constant;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @program: yunjinji
 * @description: 阿里云短信模板枚举类
 * @author: luo lang
 * @create: 2019-04-18 15:06
 **/

public class SmsTemplate {

    @NoArgsConstructor
    @AllArgsConstructor
    /**以下部分为固定的6套短信模板*/
    public static enum  Aliyun{
        AUTHENTICATION("身份验证验证码")
        ,LOGIN("登录确认验证码")
        ,ABNORMAL("登录异常验证码")
        ,REGISTER("用户注册验证码")
        ,ALERT_PWD("修改密码验证码")
        ,ALERT_INFO("信息变更验证码")
        ;
        private String name;
    }
}
