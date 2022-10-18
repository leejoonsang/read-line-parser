package com.dbexercise;

import com.domain.User;

import java.sql.*;
import java.util.Map;

// AWS 혹은 local로 구분해서 수행하고 싶을 때
// abstract 클래스 생성 후, AWSUserDao/LocalUserDao 구분해서 extend
public abstract class UserDaoAbstract {

    public abstract Connection makeConnection() throws SQLException;

    public void add(User user){
        Map<String, String> env = System.getenv();
        try{
            Connection conn = makeConnection();
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
            Connection conn = makeConnection();
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

}
