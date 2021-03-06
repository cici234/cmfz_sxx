package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDao albumDao;
    @Override
    public void add(Album album) {
        album.setId(UUID.randomUUID().toString());
        albumDao.insert(album);
    }

    @Override
    public void motify(Album album) {

    }

    @Override
    public void remove(String id) {
        albumDao.delete(id);
    }

    @Override

    public List<Album> find() {

        List<Album> albums = albumDao.query();
        return albums;
    }

    @Override
    public Album findOne(String id) {
        Album album = albumDao.queryOne(id);
        return album;
    }

    @Override
    public void deleteMany(String[] id) {

    }

    @Override
    public List<Album> findByPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        List<Album> albums = albumDao.findByPage(start, rows);
        return albums;
    }

    @Override
    public Long findTotals() {
        Long totals = albumDao.findTotals();

        return totals;
    }
}
