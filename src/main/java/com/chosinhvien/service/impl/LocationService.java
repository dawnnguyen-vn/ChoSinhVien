package com.chosinhvien.service.impl;

import com.chosinhvien.entity.location.*;
import com.chosinhvien.repository.location.*;
import com.chosinhvien.service.ILocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService implements ILocationService {

    private final ProvinceRepo provinceRepo;
    private final DistrictRepo districtRepo;
    private final WardRepo wardRepo;
    private final StreetRepo streetRepo;
    private final LocationRepo locationRepo;

    @Override
    public Province findProvinceById(int provinceId) {
        return provinceRepo.findById(provinceId).get();
    }

    @Override
    public District findDistrictById(int districtId) {
        return districtRepo.findById(districtId).get();
    }

    @Override
    public Ward findWardById(int wardId) {
        return wardRepo.findById(wardId).get();
    }

    @Override
    public List<Province> findAllProvince() {
        return provinceRepo.findAll();
    }

    @Override
    public List<District> findAllDistrict(Province province) {
        return districtRepo.findAllByProvince(province);
    }

    @Override
    public List<Ward> findAllWard(Province province, District district) {
        return wardRepo.findAllByProvinceAndDistrict(province, district);
    }

    @Override
    public List<Street> findAllStreet(Province province, District district) {
        return streetRepo.findAllByProvinceAndDistrict(province, district);
    }

    @Override
    public List<Location> findAllByLocationId(int provinceId) {
        return locationRepo.findAllByProvinceId(provinceId);
    }
}
