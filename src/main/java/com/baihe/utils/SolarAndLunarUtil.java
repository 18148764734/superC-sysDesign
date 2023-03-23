package com.baihe.utils;

import com.baihe.dao.ScheduleDao;
import com.baihe.entity.DateMessage;

import com.baihe.entity.Schedule;
import com.baihe.service.ScheduleService;

import com.baihe.utils.liunianmethods.Holiday;
import com.baihe.utils.liunianmethods.HolidayUtil;
import com.baihe.utils.liunianmethods.Lunar;
import com.baihe.utils.liunianmethods.Solar;
import com.baihe.vo.LunarVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class SolarAndLunarUtil {
    @Autowired
    public ScheduleDao scheduleDao;

    private static SolarAndLunarUtil solarAndLunarUtil;
    @PostConstruct
    public void init(){
        solarAndLunarUtil=this;
        solarAndLunarUtil.scheduleDao=this.scheduleDao;

    }

    public  static LunarVo getAllDate(Schedule schedule){

        String scheduleTime = schedule.getScheduleTime();
        int nian = Integer.parseInt(scheduleTime.substring(0,4));
        int yue = Integer.parseInt(scheduleTime.substring(5,7));
        int days = SolarUtil.getDaysOfMonth(nian, yue);
        String nianYue=scheduleTime.substring(0,8);
        LunarVo lunarVo = new LunarVo();
        ArrayList<DateMessage> list = new ArrayList<>();
        for (int i = 1; i <= days; i++) {
            DateMessage dateMessage = new DateMessage();
            Holiday holiday = HolidayUtil.getHoliday(nian, yue, i);
            Solar solar = new Solar(nian, yue, i);
            Lunar lunar = solar.getLunar();
            String nianYueRi=nianYue+i;
            String jieQi = lunar.getJieQi();
            if (holiday==null){
                dateMessage.setHoliday(null);
            }else {
                dateMessage.setHoliday(holiday.getName());
            }
            List<String> ji = lunar.getDayJi();
            List<String> yi = lunar.getDayYi();
            String week = solar.getWeekInChinese();
            dateMessage.setDay(i);
            dateMessage.setYear(nian);
            dateMessage.setMonth(yue);
            dateMessage.setFear(ji);
            dateMessage.setSuitable(yi);
            if (week.equals("日")||week.equals("六")){
                dateMessage.setWeekend(true);
            }else {
                dateMessage.setWeekend(false);
            }
            String yearInChinese = lunar.getYearInChinese();
            String monthInChinese = lunar.getMonthInChinese();
            String dayInChinese = lunar.getDayInChinese();
            dateMessage.setYinLi(dayInChinese);

            String lunarNianYueRi=yearInChinese+"年"+monthInChinese+"月"+dayInChinese+"日";
            dateMessage.setYinLiNianYueRi(lunarNianYueRi);
            if (jieQi.equals("")){
                dateMessage.setJieQi("null");
            }else {
                dateMessage.setJieQi(jieQi);
            }
            dateMessage.setXingQiDate("星期"+week);
            List<Schedule> allByScheduleTime = solarAndLunarUtil.scheduleDao.findAllByScheduleTime(nianYueRi, schedule.getPhone());
            if (allByScheduleTime.size()==0){
                dateMessage.setDaily(false);
            }else {
                dateMessage.setDaily(true);
            }
            list.add(dateMessage);
        }
        lunarVo.setAllDate(list);
        return lunarVo;
    }


    private String judgeHoliday(int solarYue,int solarRi,int lunarYue,int lunarRi ){
        String result="";
        String solarYueRi=String.valueOf(solarYue)+String.valueOf(solarRi);
        String lunarYueRi=String.valueOf(lunarYue)+String.valueOf(lunarRi);
        switch (solarYueRi){
            case "0101":result="元旦节";
                break;
            case "0405":result="清明节";
                break;
            case "1001":result="国庆节";
                break;
            default: {
                result="null";
            }

        }
        return result;
    }
}
