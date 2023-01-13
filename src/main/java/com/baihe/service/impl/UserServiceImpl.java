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
        //设置日期格式
        user.setUserdate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        //设置id为UUID的随机字符串
        user.setId(this.getUUID());
        userInfoDao.insertSelective(user);
        return user;
    }

    @Override
    public void checkPhone(User user) {
        //通过传入的用户姓名查找对应的用户
        UserVo user1 = userInfoDao.findByUsername(user.getName());
        if (user1!=null){
            //检阅手机号码是否存在
            int count = userInfoDao.checkRepeat("phone", user.getPhone(), null);
            if (count==0){
                //不存在就报错
                throw new CustomException("1001", "手机号\"" + user.getPhone() + "\"不存在");
            }
        }else {
            //用户不存在就报错
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }
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

    //UUID工具类
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
        //先查询数据库是否有该用户
        User user1 = userInfoDao.findByUserPhone(user.getPhone());
        if (user1!=null){
            //重置的密码与之前的相同也报错
            if (!SecureUtil.md5(user.getPassword()).equalsIgnoreCase(user1.getPassword())) {//进行md5解密  来对比密码是否一致
                user.setPassword(SecureUtil.md5(user.getPassword()));
                userInfoDao.updatePassword(user);
            }else {
                throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
            }
            //重置的密码进行md5加密

        }else {
            //没有该用户直接报错
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }


    }

    @Override
    public void updateRegisterPhone(User user) {
        //通过传入的用户姓名查找对应的用户
        UserVo user1 = userInfoDao.findByUsername(user.getName());
        if (user1!=null){
            //检阅手机号码是否存在
            int count = userInfoDao.checkRepeat("phone", user.getPhone(), null);
            if (count>0){
                //存在就报错
                throw new CustomException("1001", "手机号\"" + user.getPhone() + "\"已存在");
            }
            boolean b=!SecureUtil.md5(user.getPassword()).equalsIgnoreCase(user1.getPassword());
            //查看密码是不是符合用户设置的密码 不符合就报错
            if (!SecureUtil.md5(user.getPassword()).equalsIgnoreCase(user1.getPassword())) {
                throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
            }
            userInfoDao.updateRegisterPhone(user);
        }else {
            //用户不存在就报错
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }

    }


}
