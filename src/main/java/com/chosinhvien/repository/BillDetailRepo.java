package com.chosinhvien.repository;

import com.chosinhvien.entity.Bill;
import com.chosinhvien.entity.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillDetailRepo extends JpaRepository<BillDetail, Long> {
    List<BillDetail> findAllByBill(Bill bill);
}
