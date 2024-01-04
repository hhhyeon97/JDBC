package controller;

import java.util.Scanner;

import model.Tmodel;
import vo.TestVo;

public class delete03 {
public static void main(String[] args) {
	
	Tmodel tdao = new Tmodel();
	Scanner input = new Scanner(System.in);
	System.out.println("** 회원정보 삭제 **");
	System.out.print("번호 입력 >>");
	int num = Integer.parseInt(input.nextLine());
	TestVo vo = tdao.FindNo(num);
	if(vo!=null) {
		int re=tdao.delUser(num);
		if(re==1) {
			System.out.println("게시판 삭제 성공!");
		}else {
			System.out.println("번호값이 존재하지 않아 삭제 불가");
		}
	}
	
}
}
