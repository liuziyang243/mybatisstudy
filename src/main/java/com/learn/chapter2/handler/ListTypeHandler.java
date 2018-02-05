package com.learn.chapter2.handler;

import com.learn.chapter2.util.JsonUtil;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author lzy
 * <p>
 * Create Time: 2018/2/2 14:05
 * @version v1.00
 */
@MappedTypes(List.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class ListTypeHandler implements TypeHandler<List<String>> {

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, List<String> strings, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, JsonUtil.toJSON(strings));
    }

    @Override
    public List<String> getResult(ResultSet resultSet, String s) throws SQLException {
        return JsonUtil.jsonToList(resultSet.getString(s), String.class);
    }

    @Override
    public List<String> getResult(ResultSet resultSet, int i) throws SQLException {
        return JsonUtil.jsonToList(resultSet.getString(i), String.class);
    }

    @Override
    public List<String> getResult(CallableStatement callableStatement, int i) throws SQLException {
        return JsonUtil.jsonToList(callableStatement.getString(i), String.class);
    }
}
