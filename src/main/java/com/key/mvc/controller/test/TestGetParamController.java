package com.key.mvc.controller.test;

import com.key.mvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

/**
 * 测试获取请求参数
 *
 * @author Key
 * @date 2021/10/06/17:24
 **/
@Controller
public class TestGetParamController {

    /**
     * 测试同名形参获取请求参数单个值
     */
    @RequestMapping("/testParam01")
    public String showTestParam01(String username, String password) {
        System.out.println("用户名：" + username);
        System.out.println("密码：" + password);
        return "success";
    }

    /**
     * 测试同名形参获取请求参数多个值
     */
    @RequestMapping("/testParam02")
    public String showTestParam02(String username, String[] hobby) {
        System.out.println("用户名：" + username);
        System.out.println("爱好：" + Arrays.toString(hobby));
        return "success";
    }

    /**
     * 测试@RequestParam注解
     */
    @RequestMapping("/testParam03")
    public String showTestParam03(
            @RequestParam("user_name") String username,
            @RequestParam("password") String pwd) {

        System.out.println("用户名：" + username);
        System.out.println("密码：" + pwd);
        return "success";
    }

    /**
     * 测试实体类类型形参
     */
    @RequestMapping("/testBean")
    public String showTestBean(User user) {
        System.out.println(user);
        return "success";
    }


}
