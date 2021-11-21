package com.key.mvc.controller.test;

import com.key.mvc.entity.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 测试报文信息转换
 *
 * @author Key
 * @date 2021/10/12/19:55
 **/
@Controller
public class TestHttpMsgController {

    /**
     * 测试原生servletAPI获取请求报文信息
     */
    @RequestMapping("/testReqMsg01")
    public String showTestReqMsg01(HttpServletRequest req) throws IOException {
        // 获取请求头信息
        System.out.println("请求头Host的信息 --> " + req.getHeader("Host"));
        return "success";
    }

    /**
     * 测试@RequestBody注解
     */
    @RequestMapping("/testReqMsg02")
    public String showTestReqMsg02(@RequestBody String reqBody) {
        System.out.println("请求体信息 -->" + reqBody);

        return "success";
    }

    /**
     * 测试RequestEntity类型
     */
    @RequestMapping("/testReqMsg03")
    public String showTestReqMsg03(RequestEntity<String> reqEntity) {
        // 获取请求头信息
        System.out.println("全部请求头信息 -->" + reqEntity.getHeaders());

        // 获取请求体信息
        System.out.println("请求体信息 --> " + reqEntity.getBody());
        return "success";
    }

    /**
     * 测试原生servletAPI设置响应报文信息
     */
    @RequestMapping("/testRespMsg01")
    public void showTestRespMsg01(HttpServletResponse resp) throws IOException {
        // 设置响应体的编码方式
        resp.setContentType("text/html;charset=utf-8");

        // 设置响应体信息，将信息打印到页面
        resp.getWriter().print("测试原生servletAPI设置响应报文信息成功！");
    }

    /**
     * 测试@ResponseBody注解
     */
    @RequestMapping(
            value = "/testRespMsg02",
            produces = "text/html;charset=utf-8"
    )
    @ResponseBody
    public String showTestRespMsg02() {
        return "测试@ResponseBody注解成功！";
    }

    /**
     * 测试处理JSON数据-将Java对象转换成JSON格式字符串，并打印到页面
     */
    @RequestMapping("/testJson")
    @ResponseBody
    public User showTestJson() {
        return new User(1, "王小明", "男", 35);
    }

    /**
     * 测试处理Ajax数据
     */
    @RequestMapping("/testAjax")
    @ResponseBody
    public String showTestAjax(String username, String pwd) {
        System.out.println("用户名 --> " + username);
        System.out.println("密码 --> " + pwd);
        return "测试处理Ajax数据成功！";
    }
}
