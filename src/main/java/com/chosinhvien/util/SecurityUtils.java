package com.chosinhvien.util;

import com.chosinhvien.model.MyUser;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

    public static MyUser getPrincipal() {
        return (MyUser) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
    }

    public static boolean isUserLoggedIn(){
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof MyUser;
    }

}
