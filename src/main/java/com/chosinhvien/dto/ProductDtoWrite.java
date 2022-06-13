package com.chosinhvien.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductDtoWrite {

    private String name;
    private double price;
    private MultipartFile image;
    private String description;
    private String category;

}
