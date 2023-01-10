http://localhost:8080/main/index.html
/static 目录下为测试页面

## 获取验证码
url：http://localhost:8080/api/send
参数（json）：{"phone":"15119380977","type":"login"}
返回：
{
"code": "0",
"msg": "成功",
"data": null
}

## 重置密码
url：http://localhost:8080/api/resetPassword
参数（json）：{"phone":"18219413000","name":"lamb","code":"72331","password":"1234568"}
返回的是用户的信息

## 修改注册的手机号码
url：http://localhost:8080/api/updatePhone
参数（json）：{"phone":"18219413000","name":"lamb","code":"81531","password":"1234567"}
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
参数：{"newPassword": "20afcd9d373cd481710eba1daecc40d62107","phone": "15119380977"}
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
参数{"phone":"15119380977","code":"1111","type":"reg","name":"1234","password":"123456","newPassword":"123456","sex":"男","level":1}


## 手机验证码登录
url：http://localhost:8080/api/loginsms
参数：{"phone":"15119380977","code":"1111","type":"login","name":"","password":"","level":null}


## 判断是否登录
url：http://localhost:8080/api/auth
参数：{"newPassword": "20afcd9d373cd481710eba1daecc40d62107","phone": "15119380977"}

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
