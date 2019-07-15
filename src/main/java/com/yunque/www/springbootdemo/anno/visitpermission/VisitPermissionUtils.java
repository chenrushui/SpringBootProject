package com.yunque.www.springbootdemo.anno.visitpermission;

import com.yunque.www.springbootdemo.exceptions.PicaException;
import com.yunque.www.springbootdemo.exceptions.PicaResultCode;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class VisitPermissionUtils {

    private long viewedHospitalId;

    @Pointcut("execution(* com.yunque.www.springbootdemo.service.serviceimpl.UserServiceImpl.*(..))")
    public void visitPermission() {
    }

    @Before("visitPermission()")
    public void beforeAction(JoinPoint joinPoint) {
        long hospital_id=111111;
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            //获取第一个参数对象
            viewedHospitalId = (long) args[0];
        }
        if (viewedHospitalId!=hospital_id){
            //如何进行返回:直接抛出一个异常即可。
            throw new PicaException(PicaResultCode.INTERFACE_INVOKE_EXCEPTION);
        }
    }
}
