package com.ycit.service;

import com.ycit.beans.User;
import com.ycit.db.dao.UserDao;
import org.skife.jdbi.v2.IDBI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xlch on 2016/12/28.
 */
@Service
public class UserService {

    @Autowired
    private IDBI dbi;

    public List<User> find() {
        return dbi.onDemand(UserDao.class).find();
    }

//    public User insertR(User user) {
//        Long id =  dbi.onDemand(UserDao.class).insertR(user);
//        return this.findById(id);
//    }

    public void insert(User user) {
        dbi.onDemand(UserDao.class).insert(user);
    }


    public User findById(Long id) {
        return dbi.onDemand(UserDao.class).findById(id);
    }

}
