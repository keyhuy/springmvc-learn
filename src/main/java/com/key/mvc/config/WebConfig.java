package com.key.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;


/**
 * Spring MVC配置类
 *  - 代替springmvc.xml文件
 *
 * @author Key
 * @date 2021/10/18/18:18
 **/
@Configuration
@ComponentScan(basePackages = "com.key.mvc")
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    /**
     * 1. 开放对静态资源的访问（配置默认servlet）
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /* 2. 配置thymeleaf视图解析器 */

    /**
     * 2.1 配置模板解析器
     */
    @Bean
    public ITemplateResolver templateResolver() {
        WebApplicationContext webApplicationContext =
                ContextLoader.getCurrentWebApplicationContext();
        /*
            ServletContextTemplateResolver需要一个ServletContext作为构造参数，
            可通过WebApplicationContext的方法获得
        */
        ServletContextTemplateResolver templateResolver =
                new ServletContextTemplateResolver(webApplicationContext.getServletContext());

        // 设置视图前缀
        templateResolver.setPrefix("/WEB-INF/templates/");
        // 设置视图后缀
        templateResolver.setSuffix(".html");
        // 设置编码方式
        templateResolver.setCharacterEncoding("UTF-8");
        // 设置模板
        templateResolver.setTemplateMode(TemplateMode.HTML);
        return templateResolver;
    }

    /**
     * 2.2 配置模板引擎，并为模板引擎注入模板解析器属性
     */
    @Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }

    /**
     * 2.3 配置thymeleaf视图解析器，并为解析器注入模板引擎属性
     */
    @Bean
    public ViewResolver getThymeleafView(SpringTemplateEngine templateEngine) {
        // 先创建一个thymeleaf视图解析器对象
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();

        // 设置编码方式
        viewResolver.setCharacterEncoding("utf-8");

        // 注入模板引擎属性
        viewResolver.setTemplateEngine(templateEngine);

        return viewResolver;
    }

    /**
     * 3. 配置拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
/*        // 创建拦截器对象
        TestInterceptor testInterceptor = new TestInterceptor();

        // 添加拦截器对象，并设置拦截路径
        registry.addInterceptor(testInterceptor).addPathPatterns("/**");*/
    }


    /**
     * 5. 配置视图控制器
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 首页
        registry.addViewController("/").setViewName("index");
        // 用户测试页面
        registry.addViewController("/testUser").setViewName("test-user");
        // 测试成功页面
        registry.addViewController("/success").setViewName("success");
        // 测试报文信息转换页面
        registry.addViewController("/testHttpMsg").setViewName("test-httpMsg");
        // 文件上传和下载页面
        registry.addViewController("/fileUpAndDown").setViewName("file-upAndDown");
    }

    /**
     * 6. 配置文件上传解析器，解析器的bean-id（@Bean中的value属性值）必须设置为multipartResolver
     *  - 前提是需要导入文件上传解析器的jar包
     */
    @Bean("multipartResolver")
    public CommonsMultipartResolver getMultipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();

        // 设置编码方法
        multipartResolver.setDefaultEncoding("utf-8");
        return multipartResolver;
    }
}
