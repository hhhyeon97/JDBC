package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import vo.TestVo;

public class Tmodel {
	// 연동 부분 
	Connection conn = null;
	Statement stmt = null;
	ResultSet rset = null;
	PreparedStatement pt = null;
	//목록 select 기능
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
			String query = "select * from test0810 order by tno asc";
			stmt = conn.createStatement(); 
			//3-2. 쿼리문 실행 및 결과 저장.
			rset = stmt.executeQuery(query);
			//3-3. 결과값 출력
			while(rset.next()) {
				System.out.print(rset.getString("tno")+"\t");
				System.out.println(rset.getString("tname")+"\t"+
				rset.getString("tpwd")+"\t"+
				rset.getString("tdate")+"\t");
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
	} // select()
	
	//insert기능
	public int insertT(TestVo vo) {
		int re=-1;
		try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
	   		 conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
						"night", 
						"123456");
	   		 String sql="insert into test0810(tno,tname,tpwd,tdate) values(tseq.nextval,?,?,sysdate)";
	   		 pt = conn.prepareStatement(sql);
	   		 pt.setString(1, vo.getTname());
	   		 pt.setInt(2,vo.getTpwd());
	   		 re = pt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}//finally
		return re;
	}//insert()
	
	//번호찾기
	public TestVo FindNo(int tno) {
		TestVo vo = null;
		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
					"night", 
					"123456"); 
		String sql = "select * from test0810 where tno=?"; 
		pt = conn.prepareStatement(sql); 
		pt.setInt(1, tno); 
		rset = pt.executeQuery(); 
		if(rset.next()) { 
			vo = new TestVo();
			
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
	}//번호검색
	
	//update기능
		public int editUser(TestVo vv) {
			int re = -1; // 수정 실패시 반환값 
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
	 					"night", 
	 					"123456");
				String sql="update test0810 set tname=?,tpwd=? where tno=?";
				pt = conn.prepareStatement(sql);
				pt.setString(1,vv.getTname());
				pt.setInt(2,vv.getTpwd()); 
				pt.setInt(3, vv.getTno()); 
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
		
		//delete기능
		public int delUser(int tno) {
			int re=-1;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
	 					"night", 
	 					"123456");
				String sql = "delete from test0810 where tno=?"; // 번호를 기준으로 레코드 삭제
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
		}//delete()
		
		
	
}
