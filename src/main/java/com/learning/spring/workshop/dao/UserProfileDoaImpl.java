package com.learning.spring.workshop.dao;

import com.learning.spring.workshop.model.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserProfileDoaImpl extends AbstractDao<Integer, UserProfile> implements UserProfileDao{
    @Override
    @SuppressWarnings("unchecked")
    public List<UserProfile> findAll() {
        List<UserProfile> userProfiles = getEntityManager()
                .createQuery("SELECT p FROM UserProfile p ORDER BY p.type ASC")
                .getResultList();
        return userProfiles;
    }

    @Override
    public UserProfile findByType(String type) {
        UserProfile userProfile = (UserProfile) getEntityManager()
                .createQuery("SELECT p FROM UserProfile p WHERE p.type LIKE :type ")
                .setParameter("type",type)
                .getSingleResult();
        return userProfile;
    }

    @Override
    public UserProfile findById(int id) {
        return getByKey(id);
    }
}
