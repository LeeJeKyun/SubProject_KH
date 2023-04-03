package Dto;

public class Member {


	private String id;
	private String pw;
	private String email;
	private int idnum;
	private String sns;
	private String snsid;
	
	public Member() {}
	
	public Member(String id, String pw, String email, int idnum, String sns, String snsid) {
		super();
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.idnum = idnum;
		this.sns = sns;
		this.snsid = snsid;
	}
	
	@Override
	public String toString() {
		return "member [id=" + id + ", pw=" + pw + ", email=" + email + ", idnum=" + idnum + ", sns=" + sns + ", snsid="
				+ snsid + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdnum() {
		return idnum;
	}

	public void setIdnum(int idnum) {
		this.idnum = idnum;
	}

	public String getSns() {
		return sns;
	}

	public void setSns(String sns) {
		this.sns = sns;
	}

	public String getSnsid() {
		return snsid;
	}

	public void setSnsid(String snsid) {
		this.snsid = snsid;
	}
	
	
	
	
}
