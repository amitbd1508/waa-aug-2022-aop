package lab5.aop.springaop.helper;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class PostHeaderAspect {

  @Pointcut("within(lab5.aop.springaop.service..*..*)")
  public void checkPostHeader(){}

  @Before("checkPostHeader()")
  public void check(JoinPoint joinPoint) {

    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

    if(HttpMethod.POST.matches(request.getMethod()) && request.getHeader("AOP-IS-AWESOME") == null) {
      throw new AOPIsAwesomeException("AOP-Is-Awsome");
    }
  }

}
