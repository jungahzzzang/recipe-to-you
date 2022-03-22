package kr.co.recipetoyou.admin.adsend;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import kr.co.recipetoyou.util.PagingVO;

public interface AdSendController {

	public void listSendGET(PagingVO vo, Model model) throws Exception;
	
	public ModelAndView sendlistPageGet(PagingVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView getUserSendInfo(String id, HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView getOrderSendInfo(int ord, HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView getPaymentSendInfo(int pay, HttpServletRequest request, HttpServletResponse response) throws Exception;

 
	

}
