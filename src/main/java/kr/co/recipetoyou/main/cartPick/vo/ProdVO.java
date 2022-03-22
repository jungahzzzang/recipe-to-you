package kr.co.recipetoyou.main.cartPick.vo;

import java.sql.Date;  
import java.util.List;

import org.springframework.stereotype.Component;

import kr.co.recipetoyou.admin.adgoods.AdgoodsImgVO;
import kr.co.recipetoyou.user.UserVO;
import kr.co.recipetoyou.user.mypage.vo.UserAddrVO;



//상품 테이블 TB_PROD
@Component("prodVO")
public class ProdVO {
	
	private int prod_code;
	private String catecode;
	private String prod_name;
	private String prod_content;
	private int prod_price;
	private int prod_discount;
	private int prod_sell_unit;
	private int prod_delivery_type;
	private int prod_wrap_type;
	private String prod_info;
	private String prod_allergy;
	private String prod_from;
	private String prod_caution;
	private int prod_quantity;
	private String prod_point;
	private Date prod_reg_date;
	private Date prod_vaild_date;
	
	private String user_id;
	private String addr;
	private String delivery_type;
	
	/* 상품 이미지 */
	private List<AdgoodsImgVO> imageList;
	

	//사용자 주소 테이블
	private UserAddrVO useraddrVO;
	
	//장바구니 CartAddVO
	private CartAddVO cartAddVO;
	
	private UserVO userVO;
	
	public ProdVO() {
		// TODO Auto-generated constructor stub
	}	
		
	

	

	public ProdVO(int prod_code, String catecode, String prod_name, String prod_content, int prod_price,
			int prod_discount, int prod_sell_unit, int prod_delivery_type, int prod_wrap_type, String prod_info,
			String prod_allergy, String prod_from, String prod_caution, int prod_quantity, String prod_point,
			Date prod_reg_date, Date prod_vaild_date, String user_id, String addr, String delivery_type,
			List<AdgoodsImgVO> imageList, UserAddrVO useraddrVO, CartAddVO cartAddVO, UserVO userVO) {
		super();
		this.prod_code = prod_code;
		this.catecode = catecode;
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
		this.prod_quantity = prod_quantity;
		this.prod_point = prod_point;
		this.prod_reg_date = prod_reg_date;
		this.prod_vaild_date = prod_vaild_date;
		this.user_id = user_id;
		this.addr = addr;
		this.delivery_type = delivery_type;
		this.imageList = imageList;
		this.useraddrVO = useraddrVO;
		this.cartAddVO = cartAddVO;
		this.userVO = userVO;
	}



	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	public String getDelivery_type() {
		return delivery_type;
	}

	public void setDelivery_type(String delivery_type) {
		this.delivery_type = delivery_type;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public CartAddVO getCartAddVO() {
		return cartAddVO;
	}
	public void setCartAddVO(CartAddVO cartAddVO) {
		this.cartAddVO = cartAddVO;
	}
	public int getProd_code() {
		return prod_code;
	}
	public void setProd_code(int prod_code) {
		this.prod_code = prod_code;
	}
	public String getCatecode() {
		return catecode;
	}
	public void setCatecode(String catecode) {
		this.catecode = catecode;
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
	public String getProd_point() {
		return prod_point;
	}
	public void setProd_point(String prod_point) {
		this.prod_point = prod_point;
	}
	public Date getProd_reg_date() {
		return prod_reg_date;
	}
	public void setProd_reg_date(Date prod_reg_date) {
		this.prod_reg_date = prod_reg_date;
	}
	public Date getProd_vaild_date() {
		return prod_vaild_date;
	}
	public void setProd_vaild_date(Date prod_vaild_date) {
		this.prod_vaild_date = prod_vaild_date;
	}
	public List<AdgoodsImgVO> getImageList() {
		return imageList;
	}
	public void setImageList(List<AdgoodsImgVO> imageList) {
		this.imageList = imageList;
	}
	public UserAddrVO getUseraddrVO() {
		return useraddrVO;
	}
	public void setUseraddrVO(UserAddrVO useraddrVO) {
		this.useraddrVO = useraddrVO;
	}
	
	
	

	

}











