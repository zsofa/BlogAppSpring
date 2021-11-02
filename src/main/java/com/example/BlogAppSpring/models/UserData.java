package com.example.BlogAppSpring.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50,unique = true)
    private String userName;

    @Column(length = 50,unique = true)
    private String password;

    @Column(length = 200 ,unique = true)
    private String email;
    private byte[] profilePicture;

    @Enumerated
    private State state;
}
