package kr.co.recipetoyou.admin;

import java.util.List;


import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.recipetoyou.user.UserService;
import kr.co.recipetoyou.user.UserVO;

@Controller("adminController")
@EnableAspectJAutoProxy
public class AdminControllerImpl implements AdminController{
	
	private static final Logger logger = LoggerFactory.getLogger("AdminControllerImpl.class");
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private AdminVO adminVO;
	
	@Override
	@RequestMapping(value = "/admin/adLogin.do", method = RequestMethod.GET)
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("adLogin");
		
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		System.out.println(viewName);
		mav.setViewName(viewName);
		return mav;
	}
	
	//로그인 문제 생김 
	@RequestMapping(value = "/admin/*Form.do", method = RequestMethod.GET)
	public ModelAndView form(@RequestParam(value = "result",required = false) String result,
							@RequestParam(value = "action", required = false) String action,
							HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String viewName = (String) request.getAttribute("viewName");  //인터셉터에서 바인딩된 뷰이름 가져옴.
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("result", result);
		return mav;
	 }
	
	//관리자 로그인
	@Override
	@RequestMapping(value = "/admin/adMain.do", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("admin") AdminVO admin, RedirectAttributes rAttr, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		adminVO = adminService.login(admin);
		//System.out.println(adminVO);
		if (adminVO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("admin", adminVO);		//세션에 회원 정보를 저장함.
			session.setAttribute("isLogOn", true);		//세션에 로그인 상태를 true로 설정함.
			session.setAttribute("adminId", adminVO.getAdminId());
			mav.setViewName("redirect:/admin/adMainForm.do");
			//로그인 세션 유지를 위해 수정하였음 
		}
		else {
			rAttr.addAttribute("result", "loginFailed");		//로그인 실패시 실패 메시지를 로그인창으로 전달함.
			mav.setViewName("redirect:/admin/adLogin.do");	//로그인 실패시 다시 로그인창으로 리다이렉트함
		}
		return mav;
	}
		 
	//관리자 로그아웃
	@Override
	@RequestMapping(value = "/admin/logout.do", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session= request.getSession();
		session.removeAttribute("admin");
		session.removeAttribute("isLogOn");
		return "redirect:/admin/adLogin.do";
	}

}

