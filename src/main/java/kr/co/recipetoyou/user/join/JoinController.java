package kr.co.recipetoyou.user.join;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.ModelAndView;

import kr.co.recipetoyou.user.UserVO;

public interface JoinController {
	
	public ModelAndView regist(@ModelAttribute("userVO") UserVO userVO,
			HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView registProcess(@ModelAttribute("userVO") UserVO userVO,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public int idChk(
			@RequestParam("_user_id") String _user_id,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public int mailChk(@RequestParam("user_mail") String user_mail,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public String sendSMS(@RequestParam("phone") String userPhoneNumber);
	
}
