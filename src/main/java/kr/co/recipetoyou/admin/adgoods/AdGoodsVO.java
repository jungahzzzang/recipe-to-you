package kr.co.recipetoyou.admin.adgoods;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Repository;


import kr.co.recipetoyou.admin.adgoods.category.AdGoodsCateVO;

@Repository("adgoodsVO")

public class AdGoodsVO {
	
	private int prod_code;
	private int cateCode;		//상품 등록 시 카테고리 조인하기 위해 추가
	private String prod_name;
	private String prod_content;
	private int prod_price;
	private int prod_discount;
	private int prod_sell_unit;
	private int prod_delivery_type;
	private int prod_wrap_type;
	private String prod_info;
	private String prod_allergy;
	private String prod_vaild_date;
	private String prod_from;
	private String prod_caution;
	private int stock_quantity;	//재고 수량, 재고관리 테이블과 조인
	private Date prod_reg_date;
	private AdGoodsCateVO adGoodsCateVO;	 	//상품 조회 시 카테고리 함께 조회하기 위해 추가
	private List<AdgoodsImgVO> imageList;		//이미지 정보
	private String cateName;
	private String cateParent;
	private int quantity;
	private int stock_status;

	

	public String getCateParent() {
		return cateParent;
	}

	public void setCateParent(String cateParent) {
		this.cateParent = cateParent;
	}

	public AdGoodsVO() {
		// TODO Auto-generated constructor stub
	}
	
	public AdGoodsVO(int prod_code, String prod_name, String prod_content, int prod_price,
			int prod_discount, int prod_sell_unit, int prod_delivery_type, int prod_wrap_type, String prod_info,
			String prod_allergy, String prod_from, String prod_caution) {
		super();
		this.prod_code = prod_code;
		this.prod_name = prod_name;
		this.prod_content = prod_content;
		this.prod_price = prod_price;
		this.prod_discount = prod_discount;
		this.prod_sell_unit = prod_sell_unit;
		this.prod_delivery_type = prod_delivery_type;
		this.prod_wrap_type = prod_wrap_type;
		this.prod_info = prod_info;
		this.prod_allergy = prod_allergy;
		this.prod_from = prod_from;
		this.prod_caution = prod_caution;
	}

	public int getProd_code() {
		return prod_code;
	}
	public void setProd_code(int prod_code) {
		this.prod_code = prod_code;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getProd_content() {
		return prod_content;
	}
	public void setProd_content(String prod_content) {
		this.prod_content = prod_content;
	}
	
	public int getProd_price() {
		return prod_price;
	}
	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}
	public int getProd_discount() {
		return prod_discount;
	}
	public void setProd_discount(int prod_discount) {
		this.prod_discount = prod_discount;
	}
	public int getProd_sell_unit() {
		return prod_sell_unit;
	}
	public void setProd_sell_unit(int prod_sell_unit) {
		this.prod_sell_unit = prod_sell_unit;
	}
	public int getProd_delivery_type() {
		return prod_delivery_type;
	}
	public void setProd_delivery_type(int prod_delivery_type) {
		this.prod_delivery_type = prod_delivery_type;
	}
	public int getProd_wrap_type() {
		return prod_wrap_type;
	}
	public void setProd_wrap_type(int prod_wrap_type) {
		this.prod_wrap_type = prod_wrap_type;
	}
	public String getProd_info() {
		return prod_info;
	}
	public void setProd_info(String prod_info) {
		this.prod_info = prod_info;
	}
	public String getProd_allergy() {
		return prod_allergy;
	}
	public void setProd_allergy(String prod_allergy) {
		this.prod_allergy = prod_allergy;
	}
	public String getProd_vaild_date() {
		return prod_vaild_date;
	}
	public void setProd_vaild_date(String prod_vaild_date) {
		this.prod_vaild_date = prod_vaild_date;
	}
	public String getProd_from() {
		return prod_from;
	}
	public void setProd_from(String prod_from) {
		this.prod_from = prod_from;
	}
	public String getProd_caution() {
		return prod_caution;
	}
	public void setProd_caution(String prod_caution) {
		this.prod_caution = prod_caution;
	}

	public Date getProd_reg_date() {
		return prod_reg_date;
	}
	public int getStock_quantity() {
		return stock_quantity;
	}

	public AdGoodsCateVO getAdGoodsCateVO() {
		return adGoodsCateVO;
	}



	public void setAdGoodsCateVO(AdGoodsCateVO adGoodsCateVO) {
		this.adGoodsCateVO = adGoodsCateVO;
	}

	public void setStock_quantity(int stock_quantity) {
		this.stock_quantity = stock_quantity;
	}



	public List<AdgoodsImgVO> getImageList() {
		return imageList;
	}



	public void setImageList(List<AdgoodsImgVO> imageList) {
		this.imageList = imageList;
	}



	public void setProd_reg_date(Date prod_reg_date) {
		this.prod_reg_date = prod_reg_date;
	}
	
	
	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	
	public int getCateCode() {
		return cateCode;
	}



	public void setCateCode(int cateCode) {
		this.cateCode = cateCode;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getStock_status() {
		return stock_status;
	}

	public void setStock_status(int stock_status) {
		this.stock_status = stock_status;
	}

	@Override
	public String toString() {
		return "AdGoodsVO [prod_code=" + prod_code + ", cateCode=" + cateCode + ", prod_name=" + prod_name
				+ ", prod_content=" + prod_content + ", prod_price=" + prod_price + ", prod_discount=" + prod_discount
				+ ", prod_sell_unit=" + prod_sell_unit + ", prod_delivery_type=" + prod_delivery_type
				+ ", prod_wrap_type=" + prod_wrap_type + ", prod_info=" + prod_info + ", prod_allergy=" + prod_allergy
				+ ", prod_vaild_date=" + prod_vaild_date + ", prod_from=" + prod_from + ", prod_caution=" + prod_caution
				+ ", stock_quantity=" + stock_quantity + ", prod_reg_date=" + prod_reg_date + ", adGoodsCateVO="
				+ adGoodsCateVO + ", imageList=" + imageList + ", cateName=" + cateName + ", cateParent=" + cateParent
				+ ", quantity=" + quantity + ", stock_status=" + stock_status + "]";
	}
	
	
}
