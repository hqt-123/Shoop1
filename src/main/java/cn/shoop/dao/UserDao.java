package cn.shoop.dao;

import cn.shoop.entity.User;
import cn.shoop.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
    public User login(String username, String password) {
        try (Connection conn = DBUtils.getConn();){
            String sql = "select id from tb_user where username =? and password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            System.out.println("查询成功！");
            if (rs.next()){
                int id = rs.getInt(1);
                return  new User(id,username,password);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
