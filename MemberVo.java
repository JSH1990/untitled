package managerjsp;

import java.util.Date;

public class MemberVo {
	int no;
	String id;
	String password;
	String nickname;
	Date regdate;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public MemberVo(int no, String id, String password, String nickname) {
		super();
		this.no = no;
		this.id = id;
		this.password = password;
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", id=" + id + ", password=" + password + ", nickname=" + nickname + ", regdate="
				+ regdate + "]";
	}
	
	

	
}
