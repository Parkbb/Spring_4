package com.iu.s4.transfer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class Card {
	
	@After("execution(* com.iu.s4.transfer.Transfer.taxi())")
	public void cash() {
		System.out.println("==== 현금 내기 ====");
	}
	@Around("execution(* com.iu.s4.transfer.Transfer.get*(*))")
	public Object cardCheck(ProceedingJoinPoint join) {
		System.out.println("==== 타기 전 카드 찍기====");
		Object obj = null;
		try {
			Object[] objs = join.getArgs();
			
			for (int i = 0; i < objs.length; i++) {
				System.out.println(objs[i]);
			}
			obj = join.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("==== 내린 후 카드 찍기====");
		
		return obj;
	}
}
