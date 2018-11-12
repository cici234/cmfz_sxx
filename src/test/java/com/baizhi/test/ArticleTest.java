package com.baizhi.test;

import com.baizhi.entity.Article;
import com.baizhi.service.ArticleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ArticleTest extends BaseTest {
    @Autowired
    private ArticleService articleService;
    @Test
    public void query(){
        List<Article> articles = articleService.find();
        System.out.println(articles);
    }
}
