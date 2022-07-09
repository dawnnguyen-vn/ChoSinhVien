package com.chosinhvien.controller.admin;

import com.chosinhvien.service.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("HomeControllerForAdmin")
@RequiredArgsConstructor
public class HomeController {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/home")
    public String home(Model model) {

        return "admin/home";
    }

}
