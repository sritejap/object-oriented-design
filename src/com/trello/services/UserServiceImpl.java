package com.trello.services;

import com.trello.dao.UserDao;
import com.trello.entities.User;

public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }
    @Override
    public User createUser(String name, String email){
        Integer id = getId("User");
        User user = new User(id,name, email);
        userDao.createUser(user);
        return user;
    }

    @Override
    public void deleteUser(Integer userId){
        userDao.deleteUser(userId);
    }

    @Override
    public void validateUser(Integer userId){}

    private Integer getId(String code){
        return IDGenerator.getId(code);
    }

}
