package kr.co.recipetoyou.main.cartPick.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import kr.co.recipetoyou.admin.adgoods.AdgoodsImgVO;
import kr.co.recipetoyou.user.UserVO;



//장바구니 담기
@Component("cartAddVO")
public class CartAddVO {
	
	private int cart_code;
	private int prod_code;
	private int prod_quantity;
	private String user_id;

	
	
	public CartAddVO() {
		// TODO Auto-generated constructor stub
	}

	public CartAddVO(int cart_code, int prod_code, int prod_quantity, String user_id) {
		//super();
		this.cart_code = cart_code;
		this.prod_code = prod_code;
		this.prod_quantity = prod_quantity;
		this.user_id = user_id;
	}

	public int getCart_code() {
		return cart_code;
	}

	public void setCart_code(int cart_code) {
		this.cart_code = cart_code;
	}

	public int getProd_code() {
		return prod_code;
	}

	public void setProd_code(int prod_code) {
		this.prod_code = prod_code;
	}

	public int getProd_quantity() {
		return prod_quantity;
	}

	public void setProd_quantity(int prod_quantity) {
		this.prod_quantity = prod_quantity;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "CartAddVO [cart_code=" + cart_code + ", prod_code=" + prod_code + ", prod_quantity=" + prod_quantity
				+ ", user_id=" + user_id + "]";
	}
	
	

}
