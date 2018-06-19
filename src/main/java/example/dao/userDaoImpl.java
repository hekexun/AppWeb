package example.dao;

import example.pojo.userPojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class userDaoImpl implements userDao {

    @Override
    public int save(Connection conn, userPojo user) throws SQLException {
        PreparedStatement ps = conn.
                prepareCall("INSERT INTO tb_huiyi(name,mail,telphone,company,zhiwei,beizhu) values(?,?,?,?,?,?)");
        ps.setString(1, user.getName());
        ps.setString(2, user.getMail());
        ps.setString(3, user.getTelphone());
        ps.setString(4, user.getCompany());
        ps.setString(5, user.getZhiwei());
        ps.setString(6, user.getBeizhu());
        int result = ps.executeUpdate();
        return  result;
    }
}
