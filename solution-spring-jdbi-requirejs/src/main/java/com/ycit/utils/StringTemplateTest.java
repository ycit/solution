package com.ycit.utils;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;

import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 模版测试
 *
 * @author xlch
 * @create 2017-08-09 8:53
 */
public class StringTemplateTest {

    public static void main(String [] args) {
        InputStream in = StringTemplateTest.class.getResourceAsStream("/com/ycit/db/dao/UserDao.sql.stg");
        StringTemplateGroup group = new StringTemplateGroup(new InputStreamReader(in));
        StringTemplate st = group.getInstanceOf("findById");
//        st.setAttribute("name",null);
//        st.setAttribute("age",null);
//        st.setAttribute("email",null);
        st.setAttribute("id",4);
        System.out.println(st);
    }

}
