package com.chosinhvien.service;

import com.chosinhvien.dto.UserDto;
import com.chosinhvien.entity.Role;
import com.chosinhvien.entity.User;
import com.chosinhvien.util.CustomException;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface IUserService {
    List<UserDto> findAll();
    UserDto findById(Long id);
    User findEntityById(Long id);
    User add(User user);
    Role saveRole(Role role);
    void addRoleToUser(String email, String roleName);
    User findByEmail(String email);
    int enableUser(String email);
    String getUsername();
    @PreAuthorize("permitAll()")
    boolean exists(String email);

    void editName(Long id, String name);

    void editPhone(Long id, String phone);

    void editAddress(Long id, String address);

    void setPoint(int point);

    void resetPassword(String email) throws CustomException;
}