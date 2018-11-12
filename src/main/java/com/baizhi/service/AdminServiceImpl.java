package com.baizhi.service;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public void update(Admin admin) {
        adminDao.update(admin);
    }

    @Override
    public Admin login(Admin admin) {

        Admin login = adminDao.login(admin);
        return login;
    }
}
