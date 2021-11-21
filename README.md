# springmvc-learn
> 学习视频（尚硅谷）：https://www.bilibili.com/video/BV1Ry4y1574R
## 一、Spring MVC简介

### 1.1 MVC回顾

> PS：详细解释可参见 <u>MVC学习笔记.md</u>

* 概述：MVC 是一种软件架构的思想，将软件分为==模型、视图和控制器==、

* MVC各个组成部分

  1. M --> model 模型：表示工程中的JavaBean，作用是==封装和处理数据==

     > 这里的JavaBean 分为两类
     >
     > 1. 实体类Bean：用于封装和存储业务数据
     > 2. **业务处理Bean**：表示service层对象和dao层对象，用于处理业务逻辑和数据访问

  2. V --> view 视图：表示工程中的html 和jsp等页面。作用是==与用户交互和展示数据==

  3. C --> controller 控制器：表示工程中的servlet，作用是==接受请求和响应浏览器==

### 1.2 Spring MVC是什么？

* 概述：Spring MVC 是Spring 的一个后续产品，是Spring 的子项目，也是Spring 为==表示层==开发提供的一套完备的解决方案

  > 表示层（表述层）：三层架构中其中一层，表示前台页面（html和jsp）和后台servlet，具体可参见 <u>MVC&三层架构学习笔记.md</u>

* 主要特点

  * Spring MVC 是Spring家族原生产品，所以Spring 上的配置（IOC、AOP等）对Spring MVC同样适用
  * 基于原生的servlet，提供功能更强大的==前端控制器==`DispatcherServlet`，==将请求和响应进行统一处理==
  * 代码简洁，提高开发效率
## 二、@RequestMapping注解
## 三、获取请求参数
## 四、使用域对象共享数据（传输数据）
## 五、视图
## 七、RESTFul
## 八、报文信息转换
## 九、文件上传和下载
## 十、拦截器
## 十一、异常处理器
## 十二、注解配置SpringMVC
