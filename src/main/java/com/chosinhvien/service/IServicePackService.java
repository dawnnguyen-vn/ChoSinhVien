package com.chosinhvien.service;

import com.chosinhvien.dto.ServicePackDto;
import com.chosinhvien.entity.ServicePack;

import java.util.List;
import java.util.Optional;

public interface IServicePackService {

    List<ServicePackDto> findAll();

    ServicePack findById(Long id);
}
