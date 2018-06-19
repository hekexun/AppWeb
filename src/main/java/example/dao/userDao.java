package example.dao;

import example.pojo.userPojo;

import java.sql.Connection;
import java.sql.SQLException;

public interface userDao {
    public int save(Connection conn, userPojo user) throws SQLException;
}
