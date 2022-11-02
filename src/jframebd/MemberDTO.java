package jframebd;

import java.util.Date;

public class MemberDTO {
	private long no;
	private String id;
	private String pw;
	private String name;
	private String address;
	private long signup_ip;
	private Date signup_date;
	
	public MemberDTO() {

	}

//	public MemberDTO(String id, String pw, String name, String adress, int signup_ip, Date signup_date) {
//		super();
//		this.id = id;
//		this.pw = pw;
//		this.name = name;
//		this.adress = adress;
//		this.signup_ip = signup_ip;
//		this.signup_date = signup_date;
//	}
//
//	public MemberDTO(String id, String pw, String name, int signup_ip, Date signup_date) {
//		super();
//		this.id = id;
//		this.pw = pw;
//		this.name = name;
//		this.signup_ip = signup_ip;
//		this.signup_date = signup_date;
//	}
//
//	public MemberDTO(String id, String pw, String name, Date signup_date) {
//		super();
//		this.id = id;
//		this.pw = pw;
//		this.name = name;
//		this.signup_date = signup_date;
//	}
//
//	public MemberDTO(String id, String pw, String name, String adress, Date signup_date) {
//		super();
//		this.id = id;
//		this.pw = pw;
//		this.name = name;
//		this.adress = adress;
//		this.signup_date = signup_date;
//	}

	public long getNo() {
		return no;
	}
	
	public void setNo(long no) {
		this.no = no;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getSignup_ip() {
		return signup_ip;
	}

	public void setSignup_ip(long signup_ip) {
		this.signup_ip = signup_ip;
	}

	public Date getSignup_date() {
		return signup_date;
	}

	public void setSignup_date(Date signup_date) {
		this.signup_date = signup_date;
	}

	@Override
	public String toString() {
		return "MemberDTO [no=" + no + ", id=" + id + ", pw=" + pw + ", name=" + name + ", address=" + address
				+ ", signup_ip=" + signup_ip + ", signup_date=" + signup_date + "]";
	}

}
