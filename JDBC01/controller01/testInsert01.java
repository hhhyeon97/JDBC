package controller01;

import java.util.Scanner;

import dao01.testDAO01;
import vo01.testVO01;

public class testInsert01 {
public static void main(String[] args) {
	
	testDAO01 t = new testDAO01();
	testVO01 tvo = new testVO01();
	
	Scanner input = new Scanner(System.in);
	
	System.out.println("***test0807 테이블 레코드 저장하기***");
	
	System.out.print("이름 >>");
	String name=input.nextLine();
	System.out.print("id >>");
	String id = input.nextLine();
	System.out.print("pwd >>");
	int pwd=input.nextInt();
	input.nextLine();
	
	tvo.setName(name); tvo.setId(id); tvo.setPwd(pwd);
	int re =t.insertTest(tvo);
	if(re==1) {
		System.out.println("회원정보 저장 성공!");
	}

	
	
}
}
