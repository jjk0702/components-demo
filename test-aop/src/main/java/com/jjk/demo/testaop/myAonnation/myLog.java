package com.jjk.demo.testaop.myAonnation;

import java.lang.annotation.*;

/*
 * @创建人： 健健康康
 * @创建时间： 2020/6/13
 * @描述：
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface myLog {
    String value() default "info";

    int leave() default 0;
}
