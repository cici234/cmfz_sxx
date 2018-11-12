package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;
    @RequestMapping("/queryBanner")
    public @ResponseBody List<Banner> banner(){
        List<Banner> banners = bannerService.find();
        return banners;
    }


    @RequestMapping("/findByPage")
    @ResponseBody
    public Map<String,Object> findByPage(Integer page,Integer rows){
        Map<String, Object> results = new HashMap<String, Object>();
        List<Banner> banners = bannerService.findByPage(page, rows);
        Long totals = bannerService.findTotals();
        results.put("total",totals);
        results.put("rows",banners);
        return results;
    }

        @RequestMapping("/save")
        public @ResponseBody Map<String,Object> save(HttpServletRequest request, MultipartFile partfile,Banner banner){
        Map<String,Object> results = new HashMap<String,Object>();


        try {
            String realPath = request.getSession().getServletContext().getRealPath("/bannerimg");
            System.out.println(realPath);
            partfile.transferTo(new File(realPath,partfile.getOriginalFilename()));
            System.out.println(partfile.getOriginalFilename());
            banner.setImgPath("/bannerimg/"+partfile.getOriginalFilename());
            bannerService.add(banner);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }



    @RequestMapping("/delete")
    public @ResponseBody Map<String,Object> delete(String id,HttpServletRequest request){
        Map<String,Object> results = new HashMap<String,Object>();

        try {
            String realPath = request.getSession().getServletContext().getRealPath("/bannerimg");
            File file = new File(realPath);
            file.delete();
            bannerService.remove(id);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }



    @RequestMapping("/update")
    public @ResponseBody Map<String,Object> update(Banner banner,HttpServletRequest request, MultipartFile partfile){
        Map<String, Object> results = new HashMap<String,Object>();
        System.out.println(partfile);
        try {
            String realPath = request.getSession().getServletContext().getRealPath("/bannerimg");
            System.out.println(realPath);
            banner.setImgPath("/bannerimg/"+partfile.getOriginalFilename());
            System.out.println(partfile.getOriginalFilename());
            partfile.transferTo(new File(realPath,partfile.getOriginalFilename()));
            System.out.println(banner);
            bannerService.motify(banner);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }



    @RequestMapping("/queryOne")
    public @ResponseBody Banner queryOne(String id){



            Banner banner = bannerService.findOne(id);

            return banner;
    }


    @RequestMapping("/deleteMany")
    public @ResponseBody Map<String,Object> deleteMany(String[] id){
        Map<String, Object> results = new HashMap<>();

        try {
            bannerService.deleteMany(id);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }
}
