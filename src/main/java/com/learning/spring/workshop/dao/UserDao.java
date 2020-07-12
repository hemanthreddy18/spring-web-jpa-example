package com.learning.spring.workshop.dao;

import com.learning.spring.workshop.model.User;

import java.util.List;

public interface UserDao {
    User findById(int id);
    User findBySSO(String sso);
    void save(User user);
    void deleteBySSO(String sso);
    List<User> findAllUsers();
}
