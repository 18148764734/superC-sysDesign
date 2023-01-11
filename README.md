http://localhost:8080/main/index.html
/static 目录下为测试页面

sms1,2,3,4对应的是注册  登录  重置密码  修改注册手机号码的模板
SmsConfig1，2,3,4 对应的是注册  登录  重置密码  修改注册手机号码的配置文件


## swagger文档连接
http://localhost:8080/swagger-ui.html#/

## 获取验证码
url：http://localhost:8080/api/send
参数（json）：{"phone":"15119380977","type":"login"}  type只有四种类型才是会发送验证码的：login：登录；  register：注册；  resetPassword：重置密码；  updatePhone：修改注册的手机号码；
每次调用对应接口的所使用到的code都是需要使用对应的类型短信验证码
返回：
{
"code": "0",
"msg": "成功",
"data": null
}

## 重置密码
url：http://localhost:8080/api/resetpassword
参数（json）：{"phone":"18219413000","name":"lamb","code":"72331","password":"1234568"}  这边的code是通过发送（resetPassword类型）验证码收取到了code
返回的是用户的信息

## 修改注册的手机号码
url：http://localhost:8080/api/updatephone
参数（json）：{"phone":"18219413000","name":"lamb","code":"81531","password":"1234567"}  这边的code是通过发送（updatePhone类型）验证码收取到了code
返回的是用户的信息

##  用户名，密码登录
url:http://localhost:8080/api/login
参数：{"name":"Lamb","password":"20020129"}
返回值：
{
"code": "0",
"msg": "成功",
"data": {
"password": "",
"newPassword": "20afcd9d373cd481710eba1daecc40d64607",
"userinfo": null,
"sex": "男",
"age": null,
"region": null,
"phone": "15119380977",
"address": null,
"userdate": "2022-12-21 23:26:53",
"identity": null,
"level": 1,
"code": "31514",
"name": "Lamb",
"id": "f9e51a9d3"
}
}


## 用户退出
url：http://localhost:8080/api/logout
参数：{"newPassword": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJwYXNzd29yZCI6IjEyMzQ1NiIsImV4cCI6MTY3MzU5NDA0MywidXNlcm5hbWUiOiIxMjM0In0.vxLsRSsCpiAoUzXtlGzo2peqKgQLCKBWpAx0H2lbWZs","phone": "15119380977"}  newPassword即为token（登录以后返回的token）token得放请求头
{
"code": "0",
"msg": "成功",
"data": null
}
返回：
{
"code": "0",
"msg": "成功",
"data": null
}

##  用户注册
url：http://localhost:8080/api/signup
参数{"phone":"15119380977","code":"1111","type":"register","name":"1234","password":"123456","sex":"男","level":1}


## 手机验证码登录
url：http://localhost:8080/api/loginsms
参数：{"phone":"15119380977","code":"1111"}


## 判断是否登录
url：http://localhost:8080/api/auth
参数：{"newPassword": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJwYXNzd29yZCI6IjEyMzQ1NiIsImV4cCI6MTY3MzU5NDA0MywidXNlcm5hbWUiOiIxMjM0In0.vxLsRSsCpiAoUzXtlGzo2peqKgQLCKBWpAx0H2lbWZs","phone": "15119380977"}

返回：
{
"code": "0",
"msg": "成功",
"data": {
"password": null,
"newPassword": "20afcd9d373cd481710eba1daecc40d62107",
"userinfo": null,
"sex": null,
"age": null,
"region": null,
"phone": "15119380977",
"address": null,
"userdate": null,
"identity": null,
"level": null,
"code": null,
"name": null,
"id": null
}
}
