package kr.co.recipetoyou.admin.adpayment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import kr.co.recipetoyou.util.PagingVO;

public interface AdPaymentController {

	void listPayGET(PagingVO vo, Model model) throws Exception;

	ModelAndView listPayPageGet(PagingVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView getPayInfo(int id, HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView removePay(int id, HttpServletRequest request, HttpServletResponse response) throws Exception;

}
