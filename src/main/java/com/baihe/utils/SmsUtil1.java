package com.baihe.utils;

import com.baihe.config.SmsConfig1;
import com.baihe.config.SmsConfig2;
import com.baihe.config.SmsConfig3;
import com.baihe.config.SmsConfig4;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.sms.v20210111.SmsClient;
import com.tencentcloudapi.sms.v20210111.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author biqi
 * @date 2022/11/1
 */
@Component
public class SmsUtil1 {

    SmsConfig1 smsConfig1;
    @Autowired
    public void setSmsConfig(SmsConfig1 smsConfig1) {
        this.smsConfig1 = smsConfig1;
    }

    SmsConfig2 smsConfig2;
    @Autowired
    public void setSmsConfig(SmsConfig2 smsConfig2) {
        this.smsConfig2 = smsConfig2;
    }


    SmsConfig3 smsConfig3;
    @Autowired
    public void setSmsConfig(SmsConfig3 smsConfig3) {
        this.smsConfig3 = smsConfig3;
    }


    SmsConfig4 smsConfig4;
    @Autowired
    public void setSmsConfig(SmsConfig4 smsConfig4) {
        this.smsConfig4 = smsConfig4;
    }

    /**
     * 发送短信的方法
     * @param phone：接受短信的手机号码
     * @param code：模板所需的参数
     * @return
     */
    public String send(String phone,String code,Integer select){


        String result = null;
        if (select==1){
            try{
                // 实例化一个认证对象，入参需要传入腾讯云账户secretId，secretKey,此处还需注意密钥对的保密
                // 密钥可前往https://console.cloud.tencent.com/cam/capi网站进行获取
                Credential cred = new Credential(smsConfig1.getSecretId(), smsConfig1.getSecretKey());
                // 实例化一个http选项，可选的，没有特殊需求可以跳过
                HttpProfile httpProfile = new HttpProfile();
                httpProfile.setEndpoint("sms.tencentcloudapi.com");
                // 实例化一个client选项，可选的，没有特殊需求可以跳过
                ClientProfile clientProfile = new ClientProfile();
                clientProfile.setHttpProfile(httpProfile);

                // 实例化要请求产品的client对象,clientProfile是可选的
                SmsClient client = new SmsClient(cred, "ap-nanjing", clientProfile);
                // 实例化一个请求对象,每个接口都会对应一个request对象
                SendSmsRequest req = new SendSmsRequest();
                String[] phoneNumberSet1 = {phone};
                req.setPhoneNumberSet(phoneNumberSet1);

                req.setSmsSdkAppId(smsConfig1.getSmsSdkAppId());
                req.setSignName(smsConfig1.getSignName());
                req.setTemplateId(smsConfig1.getTemplateId());

                String[] templateParamSet1 = {code};
                req.setTemplateParamSet(templateParamSet1);

                // 返回的resp是一个SendSmsResponse的实例，与请求对象对应
                SendSmsResponse resp = client.SendSms(req);
                // 输出json格式的字符串回包
                System.out.println(SendSmsResponse.toJsonString(resp));

                result = SendSmsResponse.toJsonString(resp);
            } catch (TencentCloudSDKException e) {
                System.out.println(e.toString());
            }

        }
        if (select==2){
            try{
                // 实例化一个认证对象，入参需要传入腾讯云账户secretId，secretKey,此处还需注意密钥对的保密
                // 密钥可前往https://console.cloud.tencent.com/cam/capi网站进行获取
                Credential cred = new Credential(smsConfig2.getSecretId(), smsConfig2.getSecretKey());
                // 实例化一个http选项，可选的，没有特殊需求可以跳过
                HttpProfile httpProfile = new HttpProfile();
                httpProfile.setEndpoint("sms.tencentcloudapi.com");
                // 实例化一个client选项，可选的，没有特殊需求可以跳过
                ClientProfile clientProfile = new ClientProfile();
                clientProfile.setHttpProfile(httpProfile);

                // 实例化要请求产品的client对象,clientProfile是可选的
                SmsClient client = new SmsClient(cred, "ap-nanjing", clientProfile);
                // 实例化一个请求对象,每个接口都会对应一个request对象
                SendSmsRequest req = new SendSmsRequest();
                String[] phoneNumberSet1 = {phone};
                req.setPhoneNumberSet(phoneNumberSet1);

                req.setSmsSdkAppId(smsConfig2.getSmsSdkAppId());
                req.setSignName(smsConfig2.getSignName());
                req.setTemplateId(smsConfig2.getTemplateId());

                String[] templateParamSet1 = {code};
                req.setTemplateParamSet(templateParamSet1);

                // 返回的resp是一个SendSmsResponse的实例，与请求对象对应
                SendSmsResponse resp = client.SendSms(req);
                // 输出json格式的字符串回包
                System.out.println(SendSmsResponse.toJsonString(resp));

                result = SendSmsResponse.toJsonString(resp);
            } catch (TencentCloudSDKException e) {
                System.out.println(e.toString());
            }

        }

        if (select==3){
            try{
                // 实例化一个认证对象，入参需要传入腾讯云账户secretId，secretKey,此处还需注意密钥对的保密
                // 密钥可前往https://console.cloud.tencent.com/cam/capi网站进行获取
                Credential cred = new Credential(smsConfig3.getSecretId(), smsConfig3.getSecretKey());
                // 实例化一个http选项，可选的，没有特殊需求可以跳过
                HttpProfile httpProfile = new HttpProfile();
                httpProfile.setEndpoint("sms.tencentcloudapi.com");
                // 实例化一个client选项，可选的，没有特殊需求可以跳过
                ClientProfile clientProfile = new ClientProfile();
                clientProfile.setHttpProfile(httpProfile);

                // 实例化要请求产品的client对象,clientProfile是可选的
                SmsClient client = new SmsClient(cred, "ap-nanjing", clientProfile);
                // 实例化一个请求对象,每个接口都会对应一个request对象
                SendSmsRequest req = new SendSmsRequest();
                String[] phoneNumberSet1 = {phone};
                req.setPhoneNumberSet(phoneNumberSet1);

                req.setSmsSdkAppId(smsConfig3.getSmsSdkAppId());
                req.setSignName(smsConfig3.getSignName());
                req.setTemplateId(smsConfig3.getTemplateId());

                String[] templateParamSet1 = {code};
                req.setTemplateParamSet(templateParamSet1);

                // 返回的resp是一个SendSmsResponse的实例，与请求对象对应
                SendSmsResponse resp = client.SendSms(req);
                // 输出json格式的字符串回包
                System.out.println(SendSmsResponse.toJsonString(resp));

                result = SendSmsResponse.toJsonString(resp);
            } catch (TencentCloudSDKException e) {
                System.out.println(e.toString());
            }

        }

        if (select==4){
            try{
                // 实例化一个认证对象，入参需要传入腾讯云账户secretId，secretKey,此处还需注意密钥对的保密
                // 密钥可前往https://console.cloud.tencent.com/cam/capi网站进行获取
                Credential cred = new Credential(smsConfig4.getSecretId(), smsConfig4.getSecretKey());
                // 实例化一个http选项，可选的，没有特殊需求可以跳过
                HttpProfile httpProfile = new HttpProfile();
                httpProfile.setEndpoint("sms.tencentcloudapi.com");
                // 实例化一个client选项，可选的，没有特殊需求可以跳过
                ClientProfile clientProfile = new ClientProfile();
                clientProfile.setHttpProfile(httpProfile);

                // 实例化要请求产品的client对象,clientProfile是可选的
                SmsClient client = new SmsClient(cred, "ap-nanjing", clientProfile);
                // 实例化一个请求对象,每个接口都会对应一个request对象
                SendSmsRequest req = new SendSmsRequest();
                String[] phoneNumberSet1 = {phone};
                req.setPhoneNumberSet(phoneNumberSet1);

                req.setSmsSdkAppId(smsConfig4.getSmsSdkAppId());
                req.setSignName(smsConfig4.getSignName());
                req.setTemplateId(smsConfig4.getTemplateId());

                String[] templateParamSet1 = {code};
                req.setTemplateParamSet(templateParamSet1);

                // 返回的resp是一个SendSmsResponse的实例，与请求对象对应
                SendSmsResponse resp = client.SendSms(req);
                // 输出json格式的字符串回包
                System.out.println(SendSmsResponse.toJsonString(resp));

                result = SendSmsResponse.toJsonString(resp);
            } catch (TencentCloudSDKException e) {
                System.out.println(e.toString());
            }

        }


        return result;
    }


}
