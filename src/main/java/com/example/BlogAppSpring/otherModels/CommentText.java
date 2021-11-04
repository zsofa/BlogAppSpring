package com.example.BlogAppSpring.otherModels;

import com.example.BlogAppSpring.userModels.UserData;
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

    @ManyToOne
    private BlogText blog_text;

    @ManyToOne
    private UserData userData;

    public CommentText() {
    }

    public CommentText(long id, String commentText) {
        this.id = id;
        this.commentText = commentText;
    }
}
