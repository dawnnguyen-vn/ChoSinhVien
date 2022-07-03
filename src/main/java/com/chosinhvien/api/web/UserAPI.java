package com.chosinhvien.api.web;

import com.chosinhvien.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserAPI {

    private final IUserService userService;

    @PutMapping("/{id}/name")
    public void editName(@PathVariable Long id, @RequestParam("name") String name) {
        userService.editName(id, name);
    }

    @PutMapping("/{id}/phone")
    public void editPhone(@PathVariable Long id, @RequestParam("phone") String phone) {
        userService.editPhone(id, phone);
    }

    @PutMapping("/{id}/address")
    public void editAddress(@PathVariable Long id, @RequestParam("address") String address) {
        userService.editAddress(id, address);
    }



}
