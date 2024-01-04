package controller02;

import java.util.Scanner;

import dao02.Tmodel2;
import vo02.VO2;

public class delete02 {
public static void main(String[] args) {
	
	Tmodel2 t = new Tmodel2();

	
	Scanner input = new Scanner(System.in);
	System.out.println("** 회원정보 삭제 **");
	System.out.print("번호 입력 >>");
	
	int num = Integer.parseInt(input.nextLine());
	VO2 vo = t.findNum(num);
	
	if(vo!=null) {
		
		int re=t.delUser(num);
		
		if(re==1) {
			System.out.println("게시판 삭제 성공!");
		}else {
			System.out.println("번호값이 존재하지 않아 삭제 불가");
		}
	}
	
}
}
