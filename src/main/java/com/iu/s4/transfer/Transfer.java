package com.iu.s4.transfer;

import org.springframework.stereotype.Component;

@Component
public class Transfer {
	
	public void Car() {
			System.out.println("----my car ----");
			System.out.println("�����ϱ�");
			System.out.println("---- my car ----");
	}
	
	public void taxi() {
		System.out.println("---- taxi ----");
		System.out.println("��ȭ�ϱ�");
		System.out.println("---- taxi ----");
	}
	
	public void getBus(String cardName) {
		System.out.println("---- bus ----");
		System.out.println("���� ���");
		System.out.println("---- bus ----");
	}
	
	public void getSubway(String cardName) {
		
		System.out.println("---- subway ----");
		System.out.println("�ڵ��� ����");
		System.out.println("---- subway ----");
	}
}
