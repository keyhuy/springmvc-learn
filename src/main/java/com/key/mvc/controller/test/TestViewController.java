package com.key.mvc.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试视图对象控制器
 *
 * @author Key
 * @date 2021/10/09/16:20
 **/
@Controller
public class TestViewController {

    /**
     * 测试ThymeleafView视图对象
     */
    @RequestMapping("/testView01")
    public String showTestView01() {
        return "success";
    }

    /**
     * 测试转发视图
     */
    @RequestMapping("/testView02")
    public String showTestView02() {
        return "forward:/success";
    }

    /**
     * 测试重定向视图
     */
    @RequestMapping("/testView03")
    public String showTestView03() {
        return "redirect:/testView01";
    }

}
