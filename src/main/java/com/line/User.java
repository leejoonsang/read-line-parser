package com.line;

public class User {
    String id;
    String name;
    String password;

    public String getName() {
        return name;
    }

    public User(String id, String name, String password){
        this.id = id;
        this.name = name;
        this.password = password;
    }
}
