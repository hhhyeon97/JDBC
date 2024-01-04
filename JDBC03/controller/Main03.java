package controller;

import model.Tmodel;

public class Main03 {
public static void main(String[] args) {
	
	Tmodel tdao = new Tmodel();
	
	System.out.println("\t\t☆ 헬스장 회원 목록 ☆\n");
	System.out.println("번호 \t 이름 \t 패스워드 \t  등록날짜");
	System.out.println("=============================================");
	tdao.selectT();
	
}
}
