package com.chosinhvien.entity;

import com.chosinhvien.entity.location.Location;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Image> images = new ArrayList<>();

    @OneToMany(mappedBy = "productLiked")
    private List<Like> likes = new ArrayList<>();

    private String description;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(
            name = "category_id",
            nullable = false
    )
    private Category category;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    private User user;

    public void addImage(Image image) {
        images.add(image);
        image.setProduct(this);
    }

    public void removeImage(Image image) {
        images.remove(image);
        image.setProduct(null);
    }

}
