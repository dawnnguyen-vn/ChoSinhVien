package com.chosinhvien.service;

import com.chosinhvien.dto.UserDto;
import com.chosinhvien.entity.Role;
import com.chosinhvien.entity.User;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface IUserService {
    List<UserDto> findAll();
    User add(User user);
    Role saveRole(Role role);
    void addRoleToUser(String email, String roleName);
    User findByEmail(String email);
    int enableUser(String email);

    @PreAuthorize("permitAll()")
    boolean exists(String email);
}