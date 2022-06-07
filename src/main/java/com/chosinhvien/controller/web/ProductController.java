package com.chosinhvien.controller.web;

import com.chosinhvien.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ProductController {

    @GetMapping("/dang-tin")
    public String getDangTinPage(Model model) {
        Product product = new Product();
        model.addAttribute("newProduct", product);
        return "web/dang-tin";
    }

    @PostMapping("/dang-tin")
    public String post(@ModelAttribute("product") Product product, Model model) {

        return "web/dang-tin";
    }


}
