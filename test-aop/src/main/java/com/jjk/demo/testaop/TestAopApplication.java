package com.jjk.demo.testaop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/*
*
* 1、建议查看Service，可以进一步改进行，暂时就进行到这，可以用于日常鉴权，日志。。。。。等处理
*
* 2、建议查看开源框架，看看别人是如何写的
* */
@SpringBootApplication
@EnableAspectJAutoProxy
public class TestAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestAopApplication.class, args);
    }

}
