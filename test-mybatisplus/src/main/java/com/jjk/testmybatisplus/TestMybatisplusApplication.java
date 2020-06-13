package com.jjk.testmybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
* 1、修改自动配置构建工具，比如它的包名，作者，数据库配置，表名，模板等。。。。。
*
* 2、在启动类配置@MapperScan注解
*
* 3、为Mapper包下配置，@Mapper注解
*
* 4、修改application.yml配置文件，修改相关配置
*
* 5、根据 https://mp.baomidou.com/guide/wrapper.html#excludecolumns 可以配置相关参数，进行更新和查找等操作
* */

@SpringBootApplication
@MapperScan("com.jjk.tetmybatisplus.mapper")
public class TestMybatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestMybatisplusApplication.class, args);
    }

}
