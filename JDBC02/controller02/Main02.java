package controller02;

import dao02.Tmodel2;

public class Main02 {
public static void main(String[] args) {
	
	Tmodel2 tdao = new Tmodel2();
	System.out.println("*** test0809 회원 ***");
	System.out.println("tno \t id \t pwd \t email");
	System.out.println("====================================");
	tdao.selectT();
	
	
}
}
