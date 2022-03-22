package kr.co.recipetoyou.admin.adpoint;

import org.springframework.stereotype.Component;

import kr.co.recipetoyou.user.UserVO;

@Component("adpointVO")
public class AdPointVO {
	
	private int point_code;
	private int point;
	private String user_id;
	private int ord_code;
	private int pay_code;
	
	//UserVO를 변수로 사용
	private UserVO userVO;
	
	public AdPointVO() {
		// TODO Auto-generated constructor stub
	}

	public AdPointVO(int point_code, int point, String user_id, int ord_code, int pay_code) {
		super();
		this.point_code = point_code;
		this.point = point;
		this.user_id = user_id;
		this.ord_code = ord_code;
		this.pay_code = pay_code;
	}
	
	
	//생성자 오버로딩 매개변수 UserVO추가.
	public AdPointVO(int point_code, int point, String user_id, int ord_code, int pay_code, UserVO userVO) {
		super();
		this.point_code = point_code;
		this.point = point;
		this.user_id = user_id;
		this.ord_code = ord_code;
		this.pay_code = pay_code;
		this.userVO = userVO;
	}
	
	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	public int getPoint_code() {
		return point_code;
	}

	public void setPoint_code(int point_code) {
		this.point_code = point_code;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
	
}
