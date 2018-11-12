package com.baizhi.test;

import com.baizhi.entity.Course;
import com.baizhi.service.CourseService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class CourseTest extends BaseTest {
    @Autowired
    private CourseService courseService;
    @Test
    public void testsave(){
        Course course = new Course();

        course.setTitle("诚心礼佛");
        course.setFlag("y");
        course.setCreatTime(new Date());
        courseService.add(course);
    }

    @Test
    public void testquery(){
        List<Course> courses = courseService.find();
        System.out.println(courses);
    }

    @Test
    public void testdelete(){
        courseService.remove("01d971aa-5db4-48d5-a439-01f49afbf364");
    }
}
