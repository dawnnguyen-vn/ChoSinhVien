package com.chosinhvien.repository.location;


import com.chosinhvien.entity.location.District;
import com.chosinhvien.entity.location.Province;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictRepo extends JpaRepository<District, Integer> {
    List<District> findAllByProvince(Province province);
}
