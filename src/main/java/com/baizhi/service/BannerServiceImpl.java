package com.baizhi.service;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BannerServiceImpl implements BannerService{
    @Autowired
    private BannerDao bannerDao;

    @Override
    public void add(Banner banner) {
        banner.setId(UUID.randomUUID().toString());
        bannerDao.insert(banner);
    }

    @Override
    public void motify(Banner banner) {
        bannerDao.update(banner);
    }

    @Override
    public void remove(String id) {
        bannerDao.delete(id);
    }

    @Override
    public List<Banner> find() {
        List banner = bannerDao.query();
        return banner;
    }

    @Override
    public Banner findOne(String id) {
        Banner banner = bannerDao.queryOne(id);
        return banner;

    }

    @Override
    public List<Banner> findByPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        List<Banner> banners = bannerDao.findByPage(start, rows);
        return banners;

    }



    @Override
    public Long findTotals() {
        Long totals = bannerDao.findTotals();
        return totals;
    }

    @Override
    public void deleteMany(String[] id) {
        bannerDao.deleteMany(id);
    }


/*    @Override
    public void deleteMany(String[] id) {
        bannerDao.deleteMany(id);
    }

    @Override
    public Banner queryOne(String id) {
        Banner banner = bannerDao.queryOne(id);
        return banner;
    }

    @Override
    public void add(Banner banner) {
        banner.setId(UUID.randomUUID().toString());
        bannerDao.insert(banner);
    }

    @Override
    public void motify(Banner banner) {
        bannerDao.update(banner);
    }

    @Override
    public void remove(String id) {
        bannerDao.delete(id);
    }

    @Override
    public List<Banner> find() {
        List banner = bannerDao.query();
        return banner;
    }*/
}
