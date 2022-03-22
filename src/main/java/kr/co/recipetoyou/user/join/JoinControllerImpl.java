package kr.co.recipetoyou.user.join;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.recipetoyou.user.UserVO;

@Controller("joinController")

public class JoinControllerImpl implements JoinController {
	@Autowired
	private JoinService joinService;
	@Autowired
	private UserVO userVO;
	
	@RequestMapping(value="/join/regist.do",  method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView regist(@ModelAttribute("userVO") UserVO userVO,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView();		
		return mav;
		
	}
	
	@RequestMapping(value="/join/joinProcess.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView registProcess(@ModelAttribute("userVO") UserVO userVO,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		int result = joinService.addUser(userVO); 	//정상적 inset하면 정수 1을 리턴
		
		ModelAndView mav = new ModelAndView("redirect:/login/login.do");
		return mav;
	}		
		 
	@RequestMapping(value = "/user/idChk.do", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public int idChk(
			@RequestParam("user_id") String user_id,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		int result = joinService.idChk(user_id);
		System.out.println("중복확인값:"+result);
		return result;
	}
	
	@RequestMapping(value = "/user/mailChk.do", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public int mailChk(@RequestParam("user_mail") String user_mail,HttpServletRequest request, HttpServletResponse response) throws Exception {
		int result = joinService.mailChk(user_mail);
		return result;
	}
	
	@RequestMapping(value = "/user/phoneCheck.do", method = RequestMethod.GET) 
	@ResponseBody 
	public String sendSMS(@RequestParam("phone") String userPhoneNumber) { 
		int randomNumber = (int)((Math.random()* (9999 - 1000 + 1)) + 1000);
		joinService.certifiedPhoneNumber(userPhoneNumber,randomNumber); 
		return Integer.toString(randomNumber); 
	}
}

