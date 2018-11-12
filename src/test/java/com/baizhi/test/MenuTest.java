package com.baizhi.test;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Banner;
import com.baizhi.entity.Menu;
import com.baizhi.service.AdminService;
import com.baizhi.service.BannerService;
import com.baizhi.service.MenuService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MenuTest extends BaseTest {
    @Autowired
    private MenuService menuService;
    @Autowired
    private AdminService adminService;

    @Test
    public void testFindMenu() {
        List<Menu> menus = menuService.findMenu();
        System.out.println(menus);
    }

    @org.junit.Test
    public void login() {
        Admin admin = new Admin();
        admin.setName("cici");
        admin.setPassword("3333");
        Admin login = adminService.login(admin);
        System.out.println(login);
    }


    @Test
    public void update() {
        Admin admin1 = new Admin();
        admin1.setId("1");
        admin1.setName("cici");
        admin1.setPassword("3333");
        adminService.update(admin1);
        System.out.println(admin1);

    }



}

