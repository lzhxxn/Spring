package soo.md.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import lombok.extern.log4j.Log4j;

@Log4j
@Aspect
@Component
public class SampleLogAdvice {   //횡적관심
	@Before("execution(* soo.md.service.SampleLogService*.*(..))")
	public void logBefore() {
		log.info("#3.logBefore() 수행");
	}
	
	@Around("execution(* soo.md.service.SampleLogService*.*(..))")
	public Object logTime(ProceedingJoinPoint pjp) {
		long start = System.currentTimeMillis();
		
		log.info("#1.target class : " + pjp.getTarget().getClass());
		log.info("#2.args : " + Arrays.toString(pjp.getArgs()));
		
		Object result = null;
		try {
			result = pjp.proceed(); //비지니스 메소드로 진행하도록 하는 메소드  
		}catch(Throwable t) {
			 log.info("#예외발생 t: " + t);
		}
		
		long end = System.currentTimeMillis();
	    log.info("#4.수행시간: " + (end-start));
	    
	    return result;
	}
	
	@After("execution(* soo.md.service.SampleLogService*.*(..))")
	public void logAfter() {
		log.info("#5.logAfter() 수행");
	}
	@AfterThrowing(pointcut="execution(* soo.md.service.SampleLogService*.*(..))", throwing = "exception")
	public void logAfterThrowing(Exception exception) {
		log.info("#logAfterThrowing() exception: " + exception);
	}
}
