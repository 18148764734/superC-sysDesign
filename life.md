## 获取流年
请求方式：get
url:http://localhost:8080/life/getliunian
参数示例：
{
"nian":"2002",
"yue":"1",
"ri":"12",
"shi":"12",
"gender":"0",
"daYunIndex":"0"
}
返回值：
{
"code": "0",
"msg": "成功",
"data": {
"one": "2008 戊子",
"two": "2009 己丑",
"three": "2010 庚寅",
"four": "2011 辛卯",
"five": "2012 壬辰",
"six": "2013 癸巳",
"seven": "2014 甲午",
"eight": "2015 乙未",
"nine": "2016 丙申",
"ten": "2017 丁酉"
},
"username": null
}



## 获取八字
请求方式：get
url:http://localhost:8080/life/getbazi
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

## 获取大运
请求方式：get
url:http://localhost:8080/life/getdayun
参数示例：
{
"nian":"2002",
"yue":"1",
"ri":"12",
"shi":"12",
"gender":"0"
}


返回值：
{
"code": "0",
"msg": "成功",
"data": {
"one": "7岁~16岁  [2008年-2017年]  辛丑",
"two": "17岁~26岁  [2018年-2027年]  庚子",
"three": "27岁~36岁  [2028年-2037年]  己亥",
"four": "37岁~46岁  [2038年-2047年]  戊戌",
"five": "47岁~56岁  [2048年-2057年]  丁酉",
"six": "57岁~66岁  [2058年-2067年]  丙申",
"seven": "67岁~76岁  [2068年-2077年]  乙未",
"eight": "77岁~86岁  [2078年-2087年]  甲午",
"nine": "87岁~96岁  [2088年-2097年]  癸巳",
"ten": "97岁~106岁  [2098年-2107年]  壬辰"
},
"username": null
}