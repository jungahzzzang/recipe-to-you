package kr.co.recipetoyou.admin.adrecipe;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import kr.co.recipetoyou.util.PagingVO;

public interface AdRecipeController {

	void listRecipeGET(PagingVO vo, Model model) throws Exception;

	ModelAndView lisRecipePageGet(PagingVO vo, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	ModelAndView getRecipeInfo(String id, HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView removePay(String id, HttpServletRequest request, HttpServletResponse response) throws Exception;

}
