package kr.co.recipetoyou.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.activation.CommandMap;
import javax.management.loading.PrivateClassLoader;
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

import kr.co.recipetoyou.util.PageMaker;
import kr.co.recipetoyou.util.PagingVO;

@Controller("userController")
@EnableAspectJAutoProxy
public class UserControllerImpl implements UserController{
	
	private static final Logger logger = LoggerFactory.getLogger("UserControllerImpl.class");

	@Autowired
	private UserService userService;
	@Autowired
	private UserVO userVO;
	

	
	//페이징처리한 글목록
	@Override
	@RequestMapping(value = "/user/listUsers.do", method = RequestMethod.GET)
	public void listUsersGET(PagingVO vo, Model model) throws Exception{
		logger.info("C: listVO 겟 호출" + vo);
		model.addAttribute("ListUsers", userService.listUsers(vo));
	}
		
	//글목록보기(PageMaker객체 사용)
	//전체 회원 조회
	@Override
	@RequestMapping(value = "/user/listadUsers.do", method = RequestMethod.GET)
	public ModelAndView listPageGet(PagingVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
	    PageMaker pm = new PageMaker();
		pm.setVo(vo);
	    pm.setTotalCount(userService.userCount());
			 
		logger.info("C: vo는 "+ vo);
		logger.info("info 레벨 : viewName = "+viewName);
			  
		int cnt = userService.userCount();
			  
		List<UserVO> userList = userService.listUsers(vo);
	    ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("userList", userList);
		mav.addObject("cnt", cnt);
		mav.addObject("pm",pm);
			 
	   return mav;
	}
	
	
	@RequestMapping(value = "/user/*Form.do", method = RequestMethod.GET)
	 public ModelAndView form(@RequestParam(value = "result", required = false) String result, HttpServletRequest request, HttpServletResponse response) throws Exception{
	 	
		String viewName = (String)request.getAttribute("viewName");		
	 	ModelAndView mav = new ModelAndView(viewName);
	 	mav.addObject("result", result);
	 	return mav;
		
	 }


	//회원 상세 정보 조회
	@Override
	@RequestMapping(value = "/user/aduserInfo.do", method = RequestMethod.GET)
	public ModelAndView getUserInfo(@RequestParam(value="id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
			
		
		logger.info("클릭한 아이디:"+id);
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
			
		mav.addObject("userVO", userService.getUserInfo(id));
			
			
		return mav;
			
	}

		
	//회원 정보 수정 페이지로 이동
	@Override
	@RequestMapping(value = "/user/moduserInfo.do", method = RequestMethod.GET)
	public ModelAndView updateUserInfo(@RequestParam(value="id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
			
		logger.info("클릭한 id : "+id);
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
			
		mav.addObject("userVO", userService.getUserInfo(id));

		return mav;
	}
		
	//회원 정보 수정 완료
	@Override
	@RequestMapping(value = "/user/userUpdate.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView updateAction(@ModelAttribute UserVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("controller 사용자 생년월일:"+vo.getUser_birth());
		
		request.setCharacterEncoding("utf-8");
		userService.updateUserInfo(vo);
		
		
		System.out.println("update 통과 확인");
		
		ModelAndView mav = new ModelAndView("redirect:/user/listadUsers.do");
		
		return mav;
			
	}

	//회원 정보 삭제
	@Override
	@RequestMapping(value = "user/removeUser.do", method = RequestMethod.GET)
	public ModelAndView removeUser(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
			
		request.setCharacterEncoding("utf-8");
		userService.removeUsers(id);
		ModelAndView mav = new ModelAndView("redirect:/user/listadUsers.do");
		return mav;
	}
	

}
