package com.chosinhvien.service.impl;

import com.chosinhvien.dto.ServicePackDto;
import com.chosinhvien.entity.ServicePack;
import com.chosinhvien.repository.ServicePackRepo;
import com.chosinhvien.service.IServicePackService;
import com.chosinhvien.util.DataMapperUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServicePackService implements IServicePackService {

    private final ServicePackRepo servicePackRepo;
    private final DataMapperUtils mapper;

    @Override
    public List<ServicePackDto> findAll() {
        return mapper.mapAll(servicePackRepo.findAll(), ServicePackDto.class);
    }

    @Override
    public ServicePack findById(Long id) {
        return servicePackRepo.findById(id)
                .orElseThrow(() ->
                        new IllegalStateException(
                                String.format("Service pack not found")));

    }

}
