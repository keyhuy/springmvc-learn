package com.key.mvc.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试异常处理器
 *
 * @author Key
 * @date 2021/10/17/14:57
 **/
@Controller
public class TestExController {

    /**
     * 测试异常处理器
     */
    @RequestMapping("/testEx")
    public String showTestEx() {

        int i = 1/0;
        return "success";
    }
}
