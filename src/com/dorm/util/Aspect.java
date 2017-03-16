package com.dorm.util;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.apache.log4j.Logger;

import com.dorm.controller.LoginController;


public class Aspect {
	Logger logger = Logger.getLogger(Aspect.class);  
	String strLog = null ;  


	public void doBefore(JoinPoint jp) {  
		strLog = "log Begining method: "  
				+ jp.getTarget().getClass().getName() + "."  
				+ jp.getSignature().getName();  
		logger.warn(strLog);  
	}  

	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {  
		long time = System.currentTimeMillis();  
		Object retVal = pjp.proceed();  
		time = System.currentTimeMillis() - time;  
		System.out.println("process time: " + time + " ms");  
		return retVal;  
	}  

	public void doAfter(JoinPoint jp) {  
		strLog ="doAfter:log Ending method: "  
				+ jp.getTarget().getClass().getName() + "."  
				+ jp.getSignature().getName();   
		logger.warn(strLog);  
	} 

	public void doAfterThrow(JoinPoint jp,Exception e){
		System.out.println("*****************异常信息如下**************");
		System.out.println("method " + jp.getTarget().getClass().getName()
				+ "." + jp.getSignature().getName() + " throw exception");

		StringWriter   sw=new   StringWriter();   			
		e.printStackTrace(new PrintWriter(sw));

		logger.error(sw.toString());
	}
}