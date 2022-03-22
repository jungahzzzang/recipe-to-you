package kr.co.recipetoyou.admin.adsend;

import java.sql.Date;

import org.springframework.stereotype.Component;

import kr.co.recipetoyou.admin.adorder.AdOrderVO;
import kr.co.recipetoyou.admin.adpayment.AdPaymentVO;

@Component("adsendVO")
public class AdSendVO {

	private int send_code;
	private int ord_code;
	private int pay_code;
	private String user_id;
	private String send_content;
	private Date send_date;
	private int delivery_idx;	



	public AdSendVO() {
		System.out.println("Send 호출");
	}	
	
	public AdSendVO(int send_code, int ord_code, int pay_code, String user_id, String send_content, int delivery_idx) {
		super();
		this.send_code = send_code;
		this.ord_code = ord_code;
		this.pay_code = pay_code;
		this.user_id = user_id;
		this.send_content = send_content;
		this.delivery_idx = delivery_idx;
	}
	
	public int getSend_code() {
		return send_code;
	}
	public void setSend_code(int send_code) {
		this.send_code = send_code;
	}
	public int getOrd_code() {
		return ord_code;
	}
	public void setOrd_code(int ord_code) {
		this.ord_code = ord_code;
	}
	public int getPay_code() {
		return pay_code;
	}
	public void setPay_code(int pay_code) {
		this.pay_code = pay_code;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getSend_content() {
		return send_content;
	}
	public void setSend_content(String send_content) {
		this.send_content = send_content;
	}
	public Date getSend_date() {
		return send_date;
	}
	public void setSend_date(Date send_date) {
		this.send_date = send_date;
	}
	public int getDelivery_idx() {
		return delivery_idx;
	}
	public void setDelivery_idx(int delivery_idx) {
		this.delivery_idx = delivery_idx;
	}
	
}
