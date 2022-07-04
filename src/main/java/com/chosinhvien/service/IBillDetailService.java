package com.chosinhvien.service;

import com.chosinhvien.dto.BillDetailDto;
import com.chosinhvien.entity.BillDetail;

import java.util.List;

public interface IBillDetailService {

    Iterable<BillDetail> saveAll(List<BillDetail> orderDetails);
    List<BillDetailDto> findByBill(Long billId);

}
