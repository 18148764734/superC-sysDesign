package com.baihe.common.config;

import com.baihe.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * 拦截器.
 * @author nsw
 */
public class MyInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate redistp;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse
            response, Object handler) throws Exception {
        String token = request.getHeader("token");
        token=token==null?"":token;
        Long expire = redistp.getExpire(token);
        if (expire >0) {
            redistp.expire(token,30L, TimeUnit.DAYS);
            return true;
        }else {
            response.sendRedirect("/end/page/login.html");
            return false;
        }

    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse
            response, Object handler, ModelAndView modelAndView) throws Exception {
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse
            response, Object handler, Exception ex) throws Exception {
    }
}
