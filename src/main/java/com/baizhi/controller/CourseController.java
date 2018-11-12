package com.baizhi.controller;

import com.baizhi.entity.Course;
import com.baizhi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("/query")
    @ResponseBody
    public List<Course> query(){
        List<Course> courses = courseService.find();
        return courses;
    }

    @RequestMapping("/save")
    @ResponseBody
    public Map<String,Object> save(Course course){
        Map<String, Object> results = new HashMap<String,Object>();

        try {
            courseService.add(course);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }

    @RequestMapping("/delete")
    @ResponseBody
   /* public Map<String,Object> delete(String id){
        Map<String, Object> results = new HashMap<>();
        courseService.remove(id);
        try {
            courseService.remove(id);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }*/



   public String delete(String id){
        courseService.remove(id);
        return "";
    }





    @RequestMapping("/queryByPage")
    @ResponseBody
    public Map<String,Object> queryByPage(Integer page,Integer rows){
        Map<String, Object> results = new HashMap<String, Object>();
        List<Course> courses = courseService.findByPage(page, rows);
        Long totals = courseService.findTotals();
        results.put("total",totals);
        results.put("rows",courses);
        return results;
    }

}
