package com.chosinhvien.controller.web;

import com.chosinhvien.dto.CategoryDto;
import com.chosinhvien.dto.ProductDto;
import com.chosinhvien.dto.ProductDtoWrite;
import com.chosinhvien.entity.Category;
import com.chosinhvien.entity.Product;
import com.chosinhvien.model.MyUser;
import com.chosinhvien.service.ICategoryService;
import com.chosinhvien.service.IProductService;
import com.chosinhvien.util.CustomException;
import com.chosinhvien.util.DataMapperUtils;
import com.chosinhvien.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;
    private final ICategoryService categoryService;
    private final DataMapperUtils mapper;

    @GetMapping("/tin-dang/{id}")
    public String getProductDetailsPage(@PathVariable Long id, Model model) {
        ProductDto product = mapper.map(productService.findById(id).get(), ProductDto.class);
        List<ProductDto> products = productService.findAllByCategory(product.getCategory());
        if (SecurityUtils.isUserLoggedIn()) {
            MyUser auth = SecurityUtils.getPrincipal();
            model.addAttribute("myUser", auth);
        }
        model.addAttribute("product", product);
        model.addAttribute("products", products);
        return "web/product-details";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/dang-tin")
    public String getDangTinPage(Model model) {
        ProductDtoWrite product = new ProductDtoWrite();
        List<String> categories = new ArrayList<>();
        for(CategoryDto category: categoryService.findAll()) {
            categories.add(category.getName());
        }

        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("product", product);
        return "web/dang-tin";
    }

    @PostMapping("/dang-tin")
    public String post(@ModelAttribute("product") ProductDtoWrite product, HttpServletRequest req, Model model) throws Exception {
        productService.save(product, req);
        System.out.println(3);
        return "web/test";
    }


}
