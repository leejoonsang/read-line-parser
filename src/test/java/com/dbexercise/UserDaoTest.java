package com.dbexercise;

import com.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserDaoTest {
    @Test
    @DisplayName("Test Passed")
    void addAndSelect(){
        AWSUserDaoImpl userDao = new AWSUserDaoImpl();
        String id = "11";
        User user = new User(id, "mark11", "eleven");
        userDao.add(user);

        User selectedUser =  userDao.selectById(id);
        Assertions.assertEquals("mark11", selectedUser.getName());
    }

}
