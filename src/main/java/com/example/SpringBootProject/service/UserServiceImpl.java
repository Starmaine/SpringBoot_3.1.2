package com.example.SpringBootProject.service;

import com.example.SpringBootProject.dao.UserDao;
import com.example.SpringBootProject.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {


    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public void delete(int id) {

        try {
            userDao.delete(id);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("can't find user for removal");
        }

    }

    @Override
    @Transactional
    public void update(User newUser) {
        userDao.update(newUser);
    }

    @Override
    @Transactional
    public User findById(int id) {
        return userDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.findAll();
    }
}
