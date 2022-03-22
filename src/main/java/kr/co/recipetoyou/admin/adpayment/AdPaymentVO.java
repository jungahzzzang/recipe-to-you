package kr.co.recipetoyou.admin.adpayment;


import java.sql.Date;

import org.springframework.stereotype.Component;

import kr.co.recipetoyou.admin.adgoods.AdGoodsVO;
import kr.co.recipetoyou.admin.aduser.AdUserVO;

@Component("adPaymentVO")
public class AdPaymentVO {

	private int pay_code;
	private int pay_method;
	private Date pay_date;
	private int pay_price;
	private int cp_code;
	private int ord_code;
	
	//사용자	
	private AdUserVO adUserVO;
	private String user_id;
	private String user_name;
	private String user_phone;
	private String user_addr;
		
	private void AdUserVO() {
	}
		
	//상품
	private AdGoodsVO adGoodsVO;
	private String prod_name;
	private String prod_content;
		
	private void AdGoodsVO() {
	}
	
	public AdPaymentVO() {
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
	public AdUserVO getAdUserVO() {
		return adUserVO;
	}
	public void setAdUserVO(AdUserVO adUserVO) {
		this.adUserVO = adUserVO;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_addr() {
		return user_addr;
	}
	public void setUser_addr(String user_addr) {
		this.user_addr = user_addr;
	}
	public AdGoodsVO getAdGoodsVO() {
		return adGoodsVO;
	}
	public void setAdGoodsVO(AdGoodsVO adGoodsVO) {
		this.adGoodsVO = adGoodsVO;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getProd_content() {
		return prod_content;
	}
	public void setProd_content(String prod_content) {
		this.prod_content = prod_content;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public AdPaymentVO(int pay_code, int pay_method, Date pay_date, int pay_price, int cp_code, int ord_code,
			AdUserVO adUserVO, String user_id, String user_name, String user_phone,
			String user_addr, AdGoodsVO adGoodsVO, String prod_name,
			String prod_content) {
		super();
		this.pay_code = pay_code;
		this.pay_method = pay_method;
		this.pay_date = pay_date;
		this.pay_price = pay_price;
		this.cp_code = cp_code;
		this.ord_code = ord_code;
		this.adUserVO = adUserVO;
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_phone = user_phone;
		this.user_addr = user_addr;
		this.adGoodsVO = adGoodsVO;
		this.prod_name = prod_name;
		this.prod_content = prod_content;
	}
	
}
