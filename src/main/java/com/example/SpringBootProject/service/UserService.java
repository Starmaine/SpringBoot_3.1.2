package com.example.SpringBootProject.service;


import com.example.SpringBootProject.model.User;

import java.util.List;

public interface UserService {

    void save(User user);

    void delete(int id);

    void update(User user);

    User findById(int id);

    List<User> getAllUsers();

}
