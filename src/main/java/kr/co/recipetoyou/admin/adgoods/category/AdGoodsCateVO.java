package kr.co.recipetoyou.admin.adgoods.category;

import org.springframework.stereotype.Component;

/*
 *   prodCateCode      varchar2(10)	NOT NULL
    ,cateCode		  NUMBER     NOT NULL
    ,prod_code        number	NOT NULL
    ,cateName         varchar2(50)	NOT NULL
    ,cateParent		  varchar2(50)	
    ,cateGrade		  NUMBER     NOT NULL
 */

@Component("adGoodsCateVO")
public class AdGoodsCateVO {
	
	private String cateCode;
	private String cateName;
	private String cateParent;
	private int level;

	
	
	//추가
	//private String option="";
	//private String keyword="";
	
	
	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public AdGoodsCateVO() {
		// TODO Auto-generated constructor stub
	}


	public String getCateCode() {
		return cateCode;
	}


	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}


	public String getCateName() {
		return cateName;
	}


	public void setCateName(String cateName) {
		this.cateName = cateName;
	}


	public String getCateParent() {
		return cateParent;
	}


	public void setCateParent(String cateParent) {
		this.cateParent = cateParent;
	}

	
	//검색 타입 데이터 배열 변환
	/*
	 * public String[] getTypeArr() { return option == null? new String[] {} :
	 * option.split(""); }
	 * 
	 * public String getOption() { return option; }
	 * 
	 * public void setOption(String option) { this.option = option; }
	 * 
	 * public void setKeyword(String keyword) { this.keyword = keyword; }
	 */


	

	/*
	 * public String getKeyword() { return keyword; }
	 * 
	 * 
	 * @Override public String toString() { return super.toString() +
	 * "SearchOption [option=" + option + ", keword=" + keyword + "]"; }
	 */
	

}
