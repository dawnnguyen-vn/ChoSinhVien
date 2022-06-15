package com.chosinhvien.entity.location;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_Street")
public class Street {

    @Id
    private int id;

    @Column(name = "_name", length = 50, nullable = false)
    private String name;

    @Column(name = "_prefix", length = 20, nullable = false)
    private String prefix;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "_province_id")
    private Province province;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "_district_id")
    private District district;

}
