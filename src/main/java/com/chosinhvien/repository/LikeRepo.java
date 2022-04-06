package com.chosinhvien.repository;

import com.chosinhvien.entity.Like;
import com.chosinhvien.entity.Product;
import com.chosinhvien.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface LikeRepo extends CrudRepository<Like, Long> {
    Like findByUserAndProductLiked(User user, Product productLiked);
}
