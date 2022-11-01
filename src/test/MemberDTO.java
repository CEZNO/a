package test;

import java.util.Date;
import java.util.List;
import java.util.ArrayList; //public class ArrayList<E> extends AbstractList<E>

public class MemberDTO {
	String id;
	String pw;
	String name;
	String adress;
	long signup_ip;
	Date signup_date;

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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
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
		return "MemberDTO [id=" + id + ", pw=" + pw + ", name=" + name + ", adress=" + adress + ", signup_ip="
				+ signup_ip + ", signup_date=" + signup_date + "]";
	}

}
