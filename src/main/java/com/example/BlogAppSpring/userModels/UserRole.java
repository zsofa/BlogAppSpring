package com.example.BlogAppSpring.userModels;

public enum UserRole {
    USER(UserAuthority.OWN_USER_DATA_READ,
            UserAuthority.OWN_USER_DATA_EDIT,
            UserAuthority.ALL_BLOGPOST_EDIT,
            UserAuthority.OWN_USER_DATA_EDIT,
            UserAuthority.OWN_BLOGPOST_DELETE,
            UserAuthority.COMMENT_WRITE,
            UserAuthority.BLOGPOST_READ),

    ADMIN(UserAuthority.ALL_USER_DATA_READ,
            UserAuthority.ALL_USER_DATA_EDIT,
            UserAuthority.ALL_BLOGPOST_DELETE,
            UserAuthority.COMMENT_WRITE,
            UserAuthority.BLOGPOST_READ),

    MODERATOR(UserAuthority.ALL_USER_DATA_EDIT,
            UserAuthority.ALL_BLOGPOST_DELETE,
            UserAuthority.COMMENT_WRITE,
            UserAuthority.BLOGPOST_READ),

    GUEST(UserAuthority.BLOGPOST_READ);

    public final UserAuthority[] AUTHORITIES;

    UserRole(UserAuthority... authority) {
        AUTHORITIES = authority;
    }

}
