package controller01;

import dao01.testDAO01;

public class testMain01 {
public static void main(String[] args) {
	
	testDAO01 t = new testDAO01();
	
	System.out.println("tno \t name \t id \t pwd");
	System.out.println("===================================");
	
	t.selectTest();
	
	
}
}
