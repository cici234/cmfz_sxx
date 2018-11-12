package com.baizhi.controller;

import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
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
@RequestMapping("/guru")
public class GuruController {
    @Autowired
    private GuruService guruService;

    @RequestMapping("/query")
    @ResponseBody
    public List<Guru> query(){
        List<Guru> gurus = guruService.find();
        return gurus;
    }

    @RequestMapping("/queryByPage")
    @ResponseBody
    public Map<String,Object> queryByPage(Integer page,Integer rows){
        Map<String, Object> results = new HashMap<String, Object>();
        List<Guru> gurus = guruService.findByPage(page, rows);
        Long totals = guruService.findTotals();
        results.put("total",totals);
        results.put("rows",gurus);
        return results;
    }



    @RequestMapping("save")
    @ResponseBody
    public Map<String,Object> save(HttpServletRequest request, Guru guru, MultipartFile mult){
         Map<String, Object> results = new HashMap<String,Object>();

        try {
            String realPath = request.getRealPath("/guruimg");
            System.out.println(realPath);
            mult.transferTo(new File(realPath,mult.getOriginalFilename()));
            System.out.println(mult.getOriginalFilename());
            guru.setHeasPic("/guruimg/"+mult.getOriginalFilename());
            guruService.add(guru);
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
            String realPath = request.getSession().getServletContext().getRealPath("/guruimg");
            File file = new File(realPath);
            file.delete();
            guruService.remove(id);
            results.put("success",true);

        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }

}
