package com.baizhi.test;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class AlbumTest extends BaseTest {
    @Autowired
    private AlbumService albumService;
    @Test
    public void testquery(){
        List<Album> albums = albumService.find();
        System.out.println(albums);
    }

    @Test
    public void testqueryOne(){
        Album album = albumService.findOne("1");
        System.out.println(album);
    }
    @Test
    public void testadd(){
        Album album1 = new Album();
        album1.setId("2");
        album1.setTitle("ww");
        album1.setPublishDate(new Date());
        album1.setCount("3");
        album1.setCoverImg("/albumimg/A-2.jpg");
        album1.setStar("2");
        album1.setAuthor("ww");
        album1.setBroadCast("ww");
        album1.setBrief("ww");
        albumService.add(album1);
    }
}
