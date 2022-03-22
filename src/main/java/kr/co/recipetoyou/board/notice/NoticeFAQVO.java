package kr.co.recipetoyou.board.notice;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("noticeFAQVO")
public class NoticeFAQVO {
	
	private String faq_code;
	private String faq_title;
	private String faq_info;
	private int faq_cate_code;
	private Date faq_reg_date;
	private String faq_reply;
	
	public NoticeFAQVO() {
		// TODO Auto-generated constructor stub
	}

	public NoticeFAQVO(String faq_code, String faq_title, String faq_info, int faq_cate_code, Date faq_reg_date,
			String faq_reply) {
		super();
		this.faq_code = faq_code;
		this.faq_title = faq_title;
		this.faq_info = faq_info;
		this.faq_cate_code = faq_cate_code;
		this.faq_reg_date = faq_reg_date;
		this.faq_reply = faq_reply;
	}
	
	public String getFaq_reply() {
		return faq_reply;
	}

	public void setFaq_reply(String faq_reply) {
		this.faq_reply = faq_reply;
	}

	public String getFaq_code() {
		return faq_code;
	}

	public void setFaq_code(String faq_code) {
		this.faq_code = faq_code;
	}

	public String getFaq_title() {
		return faq_title;
	}

	public void setFaq_title(String faq_title) {
		this.faq_title = faq_title;
	}

	public String getFaq_info() {
		return faq_info;
	}

	public void setFaq_info(String faq_info) {
		this.faq_info = faq_info;
	}

	public int getFaq_cate_code() {
		return faq_cate_code;
	}

	public void setFaq_cate_code(int faq_cate_code) {
		this.faq_cate_code = faq_cate_code;
	}

	public Date getFaq_reg_date() {
		return faq_reg_date;
	}

	public void setFaq_reg_date(Date faq_reg_date) {
		this.faq_reg_date = faq_reg_date;
	}
	

}
