package com.key.mvc.controller.exResovler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 注解配置异常处理器
 *
 * @author Key
 * @date 2021/10/17/15:49
 **/
@ControllerAdvice
public class ExceptionController {

    /**
     * 处理异常的方法
     */
    @ExceptionHandler(
            value = {ArithmeticException.class, NullPointerException.class}
    )
    public String showExPage(Exception ex, Model model) {
        // 将异常对象存储到request域中
        model.addAttribute("ex", ex);

        return "error";
    }
}
