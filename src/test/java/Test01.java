import com.baihe.dao.UserDao;
import com.baihe.entity.User;
import com.baihe.utils.LiuNianUtil;
import com.baihe.vo.UserVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

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
}
