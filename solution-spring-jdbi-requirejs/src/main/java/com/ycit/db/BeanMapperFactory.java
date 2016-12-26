package com.ycit.db;

import org.skife.jdbi.v2.ResultSetMapperFactory;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 * jdbi BeanMapperFactory
 * <p/>
 * Created by xlch on 2016/8/23
 */
public class BeanMapperFactory implements ResultSetMapperFactory {

    @Override
    public boolean accepts(Class type, StatementContext ctx)
    {
        return ctx.columnMapperFor(type) == null;
    }

    @Override
    public ResultSetMapper mapperFor(Class type, StatementContext ctx)
    {
        return new BeanMapper(type);
    }
}
