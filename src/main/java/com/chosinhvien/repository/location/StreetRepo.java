package com.chosinhvien.repository.location;

import com.chosinhvien.entity.location.District;
import com.chosinhvien.entity.location.Province;
import com.chosinhvien.entity.location.Street;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StreetRepo extends JpaRepository<Street, Integer> {

    List<Street> findAllByProvinceAndDistrict(Province province, District district);

}
