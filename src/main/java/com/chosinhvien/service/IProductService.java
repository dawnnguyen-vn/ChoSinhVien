package com.chosinhvien.service;

import com.chosinhvien.dto.ProductDto;
import com.chosinhvien.dto.ProductDtoWrite;
import com.chosinhvien.entity.Category;
import com.chosinhvien.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public interface IProductService {

    Optional<Product> findById(Long id);

    List<ProductDto> findAll(Pageable pageable);

    Page<Product> findAllByName(String name, Pageable pageable);

    Page<Product> findAllByCategoryOrderByCreatedAtDesc(Category category, Pageable pageable);

    Page<Product> findAllByCategoryOrderByPriceDesc(Category category, Pageable pageable);

    Page<Product> findAllByCategoryOrderByPriceAsc(Category category, Pageable pageable);

    int getTotalItem();

    int getTotalItemByName(String name);

    int getTotalItemByCategory(Category category);

    Product save(Product product);

    Product save(ProductDtoWrite product, HttpServletRequest req) throws Exception;
}
