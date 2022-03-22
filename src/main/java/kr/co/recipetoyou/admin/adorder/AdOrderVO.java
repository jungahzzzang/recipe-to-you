package kr.co.recipetoyou.admin.adorder;

//<td>${ord.user_id }</td>
//<td>${ord.user_name }</td>
//<td>${ord.user_phone}</td>
//<td>${ord.user_addr }</td>
//<td>${ord.prod_name }</td>
//<td>${ord.prod_content }</td>
//<td>${ord.quantity }</td>
//<td>${ord.price }</td>
//<td>${ord.pay_card_idx }</td>
//<td>${ord.ord_date }</td>
import java.sql.Date;

import org.springframework.stereotype.Component;

import kr.co.recipetoyou.admin.adgoods.AdGoodsVO;
import kr.co.recipetoyou.admin.aduser.AdUserVO;

@Component("adOrderVO")
public class AdOrderVO {

	private int ord_code;
	private String user_id;
	private Date ord_date;	
	private int prod_code;
	private int quantity;
	private int price;
	private int status;
	
	public AdOrderVO() {
		
	}
	
	//사용자	
	private AdUserVO adUserVO;
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

	public AdOrderVO(int ord_code, String user_id, Date ord_date, int prod_code, int quantity, int price, int status,
			AdUserVO adUserVO, String user_name, String user_phone, String user_addr,
			AdGoodsVO adGoodsVO, String prod_name, String prod_content) {
		super();
		this.ord_code = ord_code;
		this.user_id = user_id;
		this.ord_date = ord_date;
		this.prod_code = prod_code;
		this.quantity = quantity;
		this.price = price;
		this.status = status;
		this.adUserVO = adUserVO;
		this.user_name = user_name;
		this.user_phone = user_phone;
		this.user_addr = user_addr;
		this.adGoodsVO = adGoodsVO;
		this.prod_name = prod_name;
		this.prod_content = prod_content;
	}

	public int getOrd_code() {
		return ord_code;
	}

	public void setOrd_code(int ord_code) {
		this.ord_code = ord_code;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Date getOrd_date() {
		return ord_date;
	}

	public void setOrd_date(Date ord_date) {
		this.ord_date = ord_date;
	}

	public int getProd_code() {
		return prod_code;
	}

	public void setProd_code(int prod_code) {
		this.prod_code = prod_code;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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
	
}
