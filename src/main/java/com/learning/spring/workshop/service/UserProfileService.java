package com.learning.spring.workshop.service;

import com.learning.spring.workshop.model.UserProfile;

import java.util.List;

public interface UserProfileService {

    UserProfile findById(int id);
    UserProfile findByType(String type);
    List<UserProfile> findAll();
}
