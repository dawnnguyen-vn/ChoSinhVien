package com.chosinhvien.api.web;

import com.chosinhvien.service.impl.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/home")
@RequiredArgsConstructor
public class HomeAPI {

    private final LikeService likeService;

    @PostMapping("/luu-tin")
    public void saveProduct(@RequestBody Long id) {
        likeService.modifyUserLiked(id);
    }


}
