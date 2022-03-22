package kr.co.recipetoyou.admin.adfaq;

import org.springframework.stereotype.Component;

@Component("adFAQCategoryVO")
public class AdFAQCategoryVO {

	private int faq_cate_code;
	private String faq_cate;
	private int faq_code;
	
	public AdFAQCategoryVO() {
		// TODO Auto-generated constructor stub
	}
	
	public AdFAQCategoryVO(int faq_cate_code, String faq_cate, int faq_code) {
		super();
		this.faq_cate_code = faq_cate_code;
		this.faq_cate = faq_cate;
		this.faq_code = faq_code;
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
	public int getFaq_code() {
		return faq_code;
	}
	public void setFaq_code(int faq_code) {
		this.faq_code = faq_code;
	}
	
}
