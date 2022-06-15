package com.chosinhvien.controller.web;

import com.chosinhvien.dto.CategoryDto;
import com.chosinhvien.dto.ProductDtoWrite;
import com.chosinhvien.entity.Category;
import com.chosinhvien.service.ICategoryService;
import com.chosinhvien.service.IProductService;
import com.chosinhvien.util.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;
    private final ICategoryService categoryService;

    @GetMapping("/xxx")
    public String x() throws CustomException {
            throw new CustomException("Vui lòng chọn file dung lượng nhỏ", HttpStatus.BAD_REQUEST);
    }

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
