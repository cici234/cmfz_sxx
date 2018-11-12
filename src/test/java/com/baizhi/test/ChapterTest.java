package com.baizhi.test;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class ChapterTest extends BaseTest {
    @Autowired
    private ChapterService chapterService;
    @Test
    public void testsave(){
        Chapter chapter = new Chapter();
        chapter.setId("9");
        chapter.setTitle("mm");
        chapter.setSize("6");
        chapter.setDuration("pp");
        chapter.setDownPath("kk");
        chapter.setUploadTime(new Date());
        chapter.setAl_id("2");
        chapterService.add(chapter);
    }
}
