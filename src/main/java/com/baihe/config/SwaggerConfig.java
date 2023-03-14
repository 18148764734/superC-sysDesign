package com.baihe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
//开启swagger2
@EnableSwagger2
@ComponentScan({"com.baihe.config"})
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.baihe.controller"))
                .paths(PathSelectors.any())
                .build();
    }

   //配置swagger信息getApiInfo
    private ApiInfo getApiInfo(){

        return new ApiInfoBuilder()
                .title("登录注册和日程增删改，八字获取接口-SwaggerAPI文档") // 文档标题
                .version("2.0")
                .build();

    }

}
