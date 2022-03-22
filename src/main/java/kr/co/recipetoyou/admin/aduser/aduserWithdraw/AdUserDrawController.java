package kr.co.recipetoyou.admin.aduser.aduserWithdraw;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import kr.co.recipetoyou.util.PagingVO;

public interface AdUserDrawController {
	
	//=====================================================================================================
		//페이징처리한 글목록
		public void withdrawUsersGET(PagingVO vo, Model model) throws Exception;
		
		//탈퇴 회원 조회
		public ModelAndView withdrawPageGet(PagingVO vo, HttpServletRequest request, HttpServletResponse response)
				throws Exception;
		
		//탈퇴 회원 정보
		public ModelAndView adUserWithdraw(String id, HttpServletRequest request, HttpServletResponse response) throws Exception;

		//탈퇴 회원 정보 삭제
		public ModelAndView removeUserWithdraw(String id, HttpServletRequest request, HttpServletResponse response)
				throws Exception;

}
