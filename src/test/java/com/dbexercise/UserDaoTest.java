package com.dbexercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    @Test
    @DisplayName("Test Passed")
    void addAndSelect(){
        UserDao userDao = new UserDao();
        User user = new User("6", "mark6", "zxcv");
        userDao.add(user);

        User selectedUser =  userDao.selectById("6");
        Assertions.assertEquals("mark6", selectedUser.getName());
    }

}
