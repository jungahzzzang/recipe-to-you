package kr.co.recipetoyou.board.notice;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("noticeVO")
public class NoticeVO {
	
	private int notice_idx;
	private int notice_type;
	private String notice_title;
	private String notice_content;
	private Date notice_reg_date;
	private String admin_id;
	private int notice_hit;
	
	public NoticeVO() {
		// TODO Auto-generated constructor stub
	}
	
	public NoticeVO(int notice_idx, int notice_type, String notice_title, String notice_content, Date notice_reg_date,
			String admin_id, int notice_hit) {
		super();
		this.notice_idx = notice_idx;
		this.notice_type = notice_type;
		this.notice_title = notice_title;
		this.notice_content = notice_content;
		this.notice_reg_date = notice_reg_date;
		this.admin_id = admin_id;
		this.notice_hit = notice_hit;
	}

	public int getNotice_idx() {
		return notice_idx;
	}

	public void setNotice_idx(int notice_idx) {
		this.notice_idx = notice_idx;
	}

	public int getNotice_type() {
		return notice_type;
	}

	public void setNotice_type(int notice_type) {
		this.notice_type = notice_type;
	}

	public String getNotice_title() {
		return notice_title;
	}

	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}

	public String getNotice_content() {
		return notice_content;
	}

	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}

	public Date getNotice_reg_date() {
		return notice_reg_date;
	}

	public void setNotice_reg_date(Date notice_reg_date) {
		this.notice_reg_date = notice_reg_date;
	}

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public int getNotice_hit() {
		return notice_hit;
	}

	public void setNotice_hit(int notice_hit) {
		this.notice_hit = notice_hit;
	}

	@Override
	public String toString() {
		return "NoticeVO [notice_idx=" + notice_idx + ", notice_type=" + notice_type + ", notice_title=" + notice_title
				+ ", notice_content=" + notice_content + ", notice_reg_date=" + notice_reg_date + ", admin_id="
				+ admin_id + ", notice_hit=" + notice_hit + "]";
	}
	
	
	
}
