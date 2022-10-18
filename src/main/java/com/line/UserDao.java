package com.line;

import java.sql.*;
import java.util.Map;

public class UserDao {

    public void add(){
        Map<String, String> env = System.getenv();
        try{
            // DB 연동
            Connection conn = DriverManager.getConnection(env.get("DB_HOST"),
                    env.get("DB_USER"), env.get("DB_PASSWORD"));
            // Query문 작성
            PreparedStatement pstmt =
                    conn.prepareStatement("INSERT INTO users(id, name, password) values (?, ?, ?)");
            pstmt.setString(1, "2");
            pstmt.setString(2, "asdf");
            pstmt.setString(3, "0000");

            pstmt.executeUpdate();

            pstmt.close();
            conn.close();

        }catch (SQLException e){
            throw new RuntimeException();
        }
    }

    public User selectById(String id){
        Map<String, String> env = System.getenv();
        try{
            // DB 연동
            Connection conn = DriverManager.getConnection(env.get("DB_HOST"),
                    env.get("DB_USER"), env.get("DB_PASSWORD"));
            // Query문 작성
            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT * FROM users where id = ?");
            pstmt.setString(1, id);

            // Query문 실행
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            User user = new User(rs.getString("id"),
                    rs.getString("name"), rs.getString("password"));

            rs.close();
            pstmt.close();
            conn.close();

            return user;

        }catch (SQLException e){
            throw new RuntimeException();
        }

    }

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        userDao.add();
        User user = userDao.selectById("2");
        System.out.println(user.getName());
    }
}
