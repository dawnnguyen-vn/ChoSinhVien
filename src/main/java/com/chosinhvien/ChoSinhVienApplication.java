package com.chosinhvien;

import com.chosinhvien.constant.UserRole;
import com.chosinhvien.entity.Role;
import com.chosinhvien.entity.User;
import com.chosinhvien.service.IUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ChoSinhVienApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChoSinhVienApplication.class, args);
    }

}
