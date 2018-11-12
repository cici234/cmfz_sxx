package com.baizhi.service;

import com.baizhi.dao.GuruDao;
import com.baizhi.entity.Guru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class GuruServiceImpl implements GuruService {
    @Autowired
    private GuruDao guruDao;
    @Override
    public void add(Guru guru) {
        guru.setId(UUID.randomUUID().toString());
        guruDao.insert(guru);
    }

    @Override
    public void motify(Guru guru) {

    }

    @Override
    public void remove(String id) {
        guruDao.delete(id);
    }

    @Override
    public List<Guru> find() {
        List<Guru> gurus = guruDao.query();
        return gurus;
    }

    @Override
    public Guru findOne(String id) {
        return null;
    }

    @Override
    public void deleteMany(String[] id) {

    }

    @Override
    public List<Guru> findByPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        List<Guru> gurus = guruDao.findByPage(start, rows);

        return gurus;
    }

    @Override
    public Long findTotals() {
        Long totals = guruDao.findTotals();

        return totals;
    }
}
