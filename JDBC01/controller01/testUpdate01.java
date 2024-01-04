package controller01;

import java.util.Scanner;

import dao01.testDAO01;
import vo01.testVO01;

public class testUpdate01 {
public static void main(String[] args) {
	
	testDAO01 tmodel =new testDAO01();
	testVO01 tvo = new testVO01();
	
	String name=null;
	String id=null;
	int pwd=0;
	
	
	Scanner input = new Scanner(System.in);
	System.out.print("게시판 번호 입력 >>");
	int tno=input.nextInt();
	input.nextLine();
	
	testVO01 tt = tmodel.getFindNo(tno);
	
	if(tt==null) {
		System.out.println("번호값이 없어서 수정할 수 없습니다!");
	}
	else {
		System.out.print("수정할 name 입력>>");
		 name = input.nextLine();
		System.out.print("수정할 id 입력 >>");
		 id= input.nextLine();
		System.out.print("수정할 비밀번호 입력 >>");
		 pwd= input.nextInt();
		input.nextLine();
	}
	
	tvo.setName(name); tvo.setId(id); tvo.setPwd(pwd); tvo.setTno(tno);
	
	int re = tmodel.editUser(tvo);
	if(re == 1) {
		System.out.println("게시판 수정 성공 !");
	}
	
}
}
