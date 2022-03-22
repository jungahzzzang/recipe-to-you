package kr.co.recipetoyou.user.mypage.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("pointuseVO")
public class PointUseVO {
	
	/*
	 * private int point_details_code; private Date accum_date; private Date
	 * use_date; private int use_flag; private String point_content; private PointVO
	 * pointVO; private int point;
	 */
	
	private String point_code;
	private int point;
	private String ord_code;
	private String pay_code;
	
	public String getPoint_code() {
		return point_code;
	}
	public void setPoint_code(String point_code) {
		this.point_code = point_code;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getOrd_code() {
		return ord_code;
	}
	public void setOrd_code(String ord_code) {
		this.ord_code = ord_code;
	}
	public String getPay_code() {
		return pay_code;
	}
	public void setPay_code(String pay_code) {
		this.pay_code = pay_code;
	}
	
	

}
