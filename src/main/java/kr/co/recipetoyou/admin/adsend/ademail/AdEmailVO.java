package kr.co.recipetoyou.admin.adsend.ademail;

import org.springframework.stereotype.Component;

@Component("emailVO")
public class AdEmailVO {

	private int mail_code;
	private String user_id;
	private int send_code;

	public AdEmailVO() {
		System.out.println("Email 호출");
	}
	
	public AdEmailVO(int mail_code, String user_id, int send_code) {
		super();
		this.mail_code = mail_code;
		this.user_id = user_id;
		this.send_code = send_code;
	}
	public int getMail_code() {
		return mail_code;
	}
	public void setMail_code(int mail_code) {
		this.mail_code = mail_code;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getSend_code() {
		return send_code;
	}
	public void setSend_code(int send_code) {
		this.send_code = send_code;
	}
	
	
	
}
