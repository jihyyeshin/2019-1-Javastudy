package com.spring.ex01;
//어드바이스 클래스
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor {//Mehod Interceptor을 구현한다.
	public Object invoke(MethodInvocation invocation) throws Throwable {
		/*메서드 호출 전과 후를 분리하여 로그 메시지 출력*/
		System.out.println("[메서드 호출 전 : LogginAdvice");
		System.out.println(invocation.getMethod() + "메서드 호출 전");
		
		Object object = invocation.proceed();//invocation을 이용하여 메서드 호출

		System.out.println("[메서드 호출 후 : loggingAdvice");
		System.out.println(invocation.getMethod() + "메서드 호출 후");
		return object;
	}
}
