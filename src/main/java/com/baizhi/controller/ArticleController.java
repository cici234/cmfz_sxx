package com.baizhi.controller;

import com.baizhi.entity.Article;
import com.baizhi.service.ArticleService;
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
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @RequestMapping("/query")
    @ResponseBody
    public List<Article> query(){
        List<Article> articles = articleService.find();
        return articles;
    }

    @RequestMapping("/findByPage")
    @ResponseBody
    public Map<String,Object> findByPage(Integer page,Integer rows){
        Map<String, Object> results = new HashMap<String, Object>();
        List<Article> articles = articleService.findByPage(page, rows);
        Long totals = articleService.findTotals();
        results.put("total",totals);
        results.put("rows",articles);
        return results;
    }


    @RequestMapping("/save")
    @ResponseBody
    public Map<String,Object> save(Article article, HttpServletRequest request, MultipartFile partfile){
        Map<String, Object> results = new HashMap<String,Object>();

        try {
            String realPath = request.getSession().getServletContext().getRealPath("/articleimg");
            //System.out.println(realPath);
            partfile.transferTo(new File(realPath,partfile.getOriginalFilename()));
            //System.out.println(partfile.getOriginalFilename());
            article.setImgPath("/articleimg/"+partfile.getOriginalFilename());

            articleService.add(article);
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
    public String  delete(String id,HttpServletRequest request){
        String realPath = request.getSession().getServletContext().getRealPath("/articleimg");
        File file = new File(realPath);
        file.delete();
        articleService.remove(id);
        return "";
    }

}
