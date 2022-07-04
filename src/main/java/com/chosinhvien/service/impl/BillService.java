package com.chosinhvien.service.impl;

import com.chosinhvien.dto.BillDto;
import com.chosinhvien.entity.Bill;
import com.chosinhvien.entity.User;
import com.chosinhvien.repository.BillRepo;
import com.chosinhvien.service.IBillDetailService;
import com.chosinhvien.service.IBillService;
import com.chosinhvien.service.IUserService;
import com.chosinhvien.util.DataMapperUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BillService implements IBillService {

    private final BillRepo orderRepo;
    private final IUserService userService;
    private final DataMapperUtils mapper;
    private final IBillDetailService orderDetailService;
    @Override
    public Bill create(Bill bill) {
        return orderRepo.save(bill);
    }

    @Override
    public List<Bill> findByUserAndIsPay(User user, Boolean isPay) {
        return orderRepo.findByUserAndIsPay(user, isPay);
    }

    @Override
    public List<BillDto> findByUser(Long id) {
        User user = userService.findEntityById(id);
        List<Bill> bills = orderRepo.findAllByUser(user);
        List<BillDto> billsDto = mapper.mapAll(bills, BillDto.class);
        for(BillDto billDto : billsDto) {
            billDto.setBillDetails(orderDetailService.findByBill(billDto.getId()));
        }
        return billsDto;
    }

    @Override
    public Bill findById(Long id) {
        return orderRepo.findById(id).get();
    }
}
