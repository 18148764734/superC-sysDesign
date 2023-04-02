package com.baihe.config;

import com.baihe.common.ResultCode;
import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.http.HttpMethod.*;


/**
 * @author : tkz
 * @date : 2021/12/20 10:38
 */
@Configuration
@EnableKnife4j
public class Knife4jConfiguration {

    // 创建Docket存入容器，Docket代表一个接口文档
    @Bean
    public Docket webApiConfig(){

//        List<Response> responseList = new ArrayList<>();
//        Arrays.stream(ResultCode.values()).forEach(resultCode -> {
//            responseList.add(
//                    new ResponseBuilder().code(resultCode.getCode().toString()).description(resultCode.getMessage()).build()
//            );
//        });
        return new Docket(DocumentationType.SWAGGER_2)
                // 创建接口文档的具体信息
                .apiInfo(webApiInfo())
                // 创建选择器，控制哪些接口被加入文档
                .select()
                // 指定@ApiOperation标注的接口被加入文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .build();
    }

    // 创建接口文档的具体信息，会显示在接口文档页面中
    private ApiInfo webApiInfo(){
        return new ApiInfoBuilder()
                // 文档标题
                .title("登录注册模块接口文档")
                // 文档描述
                .description("包含登录，日程，八字相关接口")
                // 版本
                .version("1.0")
                // 联系人信息
                .contact(new Contact("lamb", "", ""))
                // 版权
                .license("lamb")
                // 版权地址
//                .licenseUrl("http://www.baobao.com")
                .build();
    }


//




}
