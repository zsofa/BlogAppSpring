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

    /**
     * 1. visszaadja az összes felhasználót az adatbázisból KÉSZ
     *
     * 2. visszaadja az adott id-jű felhasználót adatbázisból
     * megjegyzés: ha nincs szám típusú id-ja a felhasználóidnak,
     * akkor ebben az endpoint-ban lecserélhető a Long id arra az adattípusra,
     * amilyen PRIMARY KEY-t használsz DONE
     *
     * 3. visszaadja a bejelentkezett felhasználót LATER
     *
     * 4.  új felhasználót rögzít az adatbázisba
     *
     * 5. + 1 BlogService
     */


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
