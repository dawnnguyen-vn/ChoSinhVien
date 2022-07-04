package com.chosinhvien.repository;

import com.chosinhvien.entity.Bill;
import com.chosinhvien.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillRepo extends JpaRepository<Bill, Long> {
    List<Bill> findByUserAndIsPay(User user, Boolean isPay);
    List<Bill> findAllByUser(User user);
}
