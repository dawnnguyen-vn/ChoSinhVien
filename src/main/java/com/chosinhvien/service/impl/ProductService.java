package com.chosinhvien.service.impl;

import com.chosinhvien.dto.ProductDto;
import com.chosinhvien.entity.Category;
import com.chosinhvien.entity.Product;
import com.chosinhvien.repository.ProductRepo;
import com.chosinhvien.service.IProductService;
import com.chosinhvien.util.DataMapperUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepo productRepo;
    private final DataMapperUtils mapper;

    @Override
    public Optional<Product> findById(Long id) {
        return productRepo.findById(id);
    }

    @Override
    public List<ProductDto> findAll(Pageable pageable) {
        List<Product> products = productRepo.findAll(pageable).getContent();
        return mapper.mapAll(products, ProductDto.class);
    }

    @Override
    public Page<Product> findAllByName(String name, Pageable pageable) {
        return productRepo.findAllByNameContaining(name, pageable);
    }

    @Override
    public Page<Product> findAllByCategoryOrderByCreatedAtDesc(Category category, Pageable pageable) {
        return productRepo.findAllByCategoryOrderByCreatedAtDesc(category, pageable);
    }

    @Override
    public Page<Product> findAllByCategoryOrderByPriceDesc(Category category, Pageable pageable) {
        return productRepo.findAllByCategoryOrderByPriceDesc(category, pageable);
    }

    @Override
    public Page<Product> findAllByCategoryOrderByPriceAsc(Category category, Pageable pageable) {
        return productRepo.findAllByCategoryOrderByPriceAsc(category, pageable);
    }


    @Override
    public int getTotalItem() {
        return (int) productRepo.count();
    }

    @Override
    public int getTotalItemByName(String name) {
        return productRepo.countByName(name);
    }

    @Override
    public int getTotalItemByCategory(Category category) {
        return productRepo.countByCategory(category);
    }

    @Override
    public Product save(Product product) {
        return productRepo.save(product);
    }
}
