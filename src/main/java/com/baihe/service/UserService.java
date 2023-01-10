package com.baihe.service;

import cn.hutool.core.lang.UUID;
import com.baihe.dao.UserDao;
import com.baihe.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.baihe.exception.CustomException;
import com.baihe.common.ResultCode;
import com.baihe.vo.UserVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.crypto.SecureUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public interface UserService {

    User add(User user) ;

    void delete(Long id);

    void update(User user);

    User findById(Long id);

    List<UserVo> findAll();

    PageInfo<UserVo> findPage(String name, Integer pageNum, Integer pageSize, HttpServletRequest request) ;
    UserVo findByUserName(String name);

    UserVo findByPhone(String phone);

    User login(String username, String password) ;

    String getUUID();

    void updatePassword(User user);

    void updateRegisterPhone(User user);
}
