package com.baizhi.service;

import com.baizhi.entity.User;

public interface UserService{
    void register(User user);
    void motify(User user);
    User login(User user);

}
