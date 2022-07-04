package com.chosinhvien.service.impl;

import com.chosinhvien.dto.BillDetailDto;
import com.chosinhvien.dto.ServicePackDto;
import com.chosinhvien.entity.Bill;
import com.chosinhvien.entity.BillDetail;
import com.chosinhvien.repository.BillDetailRepo;
import com.chosinhvien.repository.BillRepo;
import com.chosinhvien.service.IBillDetailService;
import com.chosinhvien.service.IBillService;
import com.chosinhvien.util.DataMapperUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BillDetailService implements IBillDetailService {

    private final BillDetailRepo orderDetailRepo;
    private final BillRepo billService;
    private final DataMapperUtils mapper;
    @Override
    public Iterable<BillDetail> saveAll(List<BillDetail> billDetails) {
        return orderDetailRepo.saveAll(billDetails);
    }

    @Override
    public List<BillDetailDto> findByBill(Long billId) {
        Bill bill = billService.findById(billId).get();
        List<BillDetail> billDetails = orderDetailRepo.findAllByBill(bill);
        List<BillDetailDto> billDetailsDto = new ArrayList<>();
        for(BillDetail billDetail: billDetails) {
            BillDetailDto billDetailDto = new BillDetailDto();
            billDetailDto.setQuantity(billDetail.getQuantity());
            billDetailDto.setServicePackDto(mapper.map(billDetail.getServicePack(), ServicePackDto.class));
            billDetailsDto.add(billDetailDto);
        }
        return billDetailsDto;
    }

}
