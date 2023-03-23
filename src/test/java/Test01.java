import com.baihe.dao.UserDao;
import com.baihe.entity.Luner;
import com.baihe.entity.Schedule;
import com.baihe.entity.User;
import com.baihe.utils.LiuNianUtil;
import com.baihe.utils.SolarAndLunarUtil;
import com.baihe.utils.liunianmethods.Lunar;
import com.baihe.utils.liunianmethods.Solar;
import com.baihe.vo.LunarVo;
import com.baihe.vo.UserVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Date;

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
}
