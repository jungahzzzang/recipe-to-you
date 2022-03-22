package kr.co.recipetoyou.main.goods;
import java.sql.Date;
import java.util.List;

/*
 create table tb_prod(
    prod_code           varchar2(10)	NOT NULL	
    ,prod_name          varchar2(50)	NOT NULL	
    ,prod_content       varchar2(300)	NOT NULL	
    ,prod_img           varchar2(500)	NOT NULL	
    ,prod_price         int				NOT NULL
    ,prod_discount      int						
    ,prod_sell_unit     int				NOT NULL
    ,prod_delivery_type int				NOT NULL
    ,prod_wrap_type     int				NOT NULL
    ,prod_info          varchar2(500)	NOT NULL
    ,prod_allergy       varchar2(1500)	NOT NULL
    ,prod_vaild_date    DATE			NOT NULL
    ,prod_from          varchar2(500)	NOT NULL
    ,prod_caution       varchar2(1500)	NOT NULL
    ,prod_quantity      int				NOT NULL
    ,prod_reg_date      DATE			DEFAULT		sysdate 
    ,primary key (prod_code)
);
 */
import org.springframework.stereotype.Repository;

import kr.co.recipetoyou.admin.adgoods.AdgoodsImgVO;

@Repository("goodsVO")
public class GoodsVO {
	
	private int prod_code;
	private String prodcatecode;
	private String prod_name;
	private String prod_content;
	private String prod_img;
	private int prod_price;
	private int prod_discount;
	private int prod_sell_unit;
	private int prod_delivery_type;
	private int prod_wrap_type;
	private String prod_info;
	private String prod_allergy;
	private Date prod_vaild_date;
	private String prod_from;
	private String prod_caution;
	private int prod_quantity;
	private Date prod_reg_date;
	private List<AdgoodsImgVO> imageList;


	public GoodsVO() {
		// TODO Auto-generated constructor stub
	}


	public GoodsVO(int prod_code, String prod_name, String prod_content, String prod_img, int prod_price,
			int prod_discount, int prod_sell_unit, int prod_delivery_type, int prod_wrap_type, String prod_info,
			String prod_allergy, Date prod_vaild_date, String prod_from, String prod_caution, int prod_quantity,
			Date prod_reg_date) {
		super();
		this.prod_code = prod_code;
		this.prod_name = prod_name;
		this.prod_content = prod_content;
		this.prod_img = prod_img;
		this.prod_price = prod_price;
		this.prod_discount = prod_discount;
		this.prod_sell_unit = prod_sell_unit;
		this.prod_delivery_type = prod_delivery_type;
		this.prod_wrap_type = prod_wrap_type;
		this.prod_info = prod_info;
		this.prod_allergy = prod_allergy;
		this.prod_vaild_date = prod_vaild_date;
		this.prod_from = prod_from;
		this.prod_caution = prod_caution;
		this.prod_quantity = prod_quantity;
		this.prod_reg_date = prod_reg_date;
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


	public String getProd_img() {
		return prod_img;
	}


	public void setProd_img(String prod_img) {
		this.prod_img = prod_img;
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


	public Date getProd_vaild_date() {
		return prod_vaild_date;
	}


	public void setProd_vaild_date(Date prod_vaild_date) {
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


	public int getProd_quantity() {
		return prod_quantity;
	}


	public void setProd_quantity(int prod_quantity) {
		this.prod_quantity = prod_quantity;
	}


	public Date getProd_reg_date() {
		return prod_reg_date;
	}


	public void setProd_reg_date(Date prod_reg_date) {
		this.prod_reg_date = prod_reg_date;
	}
	
	public List<AdgoodsImgVO> getImageList() {
		return imageList;
	}


	public void setImageList(List<AdgoodsImgVO> imageList) {
		this.imageList = imageList;
	}
	
	

}
