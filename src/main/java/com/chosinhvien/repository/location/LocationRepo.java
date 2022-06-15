package com.chosinhvien.repository.location;

import com.chosinhvien.entity.location.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepo extends JpaRepository<Location, Long> {
    List<Location> findAllByProvinceId(int provinceId);
}
