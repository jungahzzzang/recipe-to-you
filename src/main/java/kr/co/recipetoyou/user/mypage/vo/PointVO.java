package kr.co.recipetoyou.user.mypage.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("pointVO")
public class PointVO {

	//포인트 테이블
	private PointUseVO pointuseVO;
	private int point;
	
	//포인트 내역
	private int point_details_code;
	private Date accum_date;
	private Date use_date;
	private String point_content;
	private int point_code;
	private String user_id;
	private int pay_code;
	private int ord_code;
	
	
	public int getPoint_details_code() {
		return point_details_code;
	}
	public void setPoint_details_code(int point_details_code) {
		this.point_details_code = point_details_code;
	}
	public Date getAccum_date() {
		return accum_date;
	}
	public void setAccum_date(Date accum_date) {
		this.accum_date = accum_date;
	}
	public Date getUse_date() {
		return use_date;
	}
	public void setUse_date(Date use_date) {
		this.use_date = use_date;
	}
	public String getPoint_content() {
		return point_content;
	}
	public void setPoint_content(String point_content) {
		this.point_content = point_content;
	}
	public int getPoint_code() {
		return point_code;
	}
	public void setPoint_code(int point_code) {
		this.point_code = point_code;
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
	
	//포인트 테이블
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}

	
	
	
	
	
	
}
