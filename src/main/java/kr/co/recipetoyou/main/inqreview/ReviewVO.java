package kr.co.recipetoyou.main.inqreview;

import java.sql.Date;

import org.springframework.stereotype.Component;

import kr.co.recipetoyou.main.goods.GoodsVO;

@Component("reviewVO")
public class ReviewVO {

	//GoodsVO 상품명
	private GoodsVO goodsVO;
	private String prod_name;
	
	private int prod_review_code;
	private int prod_code;
	private String title;
	private Date reg_date;
	private String content;
	
	private String review_img;
	private String user_id;
	

	
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
	public int getProd_review_code() {
		return prod_review_code;
	}
	public void setProd_review_code(int prod_review_code) {
		this.prod_review_code = prod_review_code;
	}
	public int getProd_code() {
		return prod_code;
	}
	public void setProd_code(int prod_code) {
		this.prod_code = prod_code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public String getReview_img() {
		return review_img;
	}
	public void setReview_img(String review_img) {
		this.review_img = review_img;
	}
}
