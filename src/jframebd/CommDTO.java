package jframebd;


import java.util.Date;

public class CommDTO {
	private long cmt_no;
	private int cmt_chckopen;
	private int cmt_blame;
	private Date cmt_date;
	private String cmt_txt;
	private long pst_no;
	private String id;

	public CommDTO() {

	}
	
	public long getCmt_no() {
		return cmt_no;
	}

	public void setCmt_no(long cmt_no) {
		this.cmt_no = cmt_no;
	}

	public int getCmt_chckopen() {
		return cmt_chckopen;
	}

	public void setCmt_chckopen(int cmt_chckopen) {
		this.cmt_chckopen = cmt_chckopen;
	}

	public int getCmt_blame() {
		return cmt_blame;
	}

	public void setCmt_blame(int cmt_blame) {
		this.cmt_blame = cmt_blame;
	}

	public Date getCmt_date() {
		return cmt_date;
	}

	public void setCmt_date(Date cmt_date) {
		this.cmt_date = cmt_date;
	}

	public String getCmt_txt() {
		return cmt_txt;
	}

	public void setCmt_txt(String cmt_txt) {
		this.cmt_txt = cmt_txt;
	}

	public long getPst_no() {
		return pst_no;
	}

	public void setPst_no(long pst_no) {
		this.pst_no = pst_no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CommDTO [cmt_no=" + cmt_no + ", cmt_chckopen=" + cmt_chckopen + ", cmt_blame=" + cmt_blame
				+ ", cmt_date=" + cmt_date + ", cmt_txt=" + cmt_txt + ", pst_no=" + pst_no + ", id=" + id + "]";
	}

}
