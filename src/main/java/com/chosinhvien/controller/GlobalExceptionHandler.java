package com.chosinhvien.controller;

import com.chosinhvien.util.CustomException;
import com.chosinhvien.util.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@ControllerAdvice
public class GlobalExceptionHandler {
    // handle custom exception
    @ExceptionHandler(CustomException.class)
    private ModelAndView customException(CustomException exception){
        Message message = new Message(new Date(), "Validation Error", exception.getMessage());
        ModelAndView model = new ModelAndView("error");
        model.addObject("message", message);
        return model;
    }

}
