package org.cloud.sample.AOP.PageHelper;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PageableAspect {
    @Around("@annotation(Pageable)")
    public Object converter(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        int count = 0;
        for(Object arg : args){
            if (arg instanceof Page){
                Page page = (Page) arg;
                page.setStart(page.getPage_number() * page.getRows_per_page());
                page.setOffset(page.getRows_per_page());
                args[count] = page;
                break;
            }
            count++;
        }
        return joinPoint.proceed();
    }
}
