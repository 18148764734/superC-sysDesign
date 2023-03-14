package com.baihe.utils;


import com.baihe.utils.liunianmethods.*;
import org.springframework.stereotype.Repository;


public class LiuNianUtil {


    //获取流年序列
    public static String[] getLiuNian(int lunarYear, int lunarMonth, int lunarDay, int hour,int gender,int daYunIndex){
        int minute=0;
        int second=0;
        Lunar lunar = new Lunar(lunarYear, lunarMonth, lunarDay, hour, minute, second);
        EightChar eightChar = lunar.getEightChar();//获取八字
        Yun yun = eightChar.getYun(gender);//获取运  性别：1男，0女
        DaYun daYun = new DaYun(yun, daYunIndex+1);//选择大运（0-9）
        String[]liuNianArr=new String[10];
        for (int i = 0; i < 10; i++) {
            LiuNian liuNian = new LiuNian(daYun, i);
            liuNianArr[i]=(liuNian.getYear()+" "+liuNian.getGanZhi());
        }
        return liuNianArr;
    }


    //获取指定流年  只是获取干支
    public static String getLiuNian(int lunarYear, int lunarMonth, int lunarDay, int hour, int gender,int daYunIndex,int liuNianIndex){
        int minute=0;
        int second=0;
        Lunar lunar = new Lunar(lunarYear, lunarMonth, lunarDay, hour, minute, second);
        EightChar eightChar = lunar.getEightChar();//获取八字
        Yun yun = eightChar.getYun(gender);//获取运  性别：1男，0女
        DaYun daYun = new DaYun(yun, daYunIndex+1);//选择大运（0-9）
        String[]liuNianArr=new String[10];
        for (int i = 0; i < 10; i++) {
            LiuNian liuNian = new LiuNian(daYun, i);
            liuNianArr[i]=(liuNian.getGanZhi());
        }
        return liuNianArr[liuNianIndex];
    }

    //获取指定流年  添加年份前缀
    public static String getLiuNianAddYear(int lunarYear, int lunarMonth, int lunarDay, int hour, int gender,int daYunIndex,int liuNianIndex){
        int minute=0;
        int second=0;
        Lunar lunar = new Lunar(lunarYear, lunarMonth, lunarDay, hour, minute, second);
        EightChar eightChar = lunar.getEightChar();//获取八字
        Yun yun = eightChar.getYun(gender);//获取运  性别：1男，0女
        DaYun daYun = new DaYun(yun, daYunIndex+1);//选择大运（0-9）
        String[]liuNianArr=new String[10];
        for (int i = 0; i < 10; i++) {
            LiuNian liuNian = new LiuNian(daYun, i);
            liuNianArr[i]=(liuNian.getYear()+"年 "+liuNian.getGanZhi());
        }
        return liuNianArr[liuNianIndex];
    }



    //获取指定大运（干支）
    public static String getDaYun(int lunarYear, int lunarMonth, int lunarDay, int hour,int gender,int daYunIndex){
        int minute=0;
        int second=0;
        Lunar lunar = new Lunar(lunarYear, lunarMonth, lunarDay, hour, minute, second);
        EightChar eightChar = lunar.getEightChar();//获取八字
        Yun yun = eightChar.getYun(gender);//获取运  性别：1男，0女
        DaYun daYun = new DaYun(yun, daYunIndex+1);//选择大运（0-9）
        return daYun.getGanZhi();
    }


    //获取大运序列
    public static String[] getDaYunArr(int lunarYear, int lunarMonth, int lunarDay, int hour,int gender){
        int minute=0;
        int second=0;
        Lunar lunar = new Lunar(lunarYear, lunarMonth, lunarDay, hour, minute, second);
        EightChar eightChar = lunar.getEightChar();//获取八字
        Yun yun = eightChar.getYun(gender);//获取运  性别：1男，0女
        String[]daYunArr=new String[10];
        for (int i = 0; i < 10; i++) {
            DaYun daYun = new DaYun(yun, i+1);
            daYunArr[i]=(daYun.getStartAge()+"岁~"+daYun.getEndAge()+"岁  "+"["+daYun.getStartYear()+"年-"+daYun.getEndYear()+"年]  "+daYun.getGanZhi());
        }
        return daYunArr;
    }



    //获取八字
    public static String[] getBaZi(int lunarYear, int lunarMonth, int lunarDay, int hour){
        int minute=0;
        int second=0;
        Lunar lunar = new Lunar(lunarYear, lunarMonth, lunarDay, hour, minute, second);
        EightChar eightChar = lunar.getEightChar();//获取八字
        String[] baZi = new String[4];
        baZi[0]=eightChar.getYear();
        baZi[1]=eightChar.getMonth();
        baZi[2]=eightChar.getDay();
        baZi[3]=eightChar.getTime();
        return baZi;
    }

}
