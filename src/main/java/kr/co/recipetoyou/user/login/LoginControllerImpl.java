package kr.co.recipetoyou.user.login;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.recipetoyou.user.UserVO;

@Controller("loginController")
public class LoginControllerImpl implements LoginController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private UserVO userVO;

	
	@RequestMapping(value="/login/login.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login(@ModelAttribute("userVO") UserVO userVO,
		HttpServletRequest request, HttpServletResponse response) throws Exception{
			ModelAndView mav = new ModelAndView();	
			return mav;
	}
	@RequestMapping(value="/login/loginProcess.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView loginProcess(@ModelAttribute("userVO") UserVO userVO, RedirectAttributes rAttr,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		ModelAndView mav = new ModelAndView();

		String viewName = (String) request.getAttribute("viewName");
		
		userVO = loginService.login(userVO);
		
		if (userVO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userVO", userVO);		//세션에 회원 정보를 저장함.
			session.setAttribute("isLogOn", true);
			session.setAttribute("user_id", userVO.getUser_id());
			mav.setViewName("redirect:/main.do");
			//mav.setViewName(viewName);
			
			String action = (String) session.getAttribute("action");		
			session.removeAttribute("action");
		}
		else {
			rAttr.addAttribute("result", "loginFailed");
			mav.setViewName("redirect:/login/login.do");
		}
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/login/logout.do", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		session.removeAttribute("isLogOn");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/login/login.do");
		return mav;	
	}
	
	

	@Override
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ModelAndView removeMember(String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView addMember(kr.co.recipetoyou.user.UserVO userVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	
	
}
