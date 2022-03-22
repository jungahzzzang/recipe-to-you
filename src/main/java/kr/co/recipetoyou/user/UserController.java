package kr.co.recipetoyou.user;

import java.util.Map;

import javax.activation.CommandMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.recipetoyou.util.PagingVO;

public interface UserController {
	
	public ModelAndView listPageGet(PagingVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	//전체 회원목록 조회 및 페이징 처리
	public void listUsersGET(PagingVO vo, Model model) throws Exception;
	
	//회원 상세 정보 조회
	public ModelAndView getUserInfo(@RequestParam(value="id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception;
		
	//회원 정보 수정
	public ModelAndView updateAction(@ModelAttribute UserVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception;
		
	//회원 정보 수정 페이지로 이동
	public ModelAndView updateUserInfo(@RequestParam(value="id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception;
		
	//회원 정보 삭제
	public ModelAndView removeUser(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception;


}
