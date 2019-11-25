package com.iu.s4.transfer;

import org.springframework.stereotype.Component;

@Component
public class Transfer {
	
	public void Car() {
			System.out.println("----my car ----");
			System.out.println("운전하기");
			System.out.println("---- my car ----");
	}
	
	public void taxi() {
		System.out.println("---- taxi ----");
		System.out.println("대화하기");
		System.out.println("---- taxi ----");
	}
	
	public void getBus(String cardName) {
		System.out.println("---- bus ----");
		System.out.println("음악 듣기");
		System.out.println("---- bus ----");
	}
	
	public void getSubway(String cardName) {
		
		System.out.println("---- subway ----");
		System.out.println("핸드폰 보기");
		System.out.println("---- subway ----");
	}
}
