package com.learning.spring.workshop.service;

import com.learning.spring.workshop.dao.UserDao;
import com.learning.spring.workshop.model.User;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao dao;

    @Override
    public User findById(int id) {
        return dao.findById(id);
    }

    @Override
    public User findBySSO(String sso) {
        var user = dao.findBySSO(sso);
        return user;
    }

    @Override
    public void saveUser(User user) {
        dao.save(user);

    }

    @Override
    public void updateUser(User user) {
        User entity = dao.findById(user.getId());

        if (entity != null) {
            entity.setSsoId(user.getSsoId());
            entity.setFirstName(user.getFirstName());
            entity.setLastName(user.getLastName());
            entity.setPassword(user.getPassword());
            entity.setEmail(user.getEmail());
            entity.setUserProfiles(user.getUserProfiles());
        }
    }

    @Override
    public void deleteUserBySSO(String sso) {
        dao.deleteBySSO(sso);
    }

    @Override
    public List<User> findAllUsers() {
        return dao.findAllUsers();
    }

    @Override
    public boolean isUserSSOUnique(Integer id, String sso) {
        User user = findBySSO(sso);
        return user == null || ((id != null) && (user.getId() == id));
    }
}
