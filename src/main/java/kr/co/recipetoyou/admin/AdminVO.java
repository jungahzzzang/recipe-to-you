package kr.co.recipetoyou.admin;

import org.springframework.stereotype.Component;

@Component("adminVO")
public class AdminVO {

	private String adminId;
	private String adminPw;
	private String adminName;
	private String adminPhone;
	
	public AdminVO() {
		System.out.println("adminVo 호출");
	}

	public AdminVO(String adminId, String adminPw, String adminName, String adminPhone) {
		super();
		this.adminId = adminId;
		this.adminPw = adminPw;
		this.adminName = adminName;
		this.adminPhone = adminPhone;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPw() {
		return adminPw;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPhone() {
		return adminPhone;
	}

	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}
	
	

	

	
	
	
	
	
	
	
	
}
