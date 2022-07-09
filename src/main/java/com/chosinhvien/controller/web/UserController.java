package com.chosinhvien.controller.web;

import com.chosinhvien.dto.BillDto;
import com.chosinhvien.dto.ProductDto;
import com.chosinhvien.dto.UserDto;
import com.chosinhvien.dto.UserDtoRead;
import com.chosinhvien.entity.Like;
import com.chosinhvien.entity.User;
import com.chosinhvien.model.MyUser;
import com.chosinhvien.service.IBillService;
import com.chosinhvien.service.IProductService;
import com.chosinhvien.service.IRegistrationService;
import com.chosinhvien.service.IUserService;
import com.chosinhvien.util.CustomException;
import com.chosinhvien.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final IRegistrationService registrationService;
    private final ModelMapper mapper;
    private final IUserService userService;
    private final IProductService productService;
    private final IBillService billService;

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "login";
    }


    @GetMapping("/profile")
    public String getProfilePage(Model model) {


        if (SecurityUtils.isUserLoggedIn()) {
            MyUser auth = SecurityUtils.getPrincipal();
            UserDtoRead userDto = mapper.map(userService.findByEmail(userService.getUsername()), UserDtoRead.class);
            int count = productService.findAllByUser(auth.getId()).size();
            model.addAttribute("myUser", auth);
            model.addAttribute("count", count);
            model.addAttribute("user", userDto);
        }

        return "/web/profile";
    }

    @GetMapping("/history")
    public String getHistoryPage(Model model) {
        if (SecurityUtils.isUserLoggedIn()) {
            MyUser auth = SecurityUtils.getPrincipal();
            model.addAttribute("myUser", auth);
            List<BillDto> bills = billService.findByUser(auth.getId());
            model.addAttribute("bills", bills);
        }

        return "/web/history";
    }

    @GetMapping("/likes")
    public String getLikesPage(Model model) {
        if (SecurityUtils.isUserLoggedIn()) {
            MyUser auth = SecurityUtils.getPrincipal();
            model.addAttribute("myUser", auth);
            List<ProductDto> products = productService.findAll();
            List<ProductDto> productsLiked = new ArrayList<>();
            for (ProductDto product : products) {
                for (Like like : product.getLikes()) {
                    if (like.getUser().getId().equals(auth.getId())) {
                        productsLiked.add(product);
                    }
                }
            }
            model.addAttribute("products", productsLiked);
        }
        return "/web/tin-luu";
    }


    @GetMapping("/shop/{id}")
    public String getShopPage(@PathVariable Long id, Model model) {
        UserDto userDto = userService.findById(id);
        List<ProductDto> products = productService.findAllByUser(id);
        if (SecurityUtils.isUserLoggedIn()) {
            MyUser auth = SecurityUtils.getPrincipal();
            model.addAttribute("myUser", auth);
        }
        model.addAttribute("shop", userDto);
        model.addAttribute("products", products);
        return "/web/shop";
    }

    @PostMapping("/signup")
    public String register(@ModelAttribute("user") UserDto userDto, Model model) {
        User user = mapper.map(userDto, User.class);
        User newUser = registrationService.register(user);
        UserDtoRead read = mapper.map(newUser, UserDtoRead.class);
        return "web/dkthanhcong";
    }

    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam("email") String email) throws CustomException {
        userService.resetPassword(email);
        return "web/test";
    }

    @GetMapping("/signup/confirm")
    public String confirm(@RequestParam("token") String token, Model model) {
        String confirmed = registrationService.confirmToken(token);
        model.addAttribute("confirmed", confirmed);
        return "web/kichhoat";
    }

}
