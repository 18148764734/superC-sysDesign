package com.baihe.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 重置密码模板
 */
@Configuration
@PropertySource(value = "classpath:sms3.properties",encoding = "UTF-8")
@ConfigurationProperties(prefix = "sms3")
public class SmsConfig3 {

    @Value("${sms3.secretId}")
    //用户秘密ID
    String secretId;
    //用户密钥
    @Value("${sms3.secretKey}")
    String secretKey;
    //腾讯云应用ID
    @Value("${sms3.SmsSdkAppId}")
    String smsSdkAppId;
    //腾讯云签名
    @Value("${sms3.SignName}")
    String signName;
    //腾讯云模板ID
    @Value("${sms3.templateId}")
    String templateId;

    public String getSecretId() {
        return secretId;
    }

    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getSmsSdkAppId() {
        return smsSdkAppId;
    }

    public void setSmsSdkAppId(String smsSdkAppId) {
        this.smsSdkAppId = smsSdkAppId;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }
}
