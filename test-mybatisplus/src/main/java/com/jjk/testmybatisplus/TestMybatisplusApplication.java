package com.jjk.testmybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jjk.tetmybatisplus.mapper")
public class TestMybatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestMybatisplusApplication.class, args);
    }

}
