package com.example.BlogAppSpring.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter @Setter
@Entity
public class BlogText {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 1000)
    private String textContent;

    @ManyToOne
    private UserData user;

    @ManyToOne
    private Template template;

    @OneToMany(mappedBy = "blog_text")
    private List<CommentText> commentTextList;

    public BlogText() {
    }

    public BlogText(long id, String textContent) {
        this.id = id;
        this.textContent = textContent;
    }

    @Override
    public String toString() {
        return "BlogText{" +
                "id=" + id +
                ", textContent='" + textContent + '\'' +
                '}';
    }
}
