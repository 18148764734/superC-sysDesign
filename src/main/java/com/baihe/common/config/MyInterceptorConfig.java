package com.baihe.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyInterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 实现WebMvcConfigurer不会导致静态资源被拦截.
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/end/page/**","/**")
                .excludePathPatterns("/end/page/login.html", "/end/page/register.html","/**/doc.*",
                        "/**/swagger-ui.*",
                        "/**/swagger-resources",
                        "/**/webjars/**",
                        "/**/v2/api-docs/**","/api/login","/api/loginsms","/api/signup","/api/send");
    }

    //.addPathPatterns("/end/page/**","/**")
    //                .excludePathPatterns("/end/page/login.html", "/end/page/register.html");

}
