package com.jjk.demo.testaop.TestService;

import com.jjk.demo.testaop.myAonnation.myLog;
import org.springframework.stereotype.Service;

/*
 * @创建人： 健健康康
 * @创建时间： 2020/6/13
 * @描述：
 */
@Service
public class Test {

    @myLog
    public int  test(int a, int b){
        return a+b;
    }
}
