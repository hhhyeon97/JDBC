package controller02;

import java.util.Scanner;

import dao02.Tmodel2;
import vo02.VO2;

public class Insert02 {
public static void main(String[] args) {
	Tmodel2 t = new Tmodel2();
	VO2 tvo = new VO2();
	
	Scanner input = new Scanner(System.in);
	System.out.println("***test0809 테이블 레코드 저장하기***");
	
	
	System.out.print("id >>");
	String id=input.nextLine();
	System.out.print("pwd >>");
	String pwd = input.nextLine();
	System.out.print("email >>");
	String email=input.nextLine();
	
	tvo.setId(id); tvo.setPwd(pwd); tvo.setEmail(email);
	
	int re=t.insertT(tvo);
	if(re==1) {
		System.out.println("회원정보 저장 완료!");
		
	}
}
}
