package com.baizhi.test;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
public class UserTest extends BaseTest {

    @Autowired
    private UserService userService;
    @Test
    public void adduser(){
        User user = new User();
        user.setId("1");
        user.setPhoneNum("1234");
        user.setUsername("rr");
        user.setPassword("123");
        user.setProvince("陕西");
        user.setCity("西安");
        user.setNikName("aa");
        user.setSex("男");
        user.setSign("lalal");
        user.setHeadPic("mm");
        user.setStatus("y");
        user.setRegdate("2012-12-12");
        userService.register(user);
    }

    @Test
    public void login(){
        User user = new User();
        user.setUsername("rr");
        user.setPassword("123");
        User login = userService.login(user);
        System.out.println(login);

    }

    @Test
    public void update(){
        User user = new User();
        user.setId("1");
        user.setPhoneNum("9999999");
        user.setUsername("rr");
        user.setPassword("123");
        user.setProvince("陕西");
        user.setCity("西安");
        user.setNikName("aa");
        user.setSex("男");
        user.setSign("lalal");
        user.setHeadPic("mm");
        user.setStatus("y");
        user.setRegdate("2012-12-12");
        userService.motify(user);
    }
}
