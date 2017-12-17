package by.htp.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {
	private static final Logger LOG = Logger.getLogger(LoggingAspect.class);
	
	@Before("execution(* by.htp.controller.NewsController.*(..))")
	public void logBeforeViewNews(JoinPoint joinPoint) {
		
		
		LOG.info("All about calling method ====>>> " + joinPoint.getSignature() );
		
		LOG.info("===================>>>>>>>>  BEFORE:  ------- " + "In the class --> " + joinPoint.getTarget().getClass().getSimpleName() + ". The method is called --> "
				+ joinPoint.getSignature().getName() );
	}
	
}
