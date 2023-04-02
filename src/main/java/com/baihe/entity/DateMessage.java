package com.baihe.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("通过年月获取的信息集合类")
public class DateMessage {

    @ApiModelProperty(value = "天（阳历）",dataType = "int")
    private int day;
    @ApiModelProperty(value = "年（阳历）",dataType = "int")
    private int year;
    @ApiModelProperty(value = "月（阳历）",dataType = "int")
    private int month;

    @ApiModelProperty(value = "是否为周末",dataType = "boolean")
    private boolean isWeekend;

    @ApiModelProperty(value = "当日的节气（如果没有返回null）",dataType = "string")
    private String jieQi;
    @ApiModelProperty(value = "当日的假日（如果没有返回null）",dataType = "boolean")
    private String holiday;

    @ApiModelProperty(value = "阴历日",dataType = "string")
    private String  yinLi;

    @ApiModelProperty(value = "当日是星期几",dataType = "string")
    private String  xingQiDate;

    @ApiModelProperty(value = "当日是否纪录日程（如果没有返回null）",dataType = "boolean")
    private boolean isDaily;

    @ApiModelProperty(value = "当日的适合做的事情",dataType = "数组")
    private List<String> suitable;

    @ApiModelProperty(value = "当日的不适合做的事情",dataType = "数组")
    private List<String> fear;

    @ApiModelProperty(value = "阴历年月日",dataType = "数组")
    private String yinLiNianYueRi;
    public DateMessage(){

    }

    public String getYinLiNianYueRi() {
        return yinLiNianYueRi;
    }

    public void setYinLiNianYueRi(String yinLiNianYueRi) {
        this.yinLiNianYueRi = yinLiNianYueRi;
    }

    public List<String> getSuitable() {
        return suitable;
    }

    public void setSuitable(List<String> suitable) {
        this.suitable = suitable;
    }

    public List<String> getFear() {
        return fear;
    }

    public void setFear(List<String> fear) {
        this.fear = fear;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean weekend) {
        isWeekend = weekend;
    }

    public String getJieQi() {
        return jieQi;
    }

    public void setJieQi(String jieQi) {
        this.jieQi = jieQi;
    }

    public String getHoliday() {
        return holiday;
    }

    public void setHoliday(String holiday) {
        this.holiday = holiday;
    }

    public String getYinLi() {
        return yinLi;
    }

    public void setYinLi(String yinLi) {
        this.yinLi = yinLi;
    }

    public String getXingQiDate() {
        return xingQiDate;
    }

    public void setXingQiDate(String xingQiDate) {
        this.xingQiDate = xingQiDate;
    }

    public boolean isDaily() {
        return isDaily;
    }

    public void setDaily(boolean daily) {
        isDaily = daily;
    }


}
