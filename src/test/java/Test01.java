import com.baihe.dao.UserDao;
import com.baihe.entity.DateMessage;
import com.baihe.entity.Luner;
import com.baihe.entity.Schedule;
import com.baihe.entity.User;
import com.baihe.utils.LiuNianUtil;
import com.baihe.utils.SolarAndLunarUtil;
import com.baihe.utils.SolarUtil;
import com.baihe.utils.liunianmethods.JieQi;
import com.baihe.utils.liunianmethods.Lunar;
import com.baihe.utils.liunianmethods.Solar;
import com.baihe.vo.LunarVo;
import com.baihe.vo.UserVo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test01 {

    @Resource
    private UserDao userDao;

//
//    @Test
//    public void test1(){
//        User user = new User();
//        user.setId("1");
//        user.setName("user01");
//        user.setPassword("123456");
//        user.setPhone("15927614001");
//        UserVo userVo = userDao.findByUsername(user.getName());
//        System.out.println(userVo.toString());
//    }
//
//    @Test
//    public void test(){
//        User user = new User();
//        user.setId("1");
//        user.setName("user01");
//        user.setPassword("123456");
//        user.setPhone("15927614001");
//        Integer integer = userDao.updatePassword(user);
//        System.out.println(integer);
//    }



    @Test
    public void test2(){
        for (String allList : LiuNianUtil.getBaZi(2002, 2, 2, 2)) {
            System.out.println(allList);
        }
        System.out.println();
    }


    @Test
    public void test3(){
        Lunar lunar = new Lunar(new Date());
        int month = lunar.getMonth();
        if (lunar.getJieQi().equals("")){
            System.out.println("null");
        }else {
            System.out.println(lunar.getJieQi());
        }

        System.out.println(month);//闰月为负数
        int day = lunar.getDay();
        System.out.println(day);
        Solar solar = new Solar(new Date());
        int month1 = solar.getMonth();
        System.out.println(month1);
        int day1 = solar.getDay();
        System.out.println(solar.getWeek());
        System.out.println(day1);
        System.out.println(solar.getYear());



    }
    @Test
    public void test4(){
        Schedule schedule = new Schedule();
        schedule.setScheduleTime("2023-02-27");
        LunarVo allDate = SolarAndLunarUtil.getAllDate(schedule);
        allDate.getAllDate().forEach(System.out::println);
    }


    @Test
    public void test5(){
        String aa="2023-02-27";
        System.out.println(aa.substring(0, 4));
        System.out.println(aa.substring(5, 7));
        System.out.println(aa.substring(0, 8));
        System.out.println(aa.substring(8, 10));
    }


    @Test
    public void test06(){
        Map<String, String> stringStringMap = new HashMap<>();
        stringStringMap.put("1","1");
        if (null==stringStringMap.get("0")){
            System.out.println(stringStringMap.get("0"));
        }
        if ("null".equals(stringStringMap.get("0"))){
            System.out.println(stringStringMap.get("0"));
        }

        System.out.println(stringStringMap.get("1"));
    }


    @Test
    public void test07(){
        Solar solar = new Solar(new Date());
        ArrayList<String> strings = new ArrayList<>();
        int nian = solar.getYear();
        int yue = solar.getMonth();
        int days = SolarUtil.getDaysOfMonth(nian, yue);
        for (int i = 1; i <= days; i++) {
            Solar solar1 = new Solar(nian, yue, i);
            Lunar lunar = solar1.getLunar();
            JieQi currentJieQi = lunar.getCurrentJieQi();
            String s="";
            if (null==currentJieQi){
                s=null;
            }else {
                s=currentJieQi.toString();
            }
            strings.add(s);
        }
        Solar solar1 = new Solar(2023,3,1);
        Lunar lunar = solar1.getLunar();

        System.out.println(lunar.getPrevJieQi()+lunar.getPrevJie().getSolar().toYmd());
        System.out.println(lunar.getNextJieQi()+lunar.getNextJieQi().getSolar().toYmd());
        System.out.println("=============");
        strings.forEach(System.out::println);
    }

    @Test
    public void test08(){
        Solar solar = new Solar(new Date());
        int nian = solar.getYear();
        int yue = solar.getMonth();
        int days = SolarUtil.getDaysOfMonth(nian, yue);
        ArrayList<DateMessage> list = new ArrayList<>();
//        for (int i = 1; i <= days; i++) {
            DateMessage dateMessage = new DateMessage();
            Solar solar1 = new Solar(nian, yue, 27);
            Lunar lunar = solar.getLunar();
            String festival = lunar.getFestival();
            String festival1 = solar1.getFestival();
            String festivalByWeek = solar1.getFestivalByWeek();
//            if(null!=festival&&null==festivalByWeek&&null==festival1){
//                dateMessage.setHoliday(festival);
//            }
//            if(null!=festival1&&null==festival&&null==festivalByWeek){
//                dateMessage.setHoliday(festival1);
//            }
//            if(null!=festivalByWeek&&null==festival&&null==festival1){
//                dateMessage.setHoliday(festivalByWeek);
//            }
//            if(null!=festival&&null!=festival1&&null==festivalByWeek){
//                dateMessage.setHoliday(festival);
//            }
//            if(null!=festivalByWeek&&null!=festival&&null==festival1){
//                dateMessage.setHoliday(festival);
//            }
//            if(null!=festivalByWeek&&null!=festival1&&null==festival){
//                dateMessage.setHoliday(festival1+festivalByWeek);
//            }
//            if(null!=festival&&null!=festival1&&null!=festivalByWeek){
//                dateMessage.setHoliday(festival+festival1+festivalByWeek);
//            }
            if (null!=festival1){
                dateMessage.setHoliday(festival1);
            }
            if (null!=festivalByWeek){
                dateMessage.setHoliday(festivalByWeek);
            }
            if (null!=festival){
                dateMessage.setHoliday(festival);
            }
            if (null!=dateMessage.getHoliday()&&dateMessage.getHoliday().equals("nullnull")){
                dateMessage.setHoliday(null);
            }
            if (null!=dateMessage.getHoliday()&&dateMessage.getHoliday().equals("nullnullnull")){
                dateMessage.setHoliday(null);
            }
            list.add(dateMessage);

        String holiday = dateMessage.getHoliday();
        System.out.println(holiday);
//    }
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).getHoliday());
//        }
    }
}
