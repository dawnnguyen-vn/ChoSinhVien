package com.chosinhvien.repository.location;

import com.chosinhvien.entity.location.District;
import com.chosinhvien.entity.location.Province;
import com.chosinhvien.entity.location.Ward;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WardRepo extends JpaRepository<Ward, Integer> {
    List<Ward> findAllByProvinceAndDistrict(Province province, District district);
}
