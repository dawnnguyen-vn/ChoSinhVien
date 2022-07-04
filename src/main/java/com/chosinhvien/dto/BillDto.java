package com.chosinhvien.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Data
public class BillDto {
    private Long id;
    private LocalDateTime orderDate;
    private double amount;
    private List<BillDetailDto> billDetails = new ArrayList<>();

    public String timeDisplay() {
        return DateTimeFormatter.ofPattern("dd-MM-yyyy",
                Locale.GERMANY).format(this.orderDate);
    }

}
