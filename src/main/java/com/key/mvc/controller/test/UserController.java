package com.key.mvc.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户控制器
 *  - 测试四种Http动作：GET、POST、PUT、DELETE
 *
 * @author Key
 * @date 2021/10/11/19:48
 **/
@Controller
public class UserController {

    /**
     * 测试获取全部用户信息 --> GET
     */
    @RequestMapping(
            value = "/user",
            method = RequestMethod.GET
    )
    public String getAllUsers() {
        System.out.println("获取全部用户信息 --> GET");
        return "success";
    }

    /**
     * 测试根据id获取单个用户信息 --> GET
     */
    @RequestMapping(
            value = "/user/{id}",
            method = RequestMethod.GET
    )
    public String getUserById(@PathVariable("id") String id) {
        System.out.println("根据id获取单个用户信息 --> GET");
        System.out.println("用户id -->" + id);
        return "success";
    }

    /**
     * 测试添加用户信息
     */
    @RequestMapping(
            value = "/user",
            method = RequestMethod.POST
    )
    public String addUserInfo(String username, String password) {
        System.out.println("添加用户信息 --> POST");
        System.out.println("新的用户名 --> " + username);
        System.out.println("新密码 --> " + password);
        return "success";
    }

    /**
     * 测试修改用户信息
     */
    @RequestMapping(
            value = "/user",
            method = RequestMethod.PUT
    )
    public String updateUserInfo(String username, String password) {
        System.out.println("修改用户信息 --> PUT");
        System.out.println("用户名 --> " + username);
        System.out.println("密码 --> " + password);
        return "success";
    }

    /**
     * 测试根据id删除用户信息
     */
    @RequestMapping(
            value = "/user/{id}",
            method = RequestMethod.DELETE
    )
    public String deleteUserById(@PathVariable("id") String id) {
        System.out.println("删除用户信息 --> DELETE");
        System.out.println("被删除用户的id --> " + id);
        return "redirect:/success";
    }
}
