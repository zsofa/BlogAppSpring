/*
package com.example.BlogAppSpring.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;

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

    @CreationTimestamp
    private LocalDateTime regTime;

    @Enumerated
    private State state;

    public UserData() {
    }

    public UserData(long id, String userName,
                    String password, String email, byte[] profilePicture, State state) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.profilePicture = profilePicture;
        this.state = state;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", profilePicture=" + Arrays.toString(profilePicture) +
                ", state=" + state +
                '}';
    }
}
*/
