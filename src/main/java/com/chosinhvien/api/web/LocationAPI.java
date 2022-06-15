package com.chosinhvien.api.web;

import com.chosinhvien.entity.location.District;
import com.chosinhvien.entity.location.Province;
import com.chosinhvien.entity.location.Ward;
import com.chosinhvien.service.ILocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/location")
@RequiredArgsConstructor
public class LocationAPI {

    private final ILocationService locationService;

    @GetMapping("/province")
    public ResponseEntity<List<Province>> getProvinces(){
        return ResponseEntity.ok(locationService.findAllProvince());
    }

    @GetMapping("/ward/{id}")
    public ResponseEntity<Ward> getWard(@PathVariable int id){
        return ResponseEntity.ok(locationService.findWardById(id));
    }

    @GetMapping("/province/{provinceId}/district")
    public ResponseEntity<List<District>> getDistricts(@PathVariable int provinceId){
        Province province = locationService.findProvinceById(provinceId);
        return ResponseEntity.ok(locationService.findAllDistrict(province));
    }

    @GetMapping("/province/{provinceId}/district/{districtId}/ward")
    public ResponseEntity<List<Ward>> getWards(@PathVariable int provinceId,
                                               @PathVariable int districtId){
        Province province = locationService.findProvinceById(provinceId);
        District district = locationService.findDistrictById(districtId);
        return ResponseEntity.ok(locationService.findAllWard(province, district));
    }

}
