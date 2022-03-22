package kr.co.recipetoyou.admin.adfaq;

import java.sql.Date;

import org.springframework.stereotype.Component;

//faq_code		NUMBER 			NOT NULL 
//,faq_info		varchar2(1500)	NOT NULL 
//,faq_confirm	NUMBER 			NOT NULL 
//,faq_reg_date	DATE	

@Component("adFAQVO")
public class AdFAQVO {

	public AdFAQVO() {
		System.out.println("AdFAQVO 호출");
	}
	
	private int faq_code;
	private String faq_title;
	private String faq_info;
	private Date faq_reg_date;

	//FAQ 카테고리 테이블 
	private AdFAQCategoryVO adFAQCategoryVO;
	private int faq_cate_code;
	private String faq_cate;

	
	public void setAdFAQCategoryVO(AdFAQCategoryVO adFAQCategoryVO) {
		this.adFAQCategoryVO = adFAQCategoryVO;
	}
	public int getFaq_cate_code() {
		return faq_cate_code;
	}
	public void setFaq_cate_code(int faq_cate_code) {
		this.faq_cate_code = faq_cate_code;
	}
	public String getFaq_cate() {
		return faq_cate;
	}
	public void setFaq_cate(String faq_cate) {
		this.faq_cate = faq_cate;
	}
	
		
	public String getFaq_title() {
		return faq_title;
	}
	public void setFaq_title(String faq_title) {
		this.faq_title = faq_title;
	}
	public int getFaq_code() {
		return faq_code;
	}
	public void setFaq_code(int faq_code) {
		this.faq_code = faq_code;
	}
	public String getFaq_info() {
		return faq_info;
	}
	public void setFaq_info(String faq_info) {
		this.faq_info = faq_info;
	}
	public AdFAQCategoryVO getAdFAQCategoryVO() {
		return adFAQCategoryVO;
	}
	public Date getFaq_reg_date() {
		return faq_reg_date;
	}
	public void setFaq_reg_date(Date faq_reg_date) {
		this.faq_reg_date = faq_reg_date;
	}
	
	
}
