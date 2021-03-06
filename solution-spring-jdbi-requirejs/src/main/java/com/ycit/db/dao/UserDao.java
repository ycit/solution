package com.ycit.db.dao;

import com.ycit.beans.User;
import com.ycit.db.BeanMapperFactory;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.sqlobject.stringtemplate.UseStringTemplate3StatementLocator;

import java.util.List;

/**
 * Created by xlch on 2016/12/14.
 */
@UseStringTemplate3StatementLocator//使用 .sql.stg 配置文件的方法写sql，依赖antlr
@RegisterMapperFactory(BeanMapperFactory.class)
public interface UserDao {

    @SqlQuery
    List<User> find();

//    @SqlUpdate
//    @GetGeneratedKeys(columnName = "id",value = IdMapper.class )
//    Long insertR(@BindBean("user")User user);

    @SqlUpdate
    void insert(@BindBean("user")User user);

    @SqlQuery
    User findById(@Bind("id")Long id);

}
