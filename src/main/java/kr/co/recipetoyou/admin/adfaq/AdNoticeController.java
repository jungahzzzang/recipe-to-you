package kr.co.recipetoyou.admin.adfaq;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import kr.co.recipetoyou.util.PagingVO;

public interface AdNoticeController {

	void listNoticeGET(PagingVO vo, Model model) throws Exception;

	ModelAndView listNoitcePageGet(PagingVO vo, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	ModelAndView getNoticeInfo(String id, HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView removeNotice(String id, HttpServletRequest request, HttpServletResponse response) throws Exception;

}
