package kr.co.recipetoyou.admin.aduser.aduserWithdraw;

import java.sql.Date;

import org.springframework.stereotype.Component;

/*
 * 	user_withdraw		varchar2(30)	NOT NULL
 * 	,user_id            varchar2(30)	NOT NULL 
    ,user_pw            varchar2(30)	NOT NULL	
    ,user_name          varchar2(30)	NOT NULL 
    ,user_email         varchar2(100)	NOT NULL 
    ,user_phone         varchar2(20)	NOT NULL 
    ,user_addr          varchar2(500)	NOT NULL 
    ,user_gender        int				NOT NULL 
    ,user_birth         varchar2(30)	NOT NULL 
    ,recommendId        varchar2(30)
    ,join_event         varchar2(100)
    ,info_agree         int
    ,sms_agree          int
    ,email_agree        int
    ,join_date          DATE			DEFAULT		sysdate 
    ,user_grade         int
    ,user_point         int
    ,cp_code            int
    ,toYou_pass         varchar2(10)
 */

@Component("aduserDrawVO")
public class AdUserDrawVO {
	
	private String user_withdraw;
	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_email;
	private String user_phone;
	private String user_addr;
	private int user_gender;
	private String user_birth;
	private String recommendId;
	private String join_event;
	private int info_agree;
	private int sms_agree;
	private int email_agree;
	private Date join_date;
	private int user_grade;
	private int user_point;
	private int cp_code;
	private String toYou_pass;
	
	public AdUserDrawVO() {
		// TODO Auto-generated constructor stub
	}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_addr() {
		return user_addr;
	}
	public void setUser_addr(String user_addr) {
		this.user_addr = user_addr;
	}
	public int getUser_gender() {
		return user_gender;
	}
	public void setUser_gender(int user_gender) {
		this.user_gender = user_gender;
	}
	public String getUser_birth() {
		return user_birth;
	}
	public void setUser_birth(String user_birth) {
		this.user_birth = user_birth;
	}
	public String getRecommendId() {
		return recommendId;
	}
	public void setRecommendId(String recommendId) {
		this.recommendId = recommendId;
	}
	public String getJoin_event() {
		return join_event;
	}
	public void setJoin_event(String join_event) {
		this.join_event = join_event;
	}
	public int getInfo_agree() {
		return info_agree;
	}
	public void setInfo_agree(int info_agree) {
		this.info_agree = info_agree;
	}
	public int getSms_agree() {
		return sms_agree;
	}
	public void setSms_agree(int sms_agree) {
		this.sms_agree = sms_agree;
	}
	public int getEmail_agree() {
		return email_agree;
	}
	public void setEmail_agree(int email_agree) {
		this.email_agree = email_agree;
	}
	public Date getJoin_date() {
		return join_date;
	}
	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}
	public int getUser_grade() {
		return user_grade;
	}
	public void setUser_grade(int user_grade) {
		this.user_grade = user_grade;
	}
	public int getUser_point() {
		return user_point;
	}
	public void setUser_point(int user_point) {
		this.user_point = user_point;
	}
	public int getCp_code() {
		return cp_code;
	}
	public void setCp_code(int cp_code) {
		this.cp_code = cp_code;
	}
	public String getToYou_pass() {
		return toYou_pass;
	}
	public void setToYou_pass(String toYou_pass) {
		this.toYou_pass = toYou_pass;
	}

	public String getUser_withdraw() {
		return user_withdraw;
	}

	public void setUser_withdraw(String user_withdraw) {
		this.user_withdraw = user_withdraw;
	}

}
