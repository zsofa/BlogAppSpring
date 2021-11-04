package com.example.BlogAppSpring.controller;

import com.example.BlogAppSpring.otherModels.BlogText;
import com.example.BlogAppSpring.returnModel.ReturnModel;
import com.example.BlogAppSpring.services.BlogService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogpostController {

    BlogService blogService;

    @Autowired
    public BlogpostController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blogs")
    public ReturnModel<BlogText> getAllBlogs() {
        ReturnModel<BlogText> blogs =
                new ReturnModel<>(true, HttpStatus.OK, blogService.lisAllBlogposts());

        return blogs;
    }

    
}
