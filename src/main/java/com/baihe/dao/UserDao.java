package com.baihe.dao;

import com.baihe.entity.User;
import com.baihe.vo.UserVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface UserDao extends Mapper<User> {
    List<UserVo> findByName(@Param("name") String name);
    
    int checkRepeat(String column, String value, Long id);
    UserVo findByUsername(String username);
    UserVo findByPhone(String phone);
    Integer count();

    @Select("select *from user where phone=#{phone}")
    User findByUserPhone(String phone);
    @Transactional
    @Update("update user set password=#{password} where username=#{name}")
    Integer updatePassword(User user);

    @Transactional
    @Update("update user set phone =#{phone} where username=#{name}")
    Integer updateRegisterPhone(User user);

}
