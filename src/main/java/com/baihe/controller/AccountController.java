package com.baihe.controller;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.baihe.common.Result;
import com.baihe.common.ResultCode;
import com.baihe.entity.Sms;
import com.baihe.entity.User;
import com.baihe.exception.CustomException;

import com.baihe.service.UserService;
import com.baihe.service.SmsService;
import com.baihe.utils.SmsUtil1;

import io.swagger.annotations.*;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import cn.hutool.core.util.ReUtil;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Api(value = "登录注册模块  拦截器返回的登录地址：/end/page/login.html")
@RestController
@RequestMapping("/api")//接口地址开头，后面方法都要加上/api,如http://127.0.0.1/api/signup
public class AccountController {

    SmsUtil1 smsUtil1;//短信工具

    @Value("${authority.info}")
    private String authorityStr;

    @Resource
    private UserService userInfoService;

    @Resource
    private SmsService smsService;

    //正则表达式 - 手机号 - 内地+虚拟+港澳台
    public static final String REG_MOBILE = "^(12[1-3]\\d{8})|[1][3-9]\\d{9}$|^([5|6|7|9])\\d{7}$|^[0][9]\\d{8}$|^[6]\\d{7}$";

    @Autowired
    public void setSmsUtil1(SmsUtil1 smsUtil1) {
        this.smsUtil1 = smsUtil1;
    }

    @Autowired
    private StringRedisTemplate redistp;


    @ApiResponses({
            @ApiResponse(code = 0,message = "成功"),
            @ApiResponse(code = 401,message = "参数错误/验证码过期或者未输入"),
            @ApiResponse(code = 2001,message = "未找到用户"),
            @ApiResponse(code = 2006,message = "不可与原密码相同")
    })
    @ApiOperation(value = "重置密码(首先得验证码通过)",notes = "需要的参数：phone，code（这边的code是通过发送（resetPassword类型）验证码收取到了code），password")
    @ApiParam("")
    @PostMapping("/resetpassword")
    public Result<User> resetPassword(@RequestBody User user){
        if (user.getPhone().equals("")) {
            return Result.error("401", "参数错误");
        }

        if(user.getCode().equals("")){
            return Result.error("401", "请输入验证码");
        }
        if(!user.getCode().equals(redistp.opsForValue().get("resetPassword"))){
            return Result.error("401", "验证码过期，请重新获取");
        }
        userInfoService.updatePassword(user);
        return Result.success(user);
    }



    @ApiResponses({
            @ApiResponse(code = 0,message = "成功"),
            @ApiResponse(code = 401,message = "参数错误/验证码过期或者未输入"),
            @ApiResponse(code = 1001,message = "手机号已存在"),
            @ApiResponse(code = 2002,message = "账号或密码错误")
    })
    @ApiOperation(value = "修改注册手机号",notes = "需要的参数：phone，code（这边的code是通过发送（updatePhone类型）验证码收取到了code），password,name")
    @PostMapping("/updatephone")
    public Result<User> updatePhone(@RequestBody User user){
        if (user.getPhone().equals("")) {
            return Result.error("401", "参数错误");
        }

        if(user.getCode().equals("")){
            return Result.error("401", "请输入验证码");
        }
        if(!user.getCode().equals(redistp.opsForValue().get("updatePhone"))){
            return Result.error("401", "验证码过期，请重新获取");
        }
        userInfoService.updateRegisterPhone(user);
        return Result.success(user);
    }




    @ApiResponses({
            @ApiResponse(code = 0,message = "成功"),
            @ApiResponse(code = 401,message = "参数错误/验证码过期或者未输入"),
            @ApiResponse(code = 1001,message = "手机号不存在"),
            @ApiResponse(code = 2002,message = "账号或密码错误")
    })
    @ApiOperation(value = "通过手机发送验证码验证，成功返回msg ：ok",notes = "需要的参数：phone，code（这边的code是通过发送（updatePhone类型）验证码收取到了code）,name")
    @PostMapping("/checkphone")
    public Result<String> checkPhone(@RequestBody User user) {

        userInfoService.checkPhone(user);
        String phone = user.getPhone();

        if (phone.equals("")) {
            return Result.error("401", "参数错误");
        }

        if(user.getCode().equals("")){
            return Result.error("401", "请输入验证码");
        }
        if(!user.getCode().equals(redistp.opsForValue().get("updatePhone"))){
            return Result.error("401", "验证码过期，请重新获取");
        }
        return Result.success("ok");
    }

    /**
     * 用户名登陆
     * 地址：http://网址/api/login
     * 方法 post
     * 参数json格式 如 {"phone":"","code":"","type":"login","name":"user01","password":"user111","level":null}，其中name为用户名,password为密码，其他按例子填写
     * 成功返回 code=0 为成功，其他为失败 {"code":"0","msg":"成功","data":{"password":"111111","newPassword":null,"userinfo":null,"sex":"男","age":null,"region":null,"phone":"15927614001","address":null,"userdate":"2022-12-18 23:53:06","identity":null,"level":1,"code":"13156","name":"user01","id":1}}
     * 失败返回 如 {"code":"2002","msg":"账号或密码错误","data":null}
     */

    @ApiResponses({
            @ApiResponse(code = 0,message = "成功"),
            @ApiResponse(code = 2002,message = "账号或密码错误")
    })
    @ApiOperation(value = "用户登录,成功即返回token信息",notes = "name，password")
    @PostMapping("/login")
    public Result<String> login(@RequestBody User user) {
        if (StrUtil.isBlank(user.getName()) || StrUtil.isBlank(user.getPassword())) {
            throw new CustomException(ResultCode.PARAM_LOST_ERROR);
        }
        Integer level = user.getLevel();
        User login = userInfoService.login(user.getName(), user.getPassword());

        //request.getSession().setAttribute("user", login);
        redistp.opsForValue().set("l"+login.getPhone(),login.getNewPassword(),30, TimeUnit.DAYS);//保存登陆状态1个月

        return Result.successAddUserNameAndPhone(login.getNewPassword(),login.getName(),login.getPhone());
    }

    /**
     * 手机验证码登陆
     * 地址：http://网址/api/loginsms
     * 方法 post
     * 参数json格式 如 {"phone":"15927614999","code":"1111","type":"login","name":"","password":"","level":null}，其中phone为手机号,code为验证码，其他按例子填写
     * 成功返回 code=0 为成功，其他为失败 {"code":"0","msg":"成功","data":{"password":"111111","newPassword":null,"userinfo":null,"sex":"男","age":null,"region":null,"phone":"15927614001","address":null,"userdate":"2022-12-18 23:53:06","identity":null,"level":1,"code":"13156","name":"user01","id":1}}
     * 失败返回 如 {"code":"401","msg":"验证码错误","data":null}
     */
    @ApiResponses({
            @ApiResponse(code = 0,message = "成功"),
            @ApiResponse(code = 401,message = "参数错误/验证码过期或者未输入")
    })
    @PostMapping("/loginsms")
    @ApiOperation(value = "通过手机验证码登录，成功返回token信息",notes = "需要的参数：phone，code（这边的code是通过发送（login的类型）验证码收取到了code）")
    public Result<String> loginsms(@RequestBody User user) {

        String phone = user.getPhone();

        if (phone.equals("")) {
            return Result.error("401", "参数错误");
        }
        /*
        Sms smsInfo = smsService.findByPhone(phone,"login");
        if (smsInfo == null) {
            return Result.error("401", "验证码错误");
        }
        if(smsInfo.getPhone().equals( phone)) {
            Calendar myTime = Calendar.getInstance();
            myTime.add(Calendar.SECOND,-60);
            Date beforeM = myTime.getTime();
            String beforeM1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(beforeM);
            if(beforeM1.compareTo(smsInfo.getTime())>0) {
                return Result.error("401", "验证码过期，请重新获取");
            }
        }
        */
        if(user.getCode().equals("")){
            return Result.error("401", "请输入验证码");
        }
        if(!user.getCode().equals(redistp.opsForValue().get("login"))){
            return Result.error("401", "验证码过期，请重新获取");
        }


        User login = userInfoService.findByPhone(user.getPhone());


        //request.getSession().setAttribute("user", login);
        redistp.opsForValue().set("l"+login.getPhone(),login.getNewPassword(),30, TimeUnit.DAYS);//保存登陆状态1个月
        return Result.successAddUserNameAndPhone(login.getNewPassword(),login.getName(),login.getPhone());
    }

    /**
     * 用户注册
     * 地址：http://网址/api/signup
     * 方法 post
     * 参数json格式 如 {"phone":"15927614001","code":"1111","type":"reg","name":"15927614001","password":"15927614001","newPassword":"15927614001","sex":"男","level":1}，其中phone为手机号,code为验证码，"name":用户名,"password":密码,"newPassword":密码,"sex":性别(男，女),其他按例子填写
     * 成功返回 code=0 为成功，其他为失败 {"code":"0","msg":"成功","data":{"password":"111111","newPassword":null,"userinfo":null,"sex":"男","age":null,"region":null,"phone":"15927614001","address":null,"userdate":"2022-12-18 23:53:06","identity":null,"level":1,"code":"13156","name":"user01","id":1}}
     * 失败返回 如 {"code":"401","msg":"验证码过期，请重新获取","data":null}
     */
    @ApiResponses({
            @ApiResponse(code = 0,message = "成功"),
            @ApiResponse(code = 401,message = "参数错误/验证码过期或者未输入"),
            @ApiResponse(code = 1001,message = "手机号已存在/用户名已存在")
    })
    @ApiOperation(value = "用户注册模块，输入用户信息进行注册",notes = "需要的参数：phone，code（这边的code是通过发送（register类型）验证码收取到了code）,name，password")
    @PostMapping("/signup")
    public Result<User> register(@RequestBody User user) {
        Integer level = user.getLevel();

        String phone = user.getPhone();

        if (phone.equals("")) {
            return Result.error("401", "参数错误");
        }
        /*
        Sms smsInfo = smsService.findByPhone(phone,"reg");
        if (smsInfo == null) {
            return Result.error("401", "验证码错误");
        }
        if(smsInfo.getPhone().equals(phone)) {
            Calendar myTime = Calendar.getInstance();
            myTime.add(Calendar.SECOND,-60);
            Date beforeM = myTime.getTime();
            String beforeM1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(beforeM);
            if(beforeM1.compareTo(smsInfo.getTime())>0) {
                return Result.error("401", "验证码过期，请重新获取");
            }
        }
         */
        if(user.getCode().equals("")){
            return Result.error("401", "请输入验证码");
        }
        if(!user.getCode().equals(redistp.opsForValue().get("register"))){
            return Result.error("401", "验证码过期，请重新获取");
        }

        User login = new User();

        User info = new User();
        BeanUtils.copyProperties(user, info);
        login = userInfoService.add(info);

        return Result.success(login);
    }

    /**
     * 用户退出
     * 地址：http://网址/api/logout
     * 方法 post
     * 参数 登陆时返回的信息{"code":"0","msg":"成功","data":{"password":"111111","newPassword":null,"userinfo":null,"sex":"男","age":null,"region":null,"phone":"15927614001","address":null,"userdate":"2022-12-18 23:53:06","identity":null,"level":1,"code":"13156","name":"user01","id":1}}
     * 成功返回 code=0 为成功，其他为失败 {"code":"0","msg":"成功","data":null}
     * 失败返回 无
     */
    @ApiResponse(code = 0,message = "成功")
    @ApiOperation(value = "用户退出（删除redis里的token）得把token放在请求头！",notes = "需要的参数：newPassword  即为token（登录以后返回的token）token得放请求头")
    @PostMapping("/logout")
    public Result<String> logout(HttpServletRequest request) {
        //request.getSession().setAttribute("user", null);
        //redistp.opsForValue().set("l"+login.getPhone(),"");
        String token=request.getHeader("token");

        Boolean delete = redistp.delete(token);

        return Result.success("退出成功");
    }

    /**
     * 判断用户是否登陆
     * 地址：http://网址/api/auth
     * 方法 post
     * 参数 登陆时返回的信息{"code":"0","msg":"成功","data":{"password":"111111","newPassword":null,"userinfo":null,"sex":"男","age":null,"region":null,"phone":"15927614001","address":null,"userdate":"2022-12-18 23:53:06","identity":null,"level":1,"code":"13156","name":"user01","id":1}}
     * 成功返回 code=0 为成功，其他为失败 用户信息，{"code":"0","msg":"成功","data":{"password":"111111","newPassword":null,"userinfo":null,"sex":"男","age":null,"region":null,"phone":"15927614001","address":null,"userdate":"2022-12-18 23:53:06","identity":null,"level":1,"code":"13156","name":"user01","id":1}}
     * 失败返回 如 {"code":"401","msg":"未登录","data":null}
     */
    @ApiResponses({
            @ApiResponse(code = 0,message = "成功"),
            @ApiResponse(code = 401,message = "由于参数错误/验证码过期或者未输入导致的未登录状态")
    })
    @ApiOperation(value = "判断用户是否登录(并且获取用户信息)",notes = "需要的参数：newPassword，phone")
    @PostMapping("/auth")
    public Result getAuth(@RequestBody User user) {
        //Object user = request.getSession().getAttribute("user");
        if(user == null) {
            return Result.error("401", "未登录");
        }
        if(redistp.opsForValue().get("l"+user.getPhone()).equals("")){
            return Result.error("401", "未登录");
        }
        if(!redistp.opsForValue().get("l"+user.getPhone()).equals(user.getNewPassword())){
            return Result.error("401", "未登录");
        }
        return Result.success(userInfoService.findByPhone(user.getPhone()));
    }

    /**
     * 获取验证码
     * 地址：http://网址/api/send
     * 方法 get
     * 参数无
     * 成功返回 code=0 为成功，其他为失败{"phone":"15927614999","type":"login"} "phone":手机号,"type":类型(login 为登陆时验证码，reg 为注册时验证码)
     * 失败返回 如 {"code":"401","msg":"未登录","data":null}
     */
    @ApiResponses({
            @ApiResponse(code = 0,message = "成功"),
            @ApiResponse(code = 401,message = "参数错误/验证码过期或者未输入")
    })
    @ApiOperation(value = "获取验证码",notes = "需要的参数：phone，type （type只有四种类型才是会发送验证码的：login：登录；  register：注册；  resetPassword：重置密码；  updatePhone：修改注册的手机号码；）")
    @PostMapping("send")
    public Result send(@RequestBody Sms jsonData){

        String phone = jsonData.getPhone();
        String type =   jsonData.getType();

        if (phone.equals("") || type.equals("")) {
            return Result.error("401", "参数错误");
        }
        //验证手机号格式
        boolean correctMobile = ReUtil.isMatch(REG_MOBILE, phone);
        if (correctMobile == false) {
            return Result.error("401", "手机号码格式不正确");
        } else {
        }

        //String uip = this.getIpAddress(request);
        String uip = "";
        //限制验证码发送
        Sms smsInfo = smsService.findByPhone(phone,type);
        if (smsInfo != null) {
            if(smsInfo.getPhone().equals(phone)) {
            Calendar myTime = Calendar.getInstance();
            myTime.add(Calendar.SECOND,-120);
            Date beforeM = myTime.getTime();
            String beforeM1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(beforeM);
            if(beforeM1.compareTo(smsInfo.getTime())<0) {
                return Result.error("401", "已经发送过了，请稍后再试");
            }
          }

        }
        int code = RandomUtil.randomInt(10000, 99999);
        String code1 = String.valueOf(code);
        //request.getSession().setAttribute("smscode",code);

        if (type.equals("resetPassword")){
            redistp.opsForValue().set(type,code1,10, TimeUnit.MINUTES);
        }else {
            redistp.opsForValue().set(type,code1,5, TimeUnit.MINUTES);
        }


        //System.out.println(redistp.opsForValue().get(phone));
        Sms info = new Sms();
        info.setPhone(phone);
        info.setCode(code1);
        info.setType(type);
        info.setIp(uip);
        smsService.add(info);
        if (type.equals("login")){
            smsUtil1.send(phone,code1,2);
            //保存至redis
        }else if (type.equals("register")){
            smsUtil1.send(phone,code1,1);
        }else if (type.equals("resetPassword")){
            smsUtil1.send(phone,code1,3);
        } else if (type.equals("updatePhone")) {
            smsUtil1.send(phone,code1,4);
        }

        return Result.success();
    }

    //获取客户端IP地址
    private String getIpAddress(HttpServletRequest request) {
        System.out.println("request:"+request);
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknow".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length () == 0 || "unknown".equalsIgnoreCase (ip)) {
            ip = request.getHeader ("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length () == 0 || "unknown".equalsIgnoreCase (ip)) {
            ip = request.getRemoteAddr ();
            if (ip.equals ("127.0.0.1")) {
                //根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost ();
                } catch (Exception e) {
                    e.printStackTrace ();
                }
                ip = inet.getHostAddress ();
            }
        }
        // 多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ip != null && ip.length () > 15) {
            if (ip.indexOf (",") > 0) {
                ip = ip.substring (0, ip.indexOf (","));
            }
        }
        return ip;
    }


}
