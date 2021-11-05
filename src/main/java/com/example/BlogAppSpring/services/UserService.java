package com.example.BlogAppSpring.services;

import com.example.BlogAppSpring.userModels.UserData;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public List<UserData> listAllUsers() {
        List<UserData> users = entityManager
                .createQuery("SELECT users FROM UserData users", UserData.class)
                .getResultList();

        return users;
    }

    @Transactional
    public UserData getUserById(Long id) {
        UserData userData = entityManager
                .createQuery("SELECT userData FROM UserData userdata WHERE userdata.id = :id",
                        UserData.class)
                .setParameter("id", id)
                .getSingleResult();


        return userData;
    }

    @Transactional
    public UserData registerNewUser(UserData user) {
        entityManager.persist(user);
        return user;
    }


    public UserData getLoggedInUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            Object user = auth.getPrincipal();
            if (user instanceof UserData) {
                return (UserData) user;
            }
        }
        return null;
    }


}
