package com.dbexercise;

import com.domain.User;

// 조립을 해준다.
public class UserDaoFactory {
    public UserDao awsUserDao() {
        AWSConnectionMaker awsConnectionMaker = new AWSConnectionMaker();
        UserDao userDao = new UserDao(awsConnectionMaker);
        return userDao;
    }

//    public UserDao localUserDao() {
//        UserDao userDao = new UserDao(new LocalConnectionMaker());
//        return userDao;
//    }

}
