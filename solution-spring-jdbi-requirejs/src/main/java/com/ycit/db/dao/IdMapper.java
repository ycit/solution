package com.ycit.db.dao;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xlch on 2017/1/7.
 */
public class IdMapper implements ResultSetMapper<Long> {

    @Override
    public Long map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return r.getLong(1);
    }
}
