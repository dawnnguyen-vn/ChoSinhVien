package com.chosinhvien.repository;

import com.chosinhvien.entity.Category;
import com.chosinhvien.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends JpaRepository<Product, Long>, CrudRepository<Product, Long> {

    Page<Product> findAllByCategoryOrderByCreatedAtDesc(Category category, Pageable pageable);

    Page<Product> findAllByNameContaining(String name, Pageable pageable);

    Page<Product> findAllByCategoryOrderByPriceDesc(Category category, Pageable pageable);

    Page<Product> findAllByCategoryOrderByPriceAsc(Category category, Pageable pageable);

    int countByCategory(Category category);

    int countByName(String name);
}
