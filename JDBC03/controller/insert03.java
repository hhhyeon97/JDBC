package controller;

import java.util.Scanner;

import model.Tmodel;
import vo.TestVo;

public class insert03 {
public static void main(String[] args) {
	
	Tmodel tdao = new Tmodel();
	TestVo tvo = new TestVo();
	
	Scanner input = new Scanner(System.in);
	System.out.println("***test헬스장 회원 등록***");
	
	System.out.print("회원이름>>");
	String tname=input.nextLine();
	System.out.print("사물함 비밀번호 >>");
	int tpwd=input.nextInt();
	input.nextLine();
	
	tvo.setTname(tname); tvo.setTpwd(tpwd);
	int re=tdao.insertT(tvo);
	if(re==1) {
		System.out.println("회원 등록이 완료되었습니다!");
	}
	
}
}
