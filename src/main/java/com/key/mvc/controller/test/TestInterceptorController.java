package com.key.mvc.controller.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试拦截器对应的控制器
 *
 * @author Key
 * @date 2021/10/14/16:29
 **/
@RestController
public class TestInterceptorController {

    /**
     * 测试拦截器
     */
    @RequestMapping("/**/testInterceptor")
    public String showTestInterceptor() {
        System.out.println("②执行控制器方法 --> showTestInterceptor()");
        return "success";
    }
}
