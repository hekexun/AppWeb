package example.service;

import example.dao.userDao;
import example.dao.userDaoImpl;
import example.pojo.userPojo;
import example.until.ConnectionFactory;

import java.sql.Connection;

public class insertUserServiceImpl implements insertUserService{

    @Override
    public String userHandle(userPojo user) {
        userDao uDao=new userDaoImpl();
        Connection conn=null;
        try {
            conn= ConnectionFactory.getInstance().makeConn();
            conn.setAutoCommit(false);
            uDao.save(conn, user);
            conn.commit();
            return "ok";


        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch ( Exception e2) {
                e2.printStackTrace();
            }
        }finally
        {
            try {
                conn.close();
            } catch (  Exception e3) {
                e3.printStackTrace();
            }
        }
        return null;
    }
}
