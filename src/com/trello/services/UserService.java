package com.trello.services;

import com.trello.entities.User;

import java.util.List;

public interface UserService {
    public User createUser(String name, String email);

    public void deleteUser(Integer userId);

    public void validateUser(Integer userId);

}
