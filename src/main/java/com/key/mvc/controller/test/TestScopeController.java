package com.key.mvc.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 测试使用域对象
 *
 * @author Key
 * @date 2021/10/07/16:31
 **/
@Controller
public class TestScopeController {

    /**
     * 测试servlet API向request域中存储数据
     */
    @RequestMapping("/testScope01")
    public String showTestScope01(HttpServletRequest req) {
        // 直接存储数据
        req.setAttribute("testData", "hello,servlet API！");

        return "test-scope";
    }

    /**
     * 测试ModelAndView向request域中存储数据
     */
    @RequestMapping("/testScope02")
    public ModelAndView showTestScope02() {
        // 先创建一个modelAndView对象
        ModelAndView mav = new ModelAndView();

        // 向request域中存储数据
        mav.addObject("testData", "hello,ModelAndView!");

        // 设置视图名
        mav.setViewName("test-scope");

        // 最后返回对象
        return mav;
    }

    /**
     * 测试Model向request域中存储数据
     */
    @RequestMapping("/testScope03")
    public String showTestScope03(Model model) {
        // 向request域中存储数据
        model.addAttribute("testData", "hello,Model!");

        System.out.println("model对象 -->" + model);
        System.out.println("实例化model的类 --> " + model.getClass().getName());
        return "test-scope";
    }

    /**
     * 测试ModelMap向request域中存储数据
     */
    @RequestMapping("/testScope04")
    public String showTestScope04(ModelMap modelMap) {
        // 向request域中存储数据
        modelMap.addAttribute("testData", "hello,ModelMap!");

        System.out.println("modelMap对象 --> " + modelMap);
        System.out.println("实例化modelMap的类 --> " + modelMap.getClass().getName());
        return "test-scope";
    }

    /**
     * 测试Map向request域中存储数据
     */
    @RequestMapping("/testScope05")
    public String showTestScope05(Map<String, Object> scopeMap) {
        // 直接往map集合中存储数据
        scopeMap.put("testData", "hello,Map!");

        System.out.println("Map集合对象 --> " + scopeMap);
        System.out.println("实例化Map集合的类 --> " + scopeMap.getClass().getName());
        return "test-scope";
    }

    /**
     * 测试session域中共享数据
     */
    @RequestMapping("/testSession")
    public String showTestSession(HttpSession session) {
        // 直接使用session对象调用方法，往session域中存储数据
        session.setAttribute("testSessionData", "hello，session！");

        return "test-scope";
    }

    /**
     * 测试application域中共享数据
     */
    @RequestMapping("/testApplication")
    public String showTestApplication(HttpSession session) {
        // 直接使用session对象获取servletContext对象
        ServletContext servletContext = session.getServletContext();

        // 根据servletContext对象往application域中存储数据
        servletContext.setAttribute("testApplicationData", "hello，application！");

        return "test-scope";
    }
}
