package com.baihe.dao;

import com.baihe.entity.Sms;
import com.baihe.vo.SmsVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface SmsDao extends Mapper<Sms> {
    List<SmsVo> findByCode(@Param("code") String code);
    Sms findByCodeone(@Param("code") String code);
    Sms findByPhoneone(@Param("phone") String phone,@Param("type") String type);

    
}
