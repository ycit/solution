package com.ycit.service.impl;

import com.ycit.bean.entity.User;
import com.ycit.dao.UserDao;
import com.ycit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xlch on 2017/2/27.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> find() {
        return userDao.find();
    }
}
