package com.dbexercise;

import com.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserDaoTest {
    @Test
    @DisplayName("Test Passed")
    void addAndSelect(){
        UserDao userDao = new UserDaoFactory().awsUserDao();
        String id = "16";
        User user = new User(id, "mark16", "sixteen");
        userDao.add(user);

        User selectedUser = userDao.selectById(id);
        Assertions.assertEquals("mark16", selectedUser.getName());
        Assertions.assertEquals("sixteen", selectedUser.getPassword());
    }

}
