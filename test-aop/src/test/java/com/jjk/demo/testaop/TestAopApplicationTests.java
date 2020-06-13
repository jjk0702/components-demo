package com.jjk.demo.testaop;

import com.jjk.demo.testaop.myAonnation.myLog;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class TestAopApplicationTests {

    @Test
    void contextLoads() {
    }

    @myLog
    public int Add(int a, int b){
        return a+b;
    }

    @Resource
    com.jjk.demo.testaop.TestService.Test test;

    @Test
    public void testAop(){
        System.out.println("======================>" + test.test(1,2));
    }

}
