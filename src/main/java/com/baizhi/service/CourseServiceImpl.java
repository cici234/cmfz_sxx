package com.baizhi.service;

import com.baizhi.dao.CourseDaO;
import com.baizhi.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDaO courseDaO;

    @Override
    public List<Course> findByPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        List<Course> courses = courseDaO.findByPage(start, rows);
        return courses;
    }

    @Override
    public void deleteMany(String[] id) {

    }

    @Override
    public Long findTotals() {
        Long totals = courseDaO.findTotals();
        return totals;
    }

    @Override
    public void add(Course course) {
        course.setId(UUID.randomUUID().toString());
        courseDaO.insert(course);
    }

    @Override
    public void motify(Course course) {

    }

    @Override
    public void remove(String id) {
        courseDaO.delete(id);
    }

    @Override
    public List<Course> find() {
        List<Course> courses = courseDaO.query();
        return courses;
    }

    @Override
    public Course findOne(String id) {
        return null;
    }
}
