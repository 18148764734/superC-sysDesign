

## 获取八字
方式：get
url:http://localhost:8080/schedule/getbazi
参数示例：
{
"nian":"2002",
"yue":"1",
"ri":"12",
"shi":"12"
}

返回值：
{
"code": "0",
"msg": "成功",
"data": {
"nianZhu": "壬午",
"yueZhu": "壬寅",
"riZhu": "壬戌",
"shiZhu": "丙午"
},
"username": null
}



## 添加
方式：post
url:url:url:http://localhost:8080/schedule/addschedule
参数：
{
"phone":"15119380977",
"scheduleTime":"2023-02-26",
"message":"123454646"
}

返回值：
{
"code": "0",
"msg": "成功",
"data": null,
"username": null
}



## 删除日程
方式：get
url:url:http://localhost:8080/schedule/delschedule
参数：
{
"scheduleTime":"2023-02-27",
"scheduleId":"8"
}
成功返回值：
{
"code": "0",
"msg": "成功",
"data": null,
"username": null
}
失败返回值：
{
"code": "2009",
"msg": "此日期未设置日程",
"data": null,
"username": null
}

## 更新日程
方式：post
url:http://localhost:8080/schedule/updschedule
参数：
{
"scheduleTime":"2023-02-27",
"scheduleId":"8",
"message":"000011111"
}
成功返回值：
{
"code": "0",
"msg": "成功",
"data": null,
"username": null
}

失败返回值：
{
"code": "2009",
"msg": "此日期未设置日程",
"data": null,
"username": null
}



## 查询当日某个日程
方式：get
url:url:http://localhost:8080/schedule/queryoneschedule
参数示例：
{
"scheduleTime":"2023-02-27",
"scheduleId":"9"
}

成功返回值：
{
"code": "0",
"msg": "成功",
"data": {
"scheduleId": 9,
"phone": "15119380977",
"scheduleTime": "2023-02-27",
"endTime": "2023-03-02 17:26:21",
"message": "1234666"
},
"username": null
}


失败返回值：
{
"code": "2009",
"msg": "此日期未设置日程",
"data": null,
"username": null
}



## 查询当日全部日程
方式：get
url:url:http://localhost:8080/schedule/queryallschedule
参数示例：
{
"scheduleTime":"2023-02-27",
"phone":"15119380977"
}

成功返回值：

{
"code": "0",
"msg": "成功",
"data": [
{
"scheduleId": 9,
"phone": "15119380977",
"scheduleTime": "2023-02-27",
"endTime": "2023-03-02 17:26:21",
"message": "1234666"
}
],
"username": null
}

失败返回值：
{
"code": "2009",
"msg": "此日期未设置日程",
"data": null,
"username": null
}


## 删除该用户的某日的所有日程
方式：get
url:url:http://localhost:8080/schedule/delallschedule
参数：
{
"scheduleTime":"2023-02-27",
"phone":"15119380977"
}
成功返回值：
{
"code": "0",
"msg": "成功",
"data": null,
"username": null
}
失败返回值：
{
"code": "2009",
"msg": "此日期未设置日程",
"data": null,
"username": null
}


## 通过年月获取某个月的所有已设置的日程
方式：get
url:url:http://localhost:8080/schedule/getschedulebynianyue
参数示例：
{
"scheduleTime":"2023-02-08",
"phone":"15119380977"
}


成功返回值：
{
"code": "0",
"msg": "成功",
"data": [
{
"scheduleId": 6,
"phone": "15119380977",
"scheduleTime": "2023-02-28",
"endTime": "2023-03-01 15:30:00",
"message": "123454646"
},
{
"scheduleId": 7,
"phone": "15119380977",
"scheduleTime": "2023-02-26",
"endTime": "2023-03-01 15:30:20",
"message": "123454646"
},
{
"scheduleId": 9,
"phone": "15119380977",
"scheduleTime": "2023-02-27",
"endTime": "2023-03-02 17:26:21",
"message": "1234666"
},
{
"scheduleId": 10,
"phone": "15119380977",
"scheduleTime": "2023-02-28",
"endTime": "2023-03-08 21:19:41",
"message": "123454646"
}
],
"username": null
}


失败返回值：
{
"code": "2008",
"msg": "此月未设置日程",
"data": null,
"username": null
}