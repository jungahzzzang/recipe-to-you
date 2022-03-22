package kr.co.recipetoyou.user.mypage.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

import kr.co.recipetoyou.main.goods.GoodsVO;

@Component("qnaVO")
public class QnAVO {
	
	private GoodsVO goodsVO;
	private String prod_name;

	private int prod_inq_code;
	private int prod_code;
	private String user_id;
	private String inq_title;
	private String inq_content;
	private Date inq_reg_date;
	private int inq_status;
	private int inq_secret;
	
	public int getProd_inq_code() {
		return prod_inq_code;
	}
	public void setProd_inq_code(int prod_inq_code) {
		this.prod_inq_code = prod_inq_code;
	}
	public int getProd_code() {
		return prod_code;
	}
	public void setProd_code(int prod_code) {
		this.prod_code = prod_code;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getInq_title() {
		return inq_title;
	}
	public void setInq_title(String inq_title) {
		this.inq_title = inq_title;
	}
	public String getInq_content() {
		return inq_content;
	}
	public void setInq_content(String inq_content) {
		this.inq_content = inq_content;
	}
	public Date getInq_reg_date() {
		return inq_reg_date;
	}
	public void setInq_reg_date(Date inq_reg_date) {
		this.inq_reg_date = inq_reg_date;
	}
	public int getInq_status() {
		return inq_status;
	}
	public void setInq_status(int inq_status) {
		this.inq_status = inq_status;
	}
	public int getInq_secret() {
		return inq_secret;
	}
	public void setInq_secret(int inq_secret) {
		this.inq_secret = inq_secret;
	}
	public GoodsVO getGoodsVO() {
		return goodsVO;
	}
	public void setGoodsVO(GoodsVO goodsVO) {
		this.goodsVO = goodsVO;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	
	
}
