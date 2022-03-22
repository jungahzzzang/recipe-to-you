package kr.co.recipetoyou.user.mypage.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

//쿠폰 테이블
@Component("couponVO")
public class CouponVO {
	
	
	//쿠폰 사용 내역 테이블
	private CouponUseVO couponuseVO;
	private String cp_payment_details;
	
	
	private int cp_code;
	private String cp_name;
	private Date cp_use_date;
	private Date cp_end_date;
	private String user_id;
	private int pay_code;
	private int	ord_code;
	private String cp_function;
	private String cp_price;
	private String cp_id;
	private String cp_content;
	

	
	public int getCp_code() {
		return cp_code;
	}
	public void setCp_code(int cp_code) {
		this.cp_code = cp_code;
	}
	public String getCp_name() {
		return cp_name;
	}
	public void setCp_name(String cp_name) {
		this.cp_name = cp_name;
	}
	public Date getCp_use_date() {
		return cp_use_date;
	}
	public void setCp_use_date(Date cp_use_date) {
		this.cp_use_date = cp_use_date;
	}
	public Date getCp_end_date() {
		return cp_end_date;
	}
	public void setCp_end_date(Date cp_end_date) {
		this.cp_end_date = cp_end_date;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getPay_code() {
		return pay_code;
	}
	public void setPay_code(int pay_code) {
		this.pay_code = pay_code;
	}
	public int getOrd_code() {
		return ord_code;
	}
	public void setOrd_code(int ord_code) {
		this.ord_code = ord_code;
	}
	public String getCp_function() {
		return cp_function;
	}
	public void setCp_function(String cp_function) {
		this.cp_function = cp_function;
	}
	public String getCp_price() {
		return cp_price;
	}
	public void setCp_price(String cp_price) {
		this.cp_price = cp_price;
	}
	public String getCp_id() {
		return cp_id;
	}
	public void setCp_id(String cp_id) {
		this.cp_id = cp_id;
	}
	public String getCp_content() {
		return cp_content;
	}
	public void setCp_content(String cp_content) {
		this.cp_content = cp_content;
	}
	public String getCp_payment_details() {
		return cp_payment_details;
	}
	public void setCp_payment_details(String cp_payment_details) {
		this.cp_payment_details = cp_payment_details;
	}

	
	


}
