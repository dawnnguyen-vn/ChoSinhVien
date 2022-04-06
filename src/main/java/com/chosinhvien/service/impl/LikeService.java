package com.chosinhvien.service.impl;

import com.chosinhvien.entity.Like;
import com.chosinhvien.entity.Product;
import com.chosinhvien.entity.User;
import com.chosinhvien.repository.LikeRepo;
import com.chosinhvien.service.ILikeService;
import com.chosinhvien.service.IProductService;
import com.chosinhvien.service.IUserService;
import com.chosinhvien.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class LikeService implements ILikeService {

    private final IProductService productService;
    private final IUserService userService;
    private final LikeRepo likeRepo;

    @Override
    public void modifyUserLiked(Long productId) {
        Product product = productService.findById(productId).get();
        User user = userService.findByEmail(SecurityUtils.getPrincipal().getUsername());
        if (product == null || user == null) {
            throw new IllegalStateException("User or Product not found!");
        } else {
            Like oldLike = likeRepo.findByUserAndProductLiked(user, product);
            if (oldLike == null) {
                Like newLike = new Like(0L, user, product);
                likeRepo.save(newLike);
            } else {
                likeRepo.delete(oldLike);
            }
        }

    }

}
