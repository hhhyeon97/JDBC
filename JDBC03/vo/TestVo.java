package vo;

import java.sql.Date;

public class TestVo {

	private int tno;
	private String tname;
	private int tpwd;
	private Date tdate;
	
	
	
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getTpwd() {
		return tpwd;
	}
	public void setTpwd(int tpwd) {
		this.tpwd = tpwd;
	}
	public Date getTdate() {
		return tdate;
	}
	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}

}
