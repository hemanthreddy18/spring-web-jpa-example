package com.learning.spring.workshop.dao;

import com.learning.spring.workshop.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.Collection;
import java.util.List;

@Repository
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao{

    @Override
    public User findById(int id) {
        User user = getByKey(id);
        if (user != null) {
            initializeCollection(user.getUserProfiles());
        }
        return user;
    }

    @Override
    public User findBySSO(String sso) {

        List<User> users = (List<User>) getEntityManager()
                .createQuery("SELECT u FROM User u WHERE u.ssoId LIKE :ssoId")
                .setParameter("ssoId", sso)
                .getResultList();
        User user = users.size()>0 ? users.get(0):null;
        if(user != null)
            initializeCollection(user.getUserProfiles());
        return user;
    }

    @Override
    public void save(User user) {
        persist(user);
    }

    @Override
    public void deleteBySSO(String sso) {
        try {
            List<User> users = (List<User>) getEntityManager()
                    .createQuery("SELECT u FROM User u WHERE u.ssoId LIKE :ssoId")
                    .setParameter("ssoId", sso)
                    .getResultList();
            User user = users.size()>0 ? users.get(0):null;
            if (user != null)
                delete(user);
            else
                System.out.println("User not found.");
        } catch (NoResultException ex){
            System.out.println("Exception:"+ex);
        }
    }

    @Override
    public List<User> findAllUsers() {
        List resultList = getEntityManager()
                .createQuery("SELECT u FROM User u ORDER BY u.firstName ASC")
                .getResultList();
        System.out.println(resultList);
        return resultList;
    }

    protected void initializeCollection(Collection<?> collection) {
        if(collection == null) {
            return;
        }
        collection.iterator().hasNext();
    }
}
