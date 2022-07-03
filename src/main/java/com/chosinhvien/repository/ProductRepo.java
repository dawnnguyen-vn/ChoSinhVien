package com.chosinhvien.repository;

import com.chosinhvien.dto.ProductDto;
import com.chosinhvien.entity.Category;
import com.chosinhvien.entity.Product;
import com.chosinhvien.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long>, CrudRepository<Product, Long> {

    Page<Product> findAllByCategoryOrderByCreatedAtDesc(Category category, Pageable pageable);

    Page<Product> findAllByNameContaining(String name, Pageable pageable);

    Page<Product> findAllByCategoryOrderByPriceDesc(Category category, Pageable pageable);

    Page<Product> findAllByCategoryOrderByPriceAsc(Category category, Pageable pageable);

    int countByCategory(Category category);

    int countByName(String name);

    List<Product> findAllByCategory(Category category);

    List<Product> findAllByUser(User user);
}
