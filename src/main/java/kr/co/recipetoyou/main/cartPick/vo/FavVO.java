package kr.co.recipetoyou.main.cartPick.vo;
/*
 	--좋아요 테이블
	create table tb_fav(
    fav_flag_code       varchar2(10) 	NOT NULL 
    ,prod_code          varchar2(10)	NOT NULL 
    ,user_id            varchar2(30) 	NOT NULL 
    ,fav_flag           int				NOT NULL 
    ,primary key (fav_flag_code)
);
 */

import org.springframework.stereotype.Component;


//찜(좋아요) 담기
@Component("favVO")
public class FavVO {
	
	private String fav_flag_code;
	private String prod_code;
	private String user_id;
	private int fav_flag;
	
	public FavVO() {
		// TODO Auto-generated constructor stub
	}
	

	public FavVO(String fav_flag_code, String prod_code, String user_id, int fav_flag) {
		super();
		this.fav_flag_code = fav_flag_code;
		this.prod_code = prod_code;
		this.user_id = user_id;
		this.fav_flag = fav_flag;
	}


	public String getFav_flag_code() {
		return fav_flag_code;
	}

	public void setFav_flag_code(String fav_flag_code) {
		this.fav_flag_code = fav_flag_code;
	}

	public String getProd_code() {
		return prod_code;
	}

	public void setProd_code(String prod_code) {
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
	
	
}
