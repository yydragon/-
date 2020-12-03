package com.yan.cloud.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConstantPropertiesUtils implements InitializingBean {
    @Value("${spring.cloud.alicloud.access-key}")
    private String keyId;
    @Value("${spring.cloud.alicloud.secret-key}")
    private String keySecret;
    @Value("${spring.cloud.alicloud.oss.endpoint}")
    private String endpoint;

    //定义公开的静态常量
    public static String END_POINT;
    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;


    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT = endpoint;
        ACCESS_KEY_ID = keyId;
        ACCESS_KEY_SECRET = keySecret;
    }
}
