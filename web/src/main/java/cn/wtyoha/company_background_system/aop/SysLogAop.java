package cn.wtyoha.company_background_system.aop;

import cn.wtyoha.company_background_system.controller.SysLogController;
import cn.wtyoha.company_background_system.domain.SysLog;
import cn.wtyoha.company_background_system.domain.User;
import cn.wtyoha.company_background_system.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;

@Component
@Aspect
public class SysLogAop {
    @Autowired
    HttpServletRequest request;

    @Autowired
    @Qualifier("sysLogServiceImpl")
    SysLogService sysLogService;

    Date stratTime;
    Class executeClass;
    Method executeMethod;

    @Before("execution(* cn.wtyoha.company_background_system.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        stratTime = new Date();
        executeClass = jp.getTarget().getClass();
        String methodName = jp.getSignature().getName();

        Object[] args = jp.getArgs();

        if (args == null){
            executeMethod = executeClass.getMethod(methodName);
        } else {
            Class[] methodArgs = new Class[args.length];
            for (int i = 0; i < methodArgs.length; i++) {
                Class<?> aClass = args[i].getClass();
                boolean b = args[i] instanceof HttpServletRequest;
                boolean b2 = args[i].getClass().isAssignableFrom(HttpServletRequest.class);
                if (args[i] instanceof HttpServletRequest)
                    methodArgs[i] = HttpServletRequest.class;
                else
                    methodArgs[i] = args[i].getClass();
            }
            executeMethod = executeClass.getDeclaredMethod(methodName, methodArgs);
        }
    }

    @After("execution(* cn.wtyoha.company_background_system.controller.*.*(..))")
    public void doAfter(JoinPoint jp){
        if (executeClass!= SysLogController.class){
            RequestMapping classRequestMapping = (RequestMapping) executeClass.getAnnotation(RequestMapping.class);
            RequestMapping methodRequestMapping = executeMethod.getAnnotation(RequestMapping.class);

            if (classRequestMapping != null && methodRequestMapping != null) {
                String url = classRequestMapping.value()[0]+methodRequestMapping.value()[0];
                SysLog sysLog = new SysLog();
                sysLog.setUrl(url);
                sysLog.setVisitTime(stratTime);
                long executeTime = new Date().getTime() - stratTime.getTime();
                sysLog.setExecuteTime(executeTime);
                String ip = request.getRemoteAddr();
                sysLog.setIp(ip);
//                String userName = request.getUserPrincipal().getName();
                User user = (User) request.getSession().getAttribute("loginUser");
                if (user != null) {
                    String userName = user.getUserName();
                    sysLog.setUserName(userName);
                }
                sysLog.setMethod("[类名]"+executeClass.getName()+" [方法名]"+executeMethod.getName());
                sysLogService.save(sysLog);
            }
        }
    }


}
