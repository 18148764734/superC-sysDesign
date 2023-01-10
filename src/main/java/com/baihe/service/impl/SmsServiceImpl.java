package com.baihe.service.impl;

import com.baihe.dao.SmsDao;
import com.baihe.entity.Sms;
import com.baihe.service.SmsService;
import com.baihe.vo.SmsVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SmsServiceImpl implements SmsService {
    @Value("${authority.info}")
    private String authorityInfo;

    @Resource
    private SmsDao smsDao;

    public Sms add(Sms sms) {
        sms.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        smsDao.insertSelective(sms);
        return sms;
    }

    public void delete(Long id) {
        smsDao.deleteByPrimaryKey(id);
    }

    public void update(Sms sms) {
        sms.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        smsDao.updateByPrimaryKeySelective(sms);
    }

    public Sms findById(Long id) {
        return smsDao.selectByPrimaryKey(id);
    }

    public Sms findByCode(String code) {
        return smsDao.findByCodeone(code);
    }

    public Sms findByPhone(String phone,String type) {
        return smsDao.findByPhoneone(phone,type);
    }

    public List<SmsVo> findAll() {
        return smsDao.findByCode("all");
    }

    public PageInfo<SmsVo> findPage(String name, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
        List<SmsVo> all = findAllPage(request, name);
        return PageInfo.of(all);
    }

    public List<SmsVo> findAllPage(HttpServletRequest request, String name) {
        return smsDao.findByCode(name);
    }
}
