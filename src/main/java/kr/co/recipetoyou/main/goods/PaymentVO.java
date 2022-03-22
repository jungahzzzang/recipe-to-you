package kr.co.recipetoyou.main.goods;


import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("paymentVO")
public class PaymentVO {

	private int pay_code;
	private int pay_method;
	private Date pay_date;
	private int pay_price;
	private int cp_code;
	private int ord_code;
	
	public PaymentVO() {
		// TODO Auto-generated constructor stub
	}
	
	public PaymentVO(int pay_code, int pay_method, int pay_price, int cp_code, int ord_code) {
		super();
		this.pay_code = pay_code;
		this.pay_method = pay_method;
		this.pay_price = pay_price;
		this.cp_code = cp_code;
		this.ord_code = ord_code;
	}
	public int getPay_code() {
		return pay_code;
	}
	public void setPay_code(int pay_code) {
		this.pay_code = pay_code;
	}
	public int getPay_method() {
		return pay_method;
	}
	public void setPay_method(int pay_method) {
		this.pay_method = pay_method;
	}
	public Date getPay_date() {
		return pay_date;
	}
	public void setPay_date(Date pay_date) {
		this.pay_date = pay_date;
	}
	public int getPay_price() {
		return pay_price;
	}
	public void setPay_price(int pay_price) {
		this.pay_price = pay_price;
	}
	public int getCp_code() {
		return cp_code;
	}
	public void setCp_code(int cp_code) {
		this.cp_code = cp_code;
	}
	public int getOrd_code() {
		return ord_code;
	}
	public void setOrd_code(int ord_code) {
		this.ord_code = ord_code;
	}
}
