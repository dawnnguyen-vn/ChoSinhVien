package com.chosinhvien.service;


import com.chosinhvien.entity.location.*;

import java.util.List;

public interface ILocationService {
    Province findProvinceById(int provinceId);

    District findDistrictById(int districtId);

    Ward findWardById(int wardId);

    List<Province> findAllProvince();

    List<District> findAllDistrict(Province province);

    List<Ward> findAllWard(Province province, District district);

    List<Street> findAllStreet(Province province, District district);

    List<Location> findAllByLocationId(int provinceId);
}
