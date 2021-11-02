package com.example.BlogAppSpring.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class CommentText {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 300)
    private String commentText;

    public CommentText() {
    }

    public CommentText(long id, String commentText) {
        this.id = id;
        this.commentText = commentText;
    }
}
