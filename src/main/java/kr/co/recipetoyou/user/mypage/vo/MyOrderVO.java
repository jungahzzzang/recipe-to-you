package kr.co.recipetoyou.user.mypage.vo;

import java.sql.Date; 

import java.util.List;

import org.springframework.stereotype.Component;

import kr.co.recipetoyou.admin.adgoods.AdgoodsImgVO;
import kr.co.recipetoyou.main.cartPick.vo.ProdVO;
import kr.co.recipetoyou.user.UserVO;


@Component("myorderVO")
public class MyOrderVO {
	
	private int ord_code;
	private int prod_code;
	private int quantity;	//수량
	private int price;		//주문 총액
	private int status;
	private String user_id;
	private Date ord_date;
	
	//상품 테이블
	private ProdVO prodVO;
	private String prod_name;
	private String prod_discount;
	private int prod_price;  //상품 가격
	private String prod_content;
	
	
	/* 상품 이미지 */
	private List<AdgoodsImgVO> imageList;
	

	public int getOrd_code() {
		return ord_code;
	}
	public void setOrd_code(int ord_code) {
		this.ord_code = ord_code;
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

	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getProd_discount() {
		return prod_discount;
	}
	public void setProd_discount(String prod_discount) {
		this.prod_discount = prod_discount;
	}
	public String getProd_content() {
		return prod_content;
	}
	public void setProd_content(String prod_content) {
		this.prod_content = prod_content;
	}

	public List<AdgoodsImgVO> getImageList() {
		return imageList;
	}
	
	public void setImageList(List<AdgoodsImgVO> imageList) {
		this.imageList = imageList;
	}

	//상품 가격
	public int getProd_price() {
		return prod_price;
	}
	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}
	
	@Override
	public String toString() {
		return "MyOrderVO [ord_code="+ord_code+", prod_code="+prod_code+", quantity="+quantity+
				", price="+price+", status"+status+",user_id="+user_id+", ord_date="+ord_date+
				",prod_name="+prod_name+", prod_discount"+", prod_content="+prod_content+",prod_price="+prod_price+"]";
	}
}
