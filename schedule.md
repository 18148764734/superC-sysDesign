

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


## 通过年月日获取八字拼接年，月，日
方式：get
url:url:http://localhost:8080/schedule/getbazinianyueri
示例测试url：http://localhost:8080/schedule/getbazinianyueri?nian=2000&yue=12&ri=12&shi=12
参数示例：
{
"nian":"2002",
"yue":"1",
"ri":"12",
"shi":"12"
}
返回值:
{
"code": "0",
"msg": "成功",
"data": {
"nianZhu": null,
"yueZhu": null,
"riZhu": null,
"shiZhu": null,
"baZiNian": "庚辰年",
"baZiYue": "己丑月",
"baZiRi": "己巳日"
},
"username": null
}

## 通过年月获取信息
方式：get
url:url:http://localhost:8080/schedule/getschedulebynianyue1
参数示例：
{
"scheduleTime":"2023-02-08",
"phone":"15119380977"
}
//get 请求是放请求头的  示例测试url：http://localhost:8080/schedule/getschedulebynianyue1?scheduleTime=2023-02-01&phone=15119380977
返回值：
{
"code": "0",
"msg": "成功",
"data": {
"allDate": [
{
"day": 27,
"year": 2023,
"month": 2,
"jieQi": "null",
"holiday": null,
"yinLi": "初八",
"xingQiDate": "星期一",
"suitable": [
"嫁娶",
"冠笄",
"纳采",
"出行",
"会亲友",
"上梁",
"安机械",
"安床",
"牧养",
"畋猎",
"祭祀",
"祈福",
"开光",
"修造",
"安门",
"盖屋",
"起基"
],
"fear": [
"入宅",
"作灶",
"治病",
"安葬",
"移徙"
],
"weekend": false,
"daily": true
},
{
"day": 28,
"year": 2023,
"month": 2,
"jieQi": "null",
"holiday": null,
"yinLi": "初九",
"xingQiDate": "星期二",
"suitable": [
"修饰垣墙",
"平治道涂",
"祭祀",
"馀事勿取"
],
"fear": [
"诸事不宜"
],
"weekend": false,
"daily": true
}
]
},
"username": null
}



## 通过年月获取生肖和当日节气
方式：get
url：http://localhost:8080/schedule/getanimalandjieqibynianyue
url示例：http://localhost:8080/schedule/getanimalandjieqibynianyue?scheduleTime=2023-04-01
需要参数：
{"scheduleTime":"2023-04-01"}
animal:本年的生肖
day：当月的具体日
返回值：
{
"code": "0",
"msg": "成功",
"data": {
"allJieQiAndCurrentAnimal": [
{
"animal": "兔",
"jieQi": "春分",
"day": 1
},
{
"animal": "兔",
"jieQi": "春分",
"day": 2
},
{
"animal": "兔",
"jieQi": "春分",
"day": 3
},
{
"animal": "兔",
"jieQi": "春分",
"day": 4
},
{
"animal": "兔",
"jieQi": "清明",
"day": 5
},
{
"animal": "兔",
"jieQi": "清明",
"day": 6
}]
},
"username": null
}