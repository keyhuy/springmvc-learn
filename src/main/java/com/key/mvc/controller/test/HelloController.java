package com.key.mvc.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * HelloWord控制器测试
 *
 * @author Key
 * @date 2021/09/30/19:18
 **/
@Controller
public class HelloController {

    /**
     * 跳转到目标页面
     * @return 返回页面名
     */
    @RequestMapping("/target")
    public String toTarget() {
        return "target";
    }
}
