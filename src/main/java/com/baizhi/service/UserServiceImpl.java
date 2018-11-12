package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public void register(User user) {

        user.setId(UUID.randomUUID().toString());
        String replace = UUID.randomUUID().toString().replace("-", "");

        String salt = MD5Util.getPwd(replace);
        user.setSalt(salt);
        String pwd = MD5Util.getPwd(user.getPassword());
        user.setPassword(pwd+salt);
        userDao.insert(user);
}

    @Override
    public void motify(User user) {
        userDao.update(user);
    }



    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User login(User user) {
        User user1 = userDao.querySalt(user);
        String pwd = MD5Util.getPwd(user.getPassword());
        user.setPassword(pwd+user1.getSalt());
        User login = userDao.login(user);
        return login;
    }
}
