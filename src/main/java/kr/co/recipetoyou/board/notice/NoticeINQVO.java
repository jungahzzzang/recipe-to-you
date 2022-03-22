package kr.co.recipetoyou.board.notice;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("noticeINQVO")
public class NoticeINQVO {
	
	private int inq_idx;
	private int rn;
	private String inq_title_code;
	private int ord_code;
	private String user_mail;
	private int user_mail_send_agree;
	private String user_phone;
	private int user_phone_send_agree;
	private String inq_content;
	private int inq_image_file_no;
	private Date inq_date;
	private String user_id;
	private String inq_title;
	
	public NoticeINQVO() {
		// TODO Auto-generated constructor stub
	}

	public NoticeINQVO(int inq_idx, int rn, String inq_title_code, int ord_code, String user_mail,
			int user_mail_send_agree, String user_phone, int user_phone_send_agree, String inq_content,
			int inq_image_file_no, Date inq_date, String user_id, String inq_title) {
		super();
		this.inq_idx = inq_idx;
		this.rn = rn;
		this.inq_title_code = inq_title_code;
		this.ord_code = ord_code;
		this.user_mail = user_mail;
		this.user_mail_send_agree = user_mail_send_agree;
		this.user_phone = user_phone;
		this.user_phone_send_agree = user_phone_send_agree;
		this.inq_content = inq_content;
		this.inq_image_file_no = inq_image_file_no;
		this.inq_date = inq_date;
		this.user_id = user_id;
		this.inq_title = inq_title;
	}
	
	public int getRn() {
		return rn;
	}

	public void setRn(int rn) {
		this.rn = rn;
	}



	public int getInq_idx() {
		return inq_idx;
	}

	public void setInq_idx(int inq_idx) {
		this.inq_idx = inq_idx;
	}

	public String getInq_title_code() {
		return inq_title_code;
	}

	public void setInq_title_code(String inq_title_code) {
		this.inq_title_code = inq_title_code;
	}

	public int getOrd_code() {
		return ord_code;
	}

	public void setOrd_code(int ord_code) {
		this.ord_code = ord_code;
	}

	public String getUser_mail() {
		return user_mail;
	}

	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}

	public int getUser_mail_send_agree() {
		return user_mail_send_agree;
	}

	public void setUser_mail_send_agree(int user_mail_send_agree) {
		this.user_mail_send_agree = user_mail_send_agree;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public int getUser_phone_send_agree() {
		return user_phone_send_agree;
	}

	public void setUser_phone_send_agree(int user_phone_send_agree) {
		this.user_phone_send_agree = user_phone_send_agree;
	}

	public String getInq_content() {
		return inq_content;
	}

	public void setInq_content(String inq_content) {
		this.inq_content = inq_content;
	}

	public int getInq_image_file_no() {
		return inq_image_file_no;
	}

	public void setInq_image_file_no(int inq_image_file_no) {
		this.inq_image_file_no = inq_image_file_no;
	}

	public Date getInq_date() {
		return inq_date;
	}

	public void setInq_date(Date inq_date) {
		this.inq_date = inq_date;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getInq_title() {
		return inq_title;
	}

	public void setInq_title(String inq_title) {
		this.inq_title = inq_title;
	}

	@Override
	public String toString() {
		return "NoticeINQVO [inq_idx=" + inq_idx + ", inq_title_code=" + inq_title_code + ", ord_code=" + ord_code
				+ ", user_mail=" + user_mail + ", user_mail_send_agree=" + user_mail_send_agree + ", user_phone="
				+ user_phone + ", user_phone_send_agree=" + user_phone_send_agree + ", inq_content=" + inq_content
				+ ", inq_image_file_no=" + inq_image_file_no + ", inq_date=" + inq_date + ", user_id=" + user_id
				+ ", inq_title=" + inq_title + "]";
	}
	

}
