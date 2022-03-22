package kr.co.recipetoyou.user.mypage.vo;

import org.springframework.stereotype.Component;

//쿠폰 사용 내역 테이블
@Component("couponuseVO")
public class CouponUseVO {
	
	private int cp_use_code;
	private int cp_code;
	private String cp_payment_details;
	
	public int getCp_use_code() {
		return cp_use_code;
	}
	public void setCp_use_code(int cp_use_code) {
		this.cp_use_code = cp_use_code;
	}
	public int getCp_code() {
		return cp_code;
	}
	public void setCp_code(int cp_code) {
		this.cp_code = cp_code;
	}
	public String getCp_payment_details() {
		return cp_payment_details;
	}
	public void setCp_payment_details(String cp_payment_details) {
		this.cp_payment_details = cp_payment_details;
	}
	
	
	
	

}
