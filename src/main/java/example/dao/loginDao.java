package example.dao;

import example.pojo.loginPojo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface loginDao {
    public ResultSet getPasswd(Connection conn, String login) throws SQLException;
}
