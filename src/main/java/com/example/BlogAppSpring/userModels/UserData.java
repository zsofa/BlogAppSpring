
package com.example.BlogAppSpring.userModels;

import com.example.BlogAppSpring.otherModels.BlogText;
import com.example.BlogAppSpring.otherModels.CommentText;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Getter @Setter
@Entity
@Table
public class UserData implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50,unique = true) // nullable - not null - default true
    private String userName;

    @Column(length = 50,unique = true)
    private String password;


    private String email;
    private byte[] profilePicture;

    @CreationTimestamp
    private LocalDateTime regTime;

    @Enumerated
    private UserRole userRole;

    @OneToMany(mappedBy = "user")
    private List<BlogText> blogTextList;

    @OneToMany(mappedBy = "userData")
    private List<CommentText> commentTextList;



    public UserData() {
    }

    public UserData(long id, String userName,
                    String password, String email, byte[] profilePicture, UserRole userRole) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.profilePicture = profilePicture;
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", profilePicture=" + Arrays.toString(profilePicture) +
                ", state=" + userRole +
                '}';
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}

