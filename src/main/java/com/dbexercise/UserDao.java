package com.dbexercise;

import com.domain.User;

import java.sql.*;
import java.util.Map;

public class UserDao {

    private ConnectionMaker connectionMaker;

    public UserDao(){
        this.connectionMaker = new AWSConnectionMaker();
    }

    public UserDao(ConnectionMaker connectionMaker){
        this.connectionMaker = connectionMaker;
    }

    public void add(User user){
        Map<String, String> env = System.getenv();
        try{
            Connection conn = connectionMaker.makeConnection();
            // Query 문 작성
            PreparedStatement pstmt =
                    conn.prepareStatement("INSERT INTO users(id, name, password) values (?, ?, ?)");
            pstmt.setString(1, user.getId());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getPassword());

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
            Connection conn = connectionMaker.makeConnection();
            // Query 문 작성
            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT * FROM users where id = ?");
            pstmt.setString(1, id);

            // Query 문 실행
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
        userDao.add(new User("9", "mark9", "12341234"));
        User user = userDao.selectById("9");
        System.out.println(user.getName());
    }
}
