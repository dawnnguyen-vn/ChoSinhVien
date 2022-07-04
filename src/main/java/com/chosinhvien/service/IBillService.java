package com.chosinhvien.service;

import com.chosinhvien.dto.BillDto;
import com.chosinhvien.entity.Bill;
import com.chosinhvien.entity.User;

import java.util.List;

public interface IBillService {

    Bill create(Bill bill);

    List<Bill> findByUserAndIsPay(User user, Boolean isPay);

    List<BillDto> findByUser(Long id);

    Bill findById(Long id);
}
