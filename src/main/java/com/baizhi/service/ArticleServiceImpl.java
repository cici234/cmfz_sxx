package com.baizhi.service;

import com.baizhi.dao.ArticleDao;
import com.baizhi.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    @Override
    public void deleteMany(String[] id) {

    }

    @Override
    public List<Article> findByPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        List<Article> articles = articleDao.findByPage(start, rows);
        return articles;
    }

    @Override
    public Long findTotals() {
        Long totals = articleDao.findTotals();
        return totals;
    }

    @Override
    public void add(Article article) {
        article.setId(UUID.randomUUID().toString());
        articleDao.insert(article);
    }

    @Override
    public void motify(Article article) {

    }

    @Override
    public void remove(String id) {
        articleDao.delete(id);
    }

    @Override
    public List<Article> find() {
        List<Article> articles = articleDao.query();
        return articles;
    }

    @Override
    public Article findOne(String id) {
        return null;
    }
}
