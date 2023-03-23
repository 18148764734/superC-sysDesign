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
            Solar solar = new Solar(nian, yue, i);
            Lunar lunar = solar.getLunar();
            String nianYueRi=nianYue+i;
            String jieQi = lunar.getJieQi();
            String festival = lunar.getFestival();
            String festival1 = solar.getFestival();
            String festivalByWeek = solar.getFestivalByWeek();
            if(null!=festival&&null==festivalByWeek&&null==festival1){
                dateMessage.setHoliday(festival);
            }
            if(null!=festival1&&null==festival&&null==festivalByWeek){
                dateMessage.setHoliday(festival1);
            }
            if(null!=festivalByWeek&&null==festival&&null==festival1){
                dateMessage.setHoliday(festivalByWeek);
            }
            if(null!=festival&&null!=festival1&&null==festivalByWeek){
                dateMessage.setHoliday(festival+festival1);
            }
            if(null!=festivalByWeek&&null!=festival&&null==festival1){
                dateMessage.setHoliday(festival+festivalByWeek);
            }
            if(null!=festivalByWeek&&null!=festival1&&null==festival){
                dateMessage.setHoliday(festival1+festivalByWeek);
            }
            if(null!=festival&&null!=festival1&&null!=festivalByWeek){
                dateMessage.setHoliday(festival+festival1+festivalByWeek);
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
                dateMessage.setJieQi(null);
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

}
