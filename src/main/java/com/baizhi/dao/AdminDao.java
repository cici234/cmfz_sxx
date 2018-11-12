package com.baizhi.dao;

import com.baizhi.entity.Admin;

public interface AdminDao {
    Admin login(Admin admin);
    void update(Admin admin);
}
