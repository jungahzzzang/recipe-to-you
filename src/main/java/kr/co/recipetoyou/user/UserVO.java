package kr.co.recipetoyou.user;

import java.sql.Date;

import org.springframework.stereotype.Component;

import kr.co.recipetoyou.main.goods.GoodsVO;

@Component("userVO")
public class UserVO {
	
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
	private int user_point;//point_code
	private int cp_code;
	private String toYou_pass;
	
	public UserVO() {
		// TODO Auto-generated constructor stub
	}
	
	public UserVO(String user_id, String user_pw) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
	}
	

	public UserVO(String user_id, String user_pw, String user_name, String user_email, String user_phone,
			String user_addr, int user_gender, String user_birth) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_phone = user_phone;
		this.user_addr = user_addr;
		this.user_gender = user_gender;
		this.user_birth = user_birth;
	}



	public UserVO(String user_id, String user_pw, String user_name, String user_email, String user_phone,
			String user_addr, int user_gender, String user_birth, String recommendId, String join_event, int info_agree,
			int sms_agree, int email_agree, Date join_date, int user_grade, int user_point, int cp_code,
			String toYou_pass) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_phone = user_phone;
		this.user_addr = user_addr;
		this.user_gender = user_gender;
		this.user_birth = user_birth;
		this.recommendId = recommendId;
		this.join_event = join_event;
		this.info_agree = info_agree;
		this.sms_agree = sms_agree;
		this.email_agree = email_agree;
		this.join_date = join_date;
		this.user_grade = user_grade;
		this.user_point = user_point;
		this.cp_code = cp_code;
		this.toYou_pass = toYou_pass;
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



	@Override
	public String toString() {
		return "UserVO [user_id=" + user_id + ", user_pw=" + user_pw + ", user_name=" + user_name + ", user_email="
				+ user_email + ", user_phone=" + user_phone + ", user_addr=" + user_addr + ", user_gender="
				+ user_gender + ", user_birth=" + user_birth + ", recommendId=" + recommendId + ", join_event="
				+ join_event + ", info_agree=" + info_agree + ", sms_agree=" + sms_agree + ", email_agree="
				+ email_agree + ", join_date=" + join_date + ", user_grade=" + user_grade + ", user_point=" + user_point
				+ ", cp_code=" + cp_code + ", toYou_pass=" + toYou_pass + "]";
	}
	
	

	
}

