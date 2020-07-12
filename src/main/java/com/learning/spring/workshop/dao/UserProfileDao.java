package com.learning.spring.workshop.dao;

import com.learning.spring.workshop.model.UserProfile;

import java.util.List;

public interface UserProfileDao {
    List<UserProfile> findAll();
    UserProfile findByType(String type);
    UserProfile findById(int id);
}
