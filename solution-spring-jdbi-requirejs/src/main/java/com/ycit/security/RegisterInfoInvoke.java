package com.ycit.security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * @author xlch
 * @Date 2017-12-27 16:14
 */
public class RegisterInfoInvoke {

    public void register() {
        Subject user = SecurityUtils.getSubject();
    }

}
