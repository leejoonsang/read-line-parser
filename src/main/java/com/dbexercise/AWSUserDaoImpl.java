package com.dbexercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class AWSUserDaoImpl extends UserDaoAbstract{
    public Connection makeConnection() throws SQLException {
        Map<String, String> env = System.getenv();
        // DB 연동(ex. mySQL Workbench 실행)
        Connection conn = DriverManager.getConnection(
                env.get("DB_HOST"), env.get("DB_USER"), env.get("DB_PASSWORD"));
        return conn;
    }

}
