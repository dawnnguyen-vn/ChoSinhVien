package com.chosinhvien.service;

import com.chosinhvien.dto.CategoryDto;
import com.chosinhvien.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<CategoryDto> findAll();
    Category findBySlug(String slug);
}
