# Epic-Seven后台管理系统

  最近新学习了SpringBoot的基本用法，可以非常有效快速的搭建项目，再配合IDEA开发工具，写起代码可以说是非常方面了。正好趁热打铁，写了练手项目。
  
  ### 介绍
  这是一个基本的后台管理系统，对数据库进行了简单的CRUD操作，并没有太过复杂的业务流程。
  基本的环境：
  * Spring+SpringMVC+Mybatis
  * 前端：Bootstrap+Thymeleaf模板
  * 简单的Restful风格开发
  * pagehelper分页助手
  * 加入了Druid数据监控
  * 图标插件：amCharts 4
  
  ### 模块说明
  
      src|——
            |——main |——
                    ├── java/com/braisedpanda |——
                                              |——bean               --:javabean
                                              |——config             --:自定义的各种配置类
                                              |——controller         --:controller层
                                              |——mapper             --:mapper借口层
                                              |——service            --:service层
                                              |——serviceimpl        --:service实现层，可以和service放在一起
                                              |——xxxxApplication    --:项目的启动类

                    ├── resource  |——
                                  |——mybatis     --：放置mybatis文件
                                  |——static      --:放置静态资源（图片、js、css之类的）
                                  |——templates   --:themeleaf模板
                                  |——application --：spring配置文件
                
  
  ### 预览
  

![](https://github.com/BraisedPanda/Epic-Seven-Management-System/raw/master/display/2.jpg)<br><br><br>
![](https://github.com/BraisedPanda/Epic-Seven-Management-System/raw/master/display/1.jpg)<br><br><br>
![](https://github.com/BraisedPanda/Epic-Seven-Management-System/raw/master/display/4.jpg)<br><br><br>
![](https://github.com/BraisedPanda/Epic-Seven-Management-System/raw/master/display/5.jpg)<br><br><br>
![](https://github.com/BraisedPanda/Epic-Seven-Management-System/raw/master/display/6.jpg)<br><br><br>
![](https://github.com/BraisedPanda/Epic-Seven-Management-System/raw/master/display/7.jpg)<br><br><br>
![](https://github.com/BraisedPanda/Epic-Seven-Management-System/raw/master/display/8.jpg)<br><br><br>
![](https://github.com/BraisedPanda/Epic-Seven-Management-System/raw/master/display/9.jpg)<br><br><br>

