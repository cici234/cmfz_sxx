package com.baizhi.test;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class BannerTest extends BaseTest {
    @Autowired
    private BannerService bannerService;

    @Test
    public void testBannerQuery(){
        List<Banner> banners = bannerService.find();
        System.out.println(banners);
    }

    @Test
    public void testBannerSave(){
        Banner banner = new Banner();
        banner.setTitle("ee");
        banner.setStatus("ee");
        banner.setImgPath("ee");
        banner.setDescr("ee");
        banner.setCreattime(new Date());
        bannerService.add(banner);

    }


    @Test
    public void testupdate(){
        Banner banner = new Banner();
        banner.setId("faac28a2-f190-4d34-b42e-d6d1231ffa93");
        banner.setTitle("oo");
        banner.setStatus("n");
        banner.setImgPath("/bannerimg/3.jpg");
        banner.setDescr("gggg");
        banner.setCreattime(new Date());
        bannerService.motify(banner);
    }


    @Test
    public void testdelete(){

        bannerService.remove("6d4570f7-b8d0-4777-bdcc-80b3cc35fd8f");
    }

    @Test
    public void testqueryone(){
        Banner banner = bannerService.findOne("3289231c-11fb-4c5e-89bb-e7d97067fe89");
        System.out.println(banner);
    }
}
