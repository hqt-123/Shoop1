package cn.shoop.dao;

import cn.shoop.entity.User;
import cn.shoop.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
    public User login(String username, String password) {

        try (Connection conn = DBUtils.getConn();){
            String sql = "select * from tb_user where username =? and password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            System.out.println("查询成功！");
            while (rs.next()){
                int id = rs.getInt(1);
                String phone =rs.getString(2);
                String email = rs.getString(3);
                String gender = rs.getString(4);
                String avater = rs.getString(5);
                String created  = rs.getString(6);
                String updated = rs.getString(7);

                return  new User(id,username,password,phone,email,gender,avater,created,updated);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public User password(String email) {

        try (Connection conn = DBUtils.getConn();){
            String sql = "select * from tb_user where email=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,email);

            ResultSet rs = ps.executeQuery();
            System.out.println("蠢材！");
            while (rs.next()) {
                int id = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String phone = rs.getString(4);
                String gender = rs.getString(5);
                String avater = rs.getString(6);
                String created = rs.getString(7);
                String updated = rs.getString(8);
                return  new User(id,username,password,phone,email,gender,avater,created,updated);


            }
            }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
