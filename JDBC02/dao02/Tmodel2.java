package dao02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import vo02.VO2;


public class Tmodel2 {
	
	// 연동 부분 
	Connection conn = null;
	Statement stmt = null;
	ResultSet rset = null;
	PreparedStatement pt = null;

	//select기능
	public void selectT(){
		try {
			//1. 해당 데이터베이스에 대한 라이브러리 등록 작업
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. 데이터베이스와 연결 (Connection 객체 생성)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
					"night", 
					"123456");
			//3. DB에서 쿼리문을 실행하고 실행 결과를 ResultSet으로 받음
			//3-1. 쿼리문 선언 및 생성.
			String query = "select * from test0809 order by tno asc";
			stmt = conn.createStatement();  // < --- 여기 다시 
			//3-2. 쿼리문 실행 및 결과 저장.
			rset = stmt.executeQuery(query);
			//3-3. 결과값 출력
			while(rset.next()) {
				System.out.print(rset.getString("tno")+"\t");
				System.out.println(rset.getString("tid")+"\t"+
				rset.getString("tpwd")+"\t"+
				rset.getString("temail")+"\t");
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
		
	
	//insert
	public int insertT(VO2 v) {
		int re=-1;
		
		try {
			
	   		 Class.forName("oracle.jdbc.driver.OracleDriver");
	   		 conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
						"night", 
						"123456");
	   		 String sql="insert into test0809(tno,tid,tpwd,temail) values(seq01.nextval,?,?,?)";
	   		 pt = conn.prepareStatement(sql); // 쿼리문을 미리 컴파일하여 수행할 pt생성
	   		 
//	   		 pt.setInt(1, t.getTno()); //쿼리문의 첫번째 물음표에 문자열로 작성자를 저장
	   		 pt.setString(1, v.getId());
	   		 pt.setString(2,v.getPwd());
	   		 pt.setString(3,v.getEmail());
	   		 
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
	} // insert 기능 
	
	
	//번호 검색
	public VO2 findNum(int tno) {
		VO2 vo = null;
		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
					"night", 
					"123456"); // 인자값으로 db접속주소, 오라클 사용자,
														// 비밀번호가 전달되면서 db연결 con 생성 
		String sql = "select * from test0809 where tno=?"; // 번호를 기준으로 해당 테이블로부터 레코드 검색
		pt = conn.prepareStatement(sql); // 쿼리문을 미리 컴파일하여 수행할 pt
		pt.setInt(1, tno); // 쿼리문의 첫번쨰 물음표에 정수 숫자로 번호값 저장 
		rset = pt.executeQuery(); // 검색문 수행후 결과 레코드를 rs에 저장 
		if(rset.next()) { // 하나의 행 레코드가 검색된 경우는 if문으로 처리, next()메서드는 다음 레코드 행이 존재하면 참
			vo = new VO2();
			
			vo.setTno(rset.getInt(1)); 
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
	return vo;
	}
	
	
	// delete
	public int delUser(int tno) {
		int re=-1;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
 					"night", 
 					"123456");
			String sql = "delete from test0809 where tno=?"; // 번호를 기준으로 레코드 삭제
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
		
	} // delete()
	
	//update
	public int editUser(VO2 vv) {
		int re = -1; // 수정 실패시 반환값 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
 					"night", 
 					"123456");
			String sql="update test0809 set tid=?,tpwd=?,temail=? where tno=?";
			pt = conn.prepareStatement(sql);
			pt.setString(1,vv.getId()); //쿼리문의 첫번째 물음표에 문자열로 수정할 글쓴이를 저장
			pt.setString(2,vv.getPwd()); 
			pt.setString(3,vv.getEmail());
			pt.setInt(4, vv.getTno()); // 쿼리문의 4번째 물음표에 정수 숫자로 기준이 되는 번호값 저장
			
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
	} // update()
	
	
}
