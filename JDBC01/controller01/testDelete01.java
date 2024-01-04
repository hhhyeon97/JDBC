package controller01;

import java.util.Scanner;

import dao01.testDAO01;
import vo01.testVO01;

public class testDelete01 {
public static void main(String[] args) {
	
	testDAO01 tdao= new testDAO01();
	Scanner input = new Scanner(System.in);
	
	System.out.println("** 게시물 삭제하기 연습 **");
	System.out.print("게시판 번호 입력 >>");
	int tno = Integer.parseInt(input.nextLine());
	// 문자열로 입력받아서 정수 숫자로 변경
	
	testVO01 tvo = tdao.getFindNo(tno); // 오라클 db로부터 번호값 검색
	
	if(tvo!=null) {
		
		int re=tdao.delUser(tno);
		
		if(re==1) {
			System.out.println("게시판 삭제 성공!");
		}else {
			System.out.println("번호값이 존재하지 않아 삭제 불가");
		}
	}


}
}
