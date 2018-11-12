package com.baizhi.test;

import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GuruTest extends BaseTest {

    @Autowired
    private GuruService guruService;
    @Test
    public void queryGuru(){
        List<Guru> gurus = guruService.find();
        System.out.println(gurus);
    }

    @Test
    public void addGuru(){
        Guru guru = new Guru();
        guru.setId("1");
        guru.setName("上师");
        guru.setHeasPic("/guruimg/5.jpg");
        guru.setSex("男");
        guruService.add(guru);
    }


    @Test
    public void remove(){
        guruService.remove("5");
    }
}
