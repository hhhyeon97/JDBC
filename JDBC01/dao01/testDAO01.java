package dao01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import vo01.testVO01;

public class testDAO01 {

	// 연동 부분 
	Connection conn = null;
	Statement stmt = null;
	ResultSet rset = null;
	PreparedStatement pt = null;
	
	// SELECT기능
	public void selectTest() {
		try {
			//1. 해당 데이터베이스에 대한 라이브러리 등록 작업
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. 데이터베이스와 연결 (Connection 객체 생성)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
					"night", 
					"123456");
			//3. DB에서 쿼리문을 실행하고 실행 결과를 ResultSet으로 받음
			//3-1. 쿼리문 선언 및 생성.
			String query = "select * from test0807 order by tno asc";
			stmt = conn.createStatement();  // < --- 여기 다시 
			//3-2. 쿼리문 실행 및 결과 저장.
			rset = stmt.executeQuery(query);
			//3-3. 결과값 출력
			while(rset.next()) {
				System.out.print(rset.getString("tno")+"\t");
				System.out.println(rset.getString("name")+"\t"+
				rset.getString("id")+"\t"+
				rset.getString("pwd")+"\t");
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {// 4. 객체 사용 후 반환 
				rset.close();
				stmt.close();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		} // finally
	} // select구현
	
	
	
	
	// insert기능
	public int insertTest(testVO01 t) {
		int re=-1;
		
		try {
			
   		 Class.forName("oracle.jdbc.driver.OracleDriver");
   		 conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
					"night", 
					"123456");
   		 String sql="insert into test0807(tno,name,id,pwd) values(tnoseq01.nextval,?,?,?)";
   		 pt = conn.prepareStatement(sql); // 쿼리문을 미리 컴파일하여 수행할 pt생성
   		 
//   		 pt.setInt(1, t.getTno()); //쿼리문의 첫번째 물음표에 문자열로 작성자를 저장
   		 pt.setString(1, t.getName());
   		 pt.setString(2,t.getId());
   		 pt.setInt(3,t.getPwd());
   		 
   		 re = pt.executeUpdate(); // 저장 쿼리문 수행 후 성공한 레코드 행의 개수를 반환
		
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
   			 if(pt!=null)pt.close();
   			 if(conn!=null)conn.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		} //finally
		
		return re;
	} // insert 
	
	
	
	//번호찾기기능
	
	public testVO01 getFindNo(int tno) {
		
		testVO01 t01=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
 					"night", 
 					"123456"); // 인자값으로 db접속주소, 오라클 사용자,
															// 비밀번호가 전달되면서 db연결 con 생성 
			String sql = "select * from test0807 where tno=?"; // 번호를 기준으로 해당 테이블로부터 레코드 검색
			pt = conn.prepareStatement(sql); // 쿼리문을 미리 컴파일하여 수행할 pt
			pt.setInt(1, tno); // 쿼리문의 첫번쨰 물음표에 정수 숫자로 번호값 저장 
			rset = pt.executeQuery(); // 검색문 수행후 결과 레코드를 rs에 저장 
			if(rset.next()) { // 하나의 행 레코드가 검색된 경우는 if문으로 처리, next()메서드는 다음 레코드 행이 존재하면 참
				t01 = new testVO01();
				
				t01.setTno(rset.getInt(1)); // 1은 select 문 뒤에 검색되는 컬럼 순번을 의미한다.
				// 결국 첫번째로 검색되는 bno 컬럼으로부터 정수 숫자 번호값으로 레코드를 가져와서 setter()메서드에 저장 
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rset != null) rset.close();
				if(pt != null) pt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return t01;
	} //getFindNo()
	
	
	// 수정 
	public int editUser(testVO01 tt) {
		int re = -1; // 수정 실패시 반환값 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
 					"night", 
 					"123456");
			String sql="update test0807 set name=?,id=?,pwd=? where tno=?";
			pt = conn.prepareStatement(sql);
			pt.setString(1,tt.getName()); //쿼리문의 첫번째 물음표에 문자열로 수정할 글쓴이를 저장
			pt.setString(2,tt.getId()); 
			pt.setInt(3,tt.getPwd());
			pt.setInt(4, tt.getTno()); // 쿼리문의 4번째 물음표에 정수 숫자로 기준이 되는 번호값 저장
			
			re = pt.executeUpdate(); // 수정 쿼리문 성공후 성공한 레코드 행의 개수를 반환
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pt != null ) pt.close();
				if(conn != null ) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return re;
	} // editUser()
	
	
	
	// 삭제기능 
public int delUser(int tno) {
		
		int re = -1 ; // 삭제 실패시 반환값
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
 					"night", 
 					"123456");
			String sql = "delete from test0807 where tno=?"; // 번호를 기준으로 레코드 삭제
			pt = conn.prepareStatement(sql);
			pt.setInt(1, tno);
			
			re =pt.executeUpdate(); // 삭제 쿼리문 수행후 성공한 레코드 행의 개수 반환 
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pt != null) pt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return re;
		
	} //delUser()
	
}
