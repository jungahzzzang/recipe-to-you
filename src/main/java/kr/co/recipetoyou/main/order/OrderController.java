package kr.co.recipetoyou.main.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface OrderController {
	
	public ModelAndView order(
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public String orderReg(
			 @RequestParam(value="cart_code[]") List<String> cart_code,
			 @RequestParam(value="quantity[]") List<String> quantity,
			HttpServletRequest request, HttpServletResponse response) throws Exception;

}
