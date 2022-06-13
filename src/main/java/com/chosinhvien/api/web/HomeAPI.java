package com.chosinhvien.api.web;

import com.chosinhvien.service.ILikeService;
import com.chosinhvien.service.IUserService;
import com.chosinhvien.service.impl.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/home")
@RequiredArgsConstructor
public class HomeAPI {

    private final ILikeService likeService;
    private final IUserService userService;

    @PostMapping("/luu-tin")
    public void saveProduct(@RequestBody Long id) {
        likeService.modifyUserLiked(id);
    }


    @GetMapping("/check/{email}")
    public ResponseEntity<Boolean> checkEmail(@PathVariable String email){
        return ResponseEntity.ok(userService.exists(email+"@gmail.com"));
    }


}
