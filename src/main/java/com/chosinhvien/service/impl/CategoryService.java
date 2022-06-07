package com.chosinhvien.service.impl;

import com.chosinhvien.dto.CategoryDto;
import com.chosinhvien.entity.Category;
import com.chosinhvien.repository.CategoryRepo;
import com.chosinhvien.service.ICategoryService;
import com.chosinhvien.util.DataMapperUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    private final CategoryRepo categoryRepo;
    private final DataMapperUtils mapper;

    @Override
    public List<CategoryDto> findAll() {
        return mapper.mapAll(categoryRepo.findAll(), CategoryDto.class) ;
    }

    @Override
    public Category findBySlug(String slug) {
        return categoryRepo.findBySlug(slug);
    }
}
