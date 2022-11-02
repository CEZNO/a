package test;


import java.util.Date;

public class PostDTO {
	private long no;
	private long pst_no;
	private String pst_title;
	private String pst_text;
	private Date pst_date;
	private String id;
	private long hit;

	public PostDTO() {

	}

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public long getPst_no() {
		return pst_no;
	}

	public void setPst_no(long pst_no) {
		this.pst_no = pst_no;
	}

	public String getPst_title() {
		return pst_title;
	}

	public void setPst_title(String pst_title) {
		this.pst_title = pst_title;
	}

	public String getPst_text() {
		return pst_text;
	}

	public void setPst_text(String pst_text) {
		this.pst_text = pst_text;
	}

	public Date getPst_date() {
		return pst_date;
	}

	public void setPst_date(Date pst_date) {
		this.pst_date = pst_date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getHit() {
		return hit;
	}

	public void setHit(long hit) {
		this.hit = hit;
	}

	@Override
	public String toString() {
		return "PostDTO [no=" + no + ", pst_no=" + pst_no + ", pst_title=" + pst_title + ", pst_text=" + pst_text
				+ ", pst_date=" + pst_date + ", id=" + id + ", hit=" + hit + "]";
	}


}
