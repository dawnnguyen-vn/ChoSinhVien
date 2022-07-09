package com.chosinhvien.service.impl;

import com.chosinhvien.constant.MessageException;
import com.chosinhvien.constant.UserRole;
import com.chosinhvien.dto.UserDto;
import com.chosinhvien.email.IEmailService;
import com.chosinhvien.entity.Role;
import com.chosinhvien.entity.User;
import com.chosinhvien.model.MyUser;
import com.chosinhvien.repository.UserRepo;
import com.chosinhvien.service.IRoleService;
import com.chosinhvien.service.IUserService;
import com.chosinhvien.util.CustomException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements IUserService, UserDetailsService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final IRoleService roleService;
    private final IEmailService emailService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(
                    String.format(MessageException.USER_NOT_FOUND, email));
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
        });
        return new MyUser(user.getEmail(), user.getPassword(), user.getId(), user.getName(), authorities);
    }

    @Override
    public List<UserDto> findAll() {
        return userRepo.findAll().stream()
                .map(entity -> modelMapper.map(entity, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Long id) {
        return modelMapper.map(userRepo.findById(id).get(), UserDto.class);
    }

    @Override
    public User findEntityById(Long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public User add(User user) {
        user.setId(0L);
        user.setEnabled(false);
        user.setLocked(false);
        String passwordEncoder = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncoder);
        userRepo.save(user);
        addRoleToUser(user.getEmail(), UserRole.USER.name());
        User newUser = userRepo.findByEmail(user.getEmail());
        return newUser;
    }

    @Override
    public Role saveRole(Role role) {
        return roleService.add(role);
    }

    @Override
    public void addRoleToUser(String email, String roleName) {
        Role role = roleService.findByName(roleName);
        User user = userRepo.findByEmail(email);
        user.getRoles().add(role);
    }

    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }
        return  authentication.getName();
    }

    @Override
    public int enableUser(String email) {
        return userRepo.updateEnable(email);
    }

    @Override
    public boolean exists(String email) {
        User user = userRepo.findByEmail(email);
        if(user != null) return true;
        return false;
    }

    @Override
    public void editName(Long id, String name) {
        User user = userRepo.findById(id).get();
        user.setName(name);
    }

    @Override
    public void editPhone(Long id, String phone) {
        User user = userRepo.findById(id).get();
        user.setPhone(phone);
    }

    @Override
    public void editAddress(Long id, String address) {
        User user = userRepo.findById(id).get();
        user.setAddress(address);
    }

    @Override
    public void setPoint(int point) {
        User user = userRepo.findByEmail(getUsername());
        user.setPoint(user.getPoint() + point);
    }

    @Override
    public void resetPassword(String email) throws CustomException {
        User user = userRepo.findByEmail(email);
        if(user == null) {
            throw new CustomException("User khong ton tai", HttpStatus.BAD_REQUEST);
        }else {
            user.setPassword(bCryptPasswordEncoder.encode("1234"));
            emailService.send(email, "Mật khẩu mới của bạn là: 1234");
        }
    }

}
