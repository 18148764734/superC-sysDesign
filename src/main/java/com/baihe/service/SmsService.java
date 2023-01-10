package com.baihe.service;

import cn.hutool.json.JSONUtil;
import com.baihe.dao.SmsDao;
import org.springframework.stereotype.Service;
import com.baihe.entity.Sms;
import com.baihe.vo.SmsVo;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Value;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public interface SmsService {


    Sms add(Sms sms);

    void delete(Long id);

    void update(Sms sms);

    Sms findById(Long id);

    Sms findByCode(String code);

    Sms findByPhone(String phone,String type);

    List<SmsVo> findAll();

    PageInfo<SmsVo> findPage(String name, Integer pageNum, Integer pageSize, HttpServletRequest request) ;

    List<SmsVo> findAllPage(HttpServletRequest request, String name) ;

}
