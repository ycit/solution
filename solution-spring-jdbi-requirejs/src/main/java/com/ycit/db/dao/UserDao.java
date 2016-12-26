package com.ycit.db.dao;

import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.sqlobject.stringtemplate.UseStringTemplate3StatementLocator;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

/**
 * Created by xlch on 2016/12/14.
 */
@UseStringTemplate3StatementLocator//使用 .sql.stg 配置文件的方法写sql
@RegisterMapperFactory(BeanMapperFactory.class)
public interface UserDao {
}
