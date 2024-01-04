package controller02;

import java.util.Scanner;

import dao02.Tmodel2;
import vo02.VO2;



public class Update02 {
public static void main(String[] args) {
	
	Tmodel2 tdao = new Tmodel2();
	VO2 tvo = new VO2();
	
	String id=null;
	String pwd=null;
	String email=null;
	
	
	Scanner input = new Scanner(System.in);
	System.out.println("** 회원정보 수정 **");
	System.out.print("회원 번호 입력 >>");
	int tno=input.nextInt();
	input.nextLine();
	
	VO2 tt = tdao.findNum(tno);
	
	if(tt==null) {
		System.out.println("번호값이 없어서 수정할 수 없습니다!");
	}
	else {
		System.out.print("수정할 id 입력>>");
		 id = input.nextLine();
		System.out.print("수정할 pwd 입력 >>");
		 pwd= input.nextLine();
		System.out.print("수정할 email 입력 >>");
		 email=input.nextLine();
	}
	
	tvo.setId(id); tvo.setPwd(pwd); tvo.setEmail(email); tvo.setTno(tno);
	
	int re = tdao.editUser(tvo);
	if(re == 1) {
		System.out.println("게시판 수정 성공 !");
	}
	
	
	
	
	
	
	
}
}
