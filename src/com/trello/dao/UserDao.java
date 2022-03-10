package com.trello.dao;

import com.trello.entities.Card;
import com.trello.entities.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UserDao {
    private Map<Integer, User> userMap = new HashMap<>();
//
//    public UserDao(Map<Integer, User> userMap) {
//        this.userMap = userMap;
//    }

    public User getUser(Integer userId) {
        return userMap.get(userId);
    }

    public boolean createUser(User user) {
        if(Objects.nonNull(getUser(user.getUserId()))){
            return false;
        }
        userMap.putIfAbsent(user.getUserId(), user);
        return true;
    }

    public User updateUser(User user) {
        userMap.put(user.getUserId(), user);
        return user;
    }

    public boolean deleteUser(Integer userId){
        userMap.remove(userId);
        return true;
    }
}
