package com.baihe.service.impl;

import cn.hutool.core.lang.UUID;
import cn.hutool.crypto.SecureUtil;
import com.baihe.common.ResultCode;
import com.baihe.dao.UserDao;
import com.baihe.entity.User;
import com.baihe.exception.CustomException;
import com.baihe.service.UserService;
import com.baihe.utils.TokenUtils;
import com.baihe.vo.UserVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userInfoDao;

    public User add(User user) {
        // 唯一校验
        int count = userInfoDao.checkRepeat("username", user.getName(), null);
        if (count > 0) {
            throw new CustomException("1001", "用户名\"" + user.getName() + "\"已存在");
        }
        int count2 = userInfoDao.checkRepeat("phone", user.getPhone(), null);
        if (count2 > 0) {
            throw new CustomException("1001", "手机号\"" + user.getPhone() + "\"已存在");
        }
        if (StringUtils.isEmpty(user.getPassword())) {
            // 默认密码123456
            user.setPassword(SecureUtil.md5("123456"));
        } else {
            user.setPassword(SecureUtil.md5(user.getPassword()));
        }
        user.setUserdate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        user.setId(this.getUUID());
        userInfoDao.insertSelective(user);
        return user;
    }

    public void delete(Long id) {
        userInfoDao.deleteByPrimaryKey(id);
    }

    public void update(User user) {
        userInfoDao.updateByPrimaryKeySelective(user);
    }

    public User findById(Long id) {
        return userInfoDao.selectByPrimaryKey(id);
    }

    public List<UserVo> findAll() {
        return userInfoDao.findByName("all");
    }

    public PageInfo<UserVo> findPage(String name, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserVo> all = userInfoDao.findByName(name);
        return PageInfo.of(all);
    }

    public UserVo findByUserName(String name) {
        return userInfoDao.findByUsername(name);
    }

    public UserVo findByPhone(String phone) {
        UserVo userVo = userInfoDao.findByPhone(phone);
        userVo.setNewPassword(TokenUtils.token(userVo.getName(),userVo.getPassword()));
        userVo.setPassword("");
        return userVo;
    }

    public User login(String username, String password) {
        User user = userInfoDao.findByUsername(username);
        if (user == null) {
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }
        if (!SecureUtil.md5(password).equalsIgnoreCase(user.getPassword())) {
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }
        user.setNewPassword(TokenUtils.token(username,password));
        return user;
    }

    public String getUUID()
    {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        System.out.println(uuid);
        StringBuffer str = new StringBuffer();

        for (int i = 0; i < 9; i++)
        {
            str.append(uuid.charAt(i));
        }

        return str.toString();

    }

    @Override
    public void updatePassword(User user) {
        UserVo user1 = userInfoDao.findByUsername(user.getName());
        if (user1!=null){
            if (SecureUtil.md5(user.getPassword()).equalsIgnoreCase(user1.getPassword())) {
                throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
            }
            user.setPassword(SecureUtil.md5(user.getPassword()));
            userInfoDao.updatePassword(user);
        }else {
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }


    }

    @Override
    public void updateRegisterPhone(User user) {
        UserVo user1 = userInfoDao.findByUsername(user.getName());
        if (user1!=null){
            int count = userInfoDao.checkRepeat("phone", user.getPhone(), null);
            if (count>0){
                throw new CustomException("1001", "手机号\"" + user.getPhone() + "\"已存在");
            }
            if (!SecureUtil.md5(user.getPassword()).equalsIgnoreCase(user1.getPassword())) {
                throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
            }
            userInfoDao.updateRegisterPhone(user);
        }else {
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }

    }


}
