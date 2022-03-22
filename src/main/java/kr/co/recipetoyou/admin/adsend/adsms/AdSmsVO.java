package kr.co.recipetoyou.admin.adsend.adsms;

import org.springframework.stereotype.Component;

@Component("smsVO")
public class AdSmsVO {

	private int sms_code;
	private String user_id;
	private int send_code;
	
	public AdSmsVO() {
		System.out.println("Sms 호출");
	}
	
	public AdSmsVO(int sms_code, String user_id, int send_code) {
		//super();
		this.sms_code = sms_code;
		this.user_id = user_id;
		this.send_code = send_code;
	}
	
	public int getSms_code() {
		return sms_code;
	}
	public void setSms_code(int sms_code) {
		this.sms_code = sms_code;
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
