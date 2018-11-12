package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
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
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping("/query")
    @ResponseBody
    public List<Album> query(){
        List<Album> albums = albumService.find();
        return albums;
    }

    @RequestMapping("queryOne")
    @ResponseBody
    public Album queryOne(String id){

        Album album = albumService.findOne(id);
        return album;
    }

    @RequestMapping("/save")
    @ResponseBody
    public Map<String,Object> save(Album album, HttpServletRequest request, MultipartFile partfile){
        Map<String, Object> results = new HashMap<>();

        try {
            String realPath = request.getSession().getServletContext().getRealPath ("/albumimg");
            System.out.println(realPath);
            partfile.transferTo(new File(realPath,partfile.getOriginalFilename()));
            System.out.println(partfile.getOriginalFilename());
            album.setCoverImg("/albumimg/"+partfile.getOriginalFilename());
            albumService.add(album);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }


    @RequestMapping("/findByPage")
    @ResponseBody
    public Map<String,Object> findByPage(Integer page,Integer rows){
        Map<String, Object> results = new HashMap<String, Object>();
        List<Album> albums = albumService.findByPage(page, rows);
        Long totals = albumService.findTotals();
        results.put("total",totals);
        results.put("rows",albums);
        return results;
    }
}
