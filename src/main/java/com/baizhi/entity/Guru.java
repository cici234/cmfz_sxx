package com.baizhi.entity;

import java.util.List;

public class Guru {
    private String id;
    private String name;
    private String heasPic;
    private String sex;
    private List<Article> articles;

    public Guru(String id, String name, String heasPic, String sex, List<Article> articles) {
        this.id = id;
        this.name = name;
        this.heasPic = heasPic;
        this.sex = sex;
        this.articles = articles;
    }

    public Guru() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeasPic() {
        return heasPic;
    }

    public void setHeasPic(String heasPic) {
        this.heasPic = heasPic;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Guru{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", heasPic='" + heasPic + '\'' +
                ", sex='" + sex + '\'' +
                ", articles=" + articles +
                '}';
    }
}
