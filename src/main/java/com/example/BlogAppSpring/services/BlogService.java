package com.example.BlogAppSpring.services;

import com.example.BlogAppSpring.otherModels.BlogText;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class BlogService {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public List<BlogText> lisAllBlogposts() {
        List<BlogText> blogs = entityManager
                .createQuery("SELECT blogs FROM BlogText blogs", BlogText.class)
                .getResultList();

        return blogs;
    }

    @Transactional
    public void writeBlogpost(BlogText blogText) {
        entityManager.persist(blogText);
    }
}
