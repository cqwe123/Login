# Login
基于springboot的一个登录逻辑（写这个主要是一些基本技术的巩固学习）
基本技术：拦截器，Validation验证参数，正则表达式，JWT技术，mybatis，lombok小工具， 响应数据类Result（属于规范开发）
基本思路： 
    所有的请求都需要在完成登录后才能进行，否则跳转到登录页面。这个机制用JWT--Token令牌实现，并且在拦截器中实现。
