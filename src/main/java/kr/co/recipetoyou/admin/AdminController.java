package kr.co.recipetoyou.admin;

import java.util.List;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import kr.co.recipetoyou.admin.AdminVO;
import kr.co.recipetoyou.user.UserVO;

public interface AdminController {
	
	//메인
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	//관리자 로그인
	public ModelAndView login(@ModelAttribute("admin") AdminVO admin, RedirectAttributes rAttr,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	//관리자 로그아웃
	public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	

}
