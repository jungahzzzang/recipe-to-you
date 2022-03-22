package kr.co.recipetoyou.admin.adpoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.recipetoyou.util.PagingVO;

public interface AdPointController {
	
	public ModelAndView userPoint(@ModelAttribute("adPointVO") AdPointVO adPointVO,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	
	//public void listPointGET(PagingVO vo, Model model) throws Exception;

	//포인트 로그는 나중에하기로 했음
	public ModelAndView pointRecord(HttpServletRequest request, HttpServletResponse response) throws Exception;

	

}
