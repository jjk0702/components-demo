package com.jjk.demo.testaop.Aspect;

import com.jjk.demo.testaop.myAonnation.myLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/*
 * @创建人： 健健康康
 * @创建时间： 2020/6/13
 * @描述：
 */
@Aspect
@Component
public class LogAspect {
    /**
     * 此处的切点是注解的方式，也可以用包名的方式达到相同的效果
     * '@Pointcut("execution(* com.wwj.springboot.service.impl.*.*(..))")'
     */
    // 通过注解
    @Pointcut("@annotation(com.jjk.demo.testaop.myAonnation.myLog)")
    public void operationLog(){}


    @Around("operationLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object res = null;
        long time = System.currentTimeMillis();
        try {
            res =  joinPoint.proceed();
            time = System.currentTimeMillis() - time;
            return res;
        } finally {
            try {
                //方法执行完成后增加日志
                addOperationLog(joinPoint,res,time);
            }catch (Exception e){
                System.out.println("LogAspect 操作失败：" + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private void addOperationLog(ProceedingJoinPoint joinPoint, Object res, long time) {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        myLog annotation = signature.getMethod().getAnnotation(myLog.class);
        MethodSignature methodSignature =  (MethodSignature)joinPoint.getSignature();   // 表示标注在方法上。。。
        methodSignature.getParameterNames(); // 获取参数名字
        methodSignature.getParameterTypes(); // 获取参数类型
        methodSignature.getMethod();// 获取方法名
        System.out.println("获取参数的个数是" + joinPoint.getArgs().length);        // 获取参数
        joinPoint.getTarget();          // 获取切点所在的类   代理类
        annotation.leave();       // 自定义注解的类型

//        OperationLog operationLog = new OperationLog();
//        operationLog.setRunTime(time);
//        operationLog.setReturnValue(JSON.toJSONString(res));
//        operationLog.setId(UUID.randomUUID().toString());
//        operationLog.setArgs(JSON.toJSONString(joinPoint.getArgs()));
//        operationLog.setCreateTime(new Date());
//        operationLog.setMethod(signature.getDeclaringTypeName() + "." + signature.getName());
//        operationLog.setUserId("#{currentUserId}");
//        operationLog.setUserName("#{currentUserName}");
//        OperationLogDetail annotation = signature.getMethod().getAnnotation(OperationLogDetail.class);
//        if(annotation != null){
//            operationLog.setLevel(annotation.level());
//            operationLog.setDescribe(getDetail(((MethodSignature)joinPoint.getSignature()).getParameterNames(),joinPoint.getArgs(),annotation));
//            operationLog.setOperationType(annotation.operationType().getValue());
//            operationLog.setOperationUnit(annotation.operationUnit().getValue());
//        }
//        //TODO 这里保存日志
//        System.out.println("记录日志:" + operationLog.toString());
//        operationLogService.insert(operationLog);
    }

    @Before("operationLog()")
    public void doBeforeAdvice(JoinPoint joinPoint){
        System.out.println("进入方法前执行.....");

    }
    @AfterReturning(returning = "ret", pointcut = "operationLog()")
    public void doAfterReturning(Object ret) {
        System.out.println("方法的返回值 : " + ret);
    }
    /**
     * 后置异常通知
     */
    @AfterThrowing("operationLog()")
    public void throwss(JoinPoint jp){
        System.out.println("方法异常时执行.....");
    }

    /**
     * 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
     */
    @After("operationLog()")
    public void after(JoinPoint jp){
        System.out.println("方法最后执行.....");
    }
}
