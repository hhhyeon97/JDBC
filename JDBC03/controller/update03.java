package controller;

import java.util.Scanner;

import model.Tmodel;
import vo.TestVo;

public class update03 {
public static void main(String[] args) {
	Tmodel tdao=new Tmodel();
	TestVo tvo = new TestVo();
	
	String tname=null;
	int tpwd=0;
	
	Scanner input = new Scanner(System.in);
	System.out.println("** 회원정보 수정 **");
	System.out.print("회원 번호 입력 >>");
	int tno=input.nextInt();
	input.nextLine();
	TestVo vv = tdao.FindNo(tno);
	if(vv==null) {
		System.out.println("번호값이 없어서 수정할 수 없습니다!");
	}
	else {
		System.out.print("수정할 회원명 >>");
		  tname = input.nextLine();
		System.out.print("수정할 비밀번호 >>");
		  tpwd = input.nextInt();
		 input.nextLine();
	}	 
	tvo.setTname(tname);tvo.setTpwd(tpwd); tvo.setTno(tno);
	
	int re = tdao.editUser(tvo);
	if(re == 1) {
		System.out.println("게시판 수정 성공 !");
	}
	
	
}
}
