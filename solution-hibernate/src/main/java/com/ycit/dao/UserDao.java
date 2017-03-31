package com.ycit.dao;

import com.ycit.bean.entity.User;

import java.util.List;

/**
 * Created by xlch on 2017/2/26.
 */
public interface UserDao {

    List<User> find();

}
