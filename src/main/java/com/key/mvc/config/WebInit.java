package com.key.mvc.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * 初始化类
 *  - 代替web.xml文件
 *
 * @author Key
 * @date 2021/10/17/18:52
 **/
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 指定Spring配置类
     * @return 返回Class数组，数组元素为配置类的class对象
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    /**
     * 指定Spring MVC配置类
     * @return 返回Class数组，数组元素为配置类的class对象
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    /**
     * 指定DispatcherServlet的映射规则，即资源路径
     * @return 返回资源路径的字符串数组
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 配置过滤器
     * @return 返回过滤器数组
     */
    @Override
    protected Filter[] getServletFilters() {
        // 1. 创建字符集过滤器CharacterEncodingFilter
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        // 1.1 设置encoding属性为utf-8
        encodingFilter.setEncoding("utf-8");

        // 2. 创建请求方式过滤器
        HiddenHttpMethodFilter httpMethodFilter = new HiddenHttpMethodFilter();

        // 3. 创建过滤器数组并返回
        return new Filter[]{encodingFilter, httpMethodFilter};
    }
}
