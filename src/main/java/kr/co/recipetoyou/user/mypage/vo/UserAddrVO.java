package kr.co.recipetoyou.user.mypage.vo;

import org.springframework.stereotype.Component;   

import kr.co.recipetoyou.user.UserVO;

//사용자 주소 테이블
@Component("useraddrVO")
public class UserAddrVO {
	
	private String addr_code;
	private String addr;
	private String user_id;
	private String delivery_type;
	
	//사용자 테이블
	private UserVO userVO;
	private String user_name;
	private String user_phone;
	
	
	public UserAddrVO() {
		System.out.println("useraddrVO 호출");
	}
	
	
	public String getAddr_code() {
		return addr_code;
	}
	public void setAddr_code(String addr_code) {
		this.addr_code = addr_code;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getDelivery_type() {
		return delivery_type;
	}
	public void setDelivery_type(String delivery_type) {
		this.delivery_type = delivery_type;
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
	
	
	
	

}
