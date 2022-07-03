package com.chosinhvien.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class MyUser extends User {

    private Long id;
    private String name;
    private String username;

    public MyUser(String username, String password, Long id, String name, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.id = id;
        this.name = name;
        this.username = username;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    @Override
    public String getUsername() {
        return username;
    }
}
