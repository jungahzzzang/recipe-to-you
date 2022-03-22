package kr.co.recipetoyou.main.cartPick.vo;

import java.util.List; 

import org.springframework.stereotype.Component;

import kr.co.recipetoyou.admin.adgoods.AdgoodsImgVO;

//찜하기 테이블 TB_FAV 조회
@Component("pickVO")
public class PickVO {

	private int fav_flag_code;
	private int prod_code;
	private String user_id;
	private int fav_flag;
	private CartAddVO cartAddVO;
	
	//prodVO 테이블이랑 조인해서 조회
	private ProdVO prodVO;
	
	private String prod_name;
	private String prod_img;
	private int prod_price;
	private int prod_discount;
	
	/* 상품 이미지 */
	private List<AdgoodsImgVO> imageList;
	
	public PickVO() {
		// TODO Auto-generated constructor stub
	}
	

	public PickVO(int fav_flag_code, int prod_code, String user_id, int fav_flag, ProdVO prodVO, String prod_name,
			String prod_img, int prod_price, int prod_discount, List<AdgoodsImgVO> imageList) {
		super();
		this.fav_flag_code = fav_flag_code;
		this.prod_code = prod_code;
		this.user_id = user_id;
		this.fav_flag = fav_flag;
		this.prodVO = prodVO;
		this.prod_name = prod_name;
		this.prod_img = prod_img;
		this.prod_price = prod_price;
		this.prod_discount = prod_discount;
		this.imageList = imageList;
	}
	
	
	
	public PickVO(int fav_flag_code, int prod_code, String user_id, int fav_flag, CartAddVO cartAddVO, ProdVO prodVO,
			String prod_name, String prod_img, int prod_price, int prod_discount, List<AdgoodsImgVO> imageList) {
		super();
		this.fav_flag_code = fav_flag_code;
		this.prod_code = prod_code;
		this.user_id = user_id;
		this.fav_flag = fav_flag;
		this.cartAddVO = cartAddVO;
		this.prodVO = prodVO;
		this.prod_name = prod_name;
		this.prod_img = prod_img;
		this.prod_price = prod_price;
		this.prod_discount = prod_discount;
		this.imageList = imageList;
	}


	public CartAddVO getCartAddVO() {
		return cartAddVO;
	}


	public void setCartAddVO(CartAddVO cartAddVO) {
		this.cartAddVO = cartAddVO;
	}


	public List<AdgoodsImgVO> getImageList() {
		return imageList;
	}
	public void setImageList(List<AdgoodsImgVO> imageList) {
		this.imageList = imageList;
	}
	public int getFav_flag_code() {
		return fav_flag_code;
	}
	public void setFav_flag_code(int fav_flag_code) {
		this.fav_flag_code = fav_flag_code;
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
	public int getFav_flag() {
		return fav_flag;
	}
	public void setFav_flag(int fav_flag) {
		this.fav_flag = fav_flag;
	}

	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
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


	@Override
	public String toString() {
		return "PickVO [fav_flag_code=" + fav_flag_code + ", prod_code=" + prod_code + ", user_id=" + user_id
				+ ", fav_flag=" + fav_flag + ", cartAddVO=" + cartAddVO + ", prodVO=" + prodVO + ", prod_name="
				+ prod_name + ", prod_img=" + prod_img + ", prod_price=" + prod_price + ", prod_discount="
				+ prod_discount + ", imageList=" + imageList + "]";
	}
	
	
	
	
}
