package com.key.mvc.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 测试@RequestMapping注解
 *
 * @author Key
 * @date 2021/10/05/11:35
 **/
@Controller
// @RequestMapping("/test")
public class TestReqMapController {

    @RequestMapping("/success")
    public String showSuccess() {
        return "success";
    }

    /**
     * 测试method属性
     */
    @RequestMapping(
            value = "/testMethod",
            method = {RequestMethod.GET, RequestMethod.POST}
    )
    public String showTestMethod() {
        return "success";
    }

    /**
     * 测试派生注解使用
     */
    @GetMapping("/testGet")
    public String showGet() {
        return "success";
    }

    /**
     * 测试params属性
     */
    @RequestMapping(
            value = "/testParams",
            params = {"username", "password=123"}
    )
    public String showTestParams() {
        return "success";
    }

    /**
     * 测试Ant风格的路径书写
     */
    @RequestMapping("/**/testAnt")
    public String showTestAnt() {
        return "success";
    }

    /**
     * 测试rest方式路径中的占位符
     */
    @RequestMapping("/testRest/{id}/{username}")
    public String showTestRest(@PathVariable("id") Integer id,
                               @PathVariable("username") String username) {
        System.out.println("id：" + id);
        System.out.println("username：" + username);

        return "success";
    }
}
