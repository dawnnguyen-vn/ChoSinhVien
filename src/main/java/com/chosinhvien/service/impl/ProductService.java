package com.chosinhvien.service.impl;

import com.chosinhvien.dto.ProductDto;
import com.chosinhvien.dto.ProductDtoWrite;
import com.chosinhvien.entity.Category;
import com.chosinhvien.entity.Image;
import com.chosinhvien.entity.Product;
import com.chosinhvien.entity.location.Location;
import com.chosinhvien.repository.ProductRepo;
import com.chosinhvien.service.ICategoryService;
import com.chosinhvien.service.IProductService;
import com.chosinhvien.service.IUserService;
import com.chosinhvien.util.DataMapperUtils;
import com.chosinhvien.util.FileHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepo productRepo;
    private final DataMapperUtils mapper;
    private final FileHandler fileHandler;
    private final ICategoryService categoryService;
    private final IUserService userService;

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

    @Override
    public Product save(ProductDtoWrite product, HttpServletRequest req) throws Exception {
        Product entity = new Product();
        entity.setName(product.getName());
        entity.setPrice(product.getPrice());
        List<String> imageNames = fileHandler.upload(product.getImage(), req);
        imageNames.forEach(image -> entity.addImage(new Image(0L, image, null)));
        entity.setDescription(product.getDescription());
        entity.setCreatedAt(LocalDateTime.now());
        Category category = categoryService.findBySlug(product.getCategory());
        entity.setCategory(category);
        String[] ls = product.getLocation().split(",");
        Location location = new Location(0L, Integer.parseInt(ls[3]), Integer.parseInt(ls[2]), Integer.parseInt(ls[1]), ls[0], null);
        entity.setLocation(location);
        entity.setUser(userService.findByEmail(userService.getUsername()));
        productRepo.save(entity);
        return null;
    }
}
