package com.chosinhvien.entity.location;

import com.chosinhvien.entity.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_Location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "_provinceId")
    private int provinceId;

    @Column(name = "_districtId")
    private int districtId;

    @Column(name = "_wardId")
    private int wardId;

    @Column(name = "_specification")
    private String specification;

    @OneToOne(mappedBy = "location")
    private Product product;

}
