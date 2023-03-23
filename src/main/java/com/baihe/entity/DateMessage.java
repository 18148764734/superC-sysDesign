package com.baihe.entity;

import java.util.List;

public class DateMessage {

    private int day;
    private int year;
    private int month;
    private boolean isWeekend;
    private String jieQi;
    private String holiday;
    private String  yinLi;
    private String  xingQiDate;
    private boolean isDaily;

    private List<String> suitable;

    private List<String> fear;

    public DateMessage(){

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
