package kr.co.recipetoyou.admin.aduser.aduserWithdraw;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.recipetoyou.admin.aduser.aduserWithdraw.AdUserDrawService;
import kr.co.recipetoyou.admin.aduser.aduserWithdraw.AdUserDrawVO;
import kr.co.recipetoyou.util.PageMaker;
import kr.co.recipetoyou.util.PagingVO;

@Controller("userWithdrawController")
@EnableAspectJAutoProxy
public class AdUserDrawControllerImpl implements AdUserDrawController{
	
	private static final Logger logger = LoggerFactory.getLogger("UserControllerImpl.class");

	@Autowired
	private AdUserDrawService adUserDrawService;
	
//================================================================================	
	//탈퇴 회원 목록
	//페이징처리한 글목록
	@Override
	@RequestMapping(value = "/aduserWithdraw/listUsersWithdraw.do", method = RequestMethod.GET)
	public void withdrawUsersGET(PagingVO vo, Model model) throws Exception{
		logger.info("withdrawUsersGET");
		model.addAttribute("WithdrawUsers", adUserDrawService.listUsersWithdraw(vo));
	}
		
	//글목록보기(PageMaker객체 사용)
	//탈퇴 회원 조회
	@Override
	@RequestMapping(value = "/aduserWithdraw/listadUsersWithdraw.do", method = RequestMethod.GET)
	public ModelAndView withdrawPageGet(PagingVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		PageMaker pm = new PageMaker();
		pm.setVo(vo);
		pm.setTotalCount(adUserDrawService.userWithdrawCount(vo)); 
		logger.info("withdrawPageGet vo는 "+ vo);
		logger.info("withdrawPageGet info 레벨 : viewName = "+viewName);  
		int cnt = adUserDrawService.userWithdrawCount(vo);  
		List<AdUserDrawVO> userWithdrawList = adUserDrawService.listUsersWithdraw(vo);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("userWithdrawList", userWithdrawList);
		mav.addObject("cnt", cnt);
		mav.addObject("pm",pm);	 
		return mav;
	}
	
	//페이징 이동 시에 필요함 
	@RequestMapping(value = "/aduserWithdraw/*Form.do", method = RequestMethod.GET)
	 public ModelAndView form(@RequestParam(value = "result", required = false) String result, HttpServletRequest request, HttpServletResponse response) throws Exception{
	 	//String viewName = getViewName(request);
		String viewName = (String)request.getAttribute("viewName");		
	 	ModelAndView mav = new ModelAndView(viewName);
	 	mav.addObject("result", result);
	 	return mav;
	 }
	
	//탈퇴 회원 정보 조회
	@Override
	@RequestMapping(value = "/aduserWithdraw/aduserWithdraw.do", method = RequestMethod.GET)
	public ModelAndView adUserWithdraw(@RequestParam(value="id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("withdrawPageGet 클릭한 아이디:"+id);
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);	
		mav.addObject("aduserDrawVO", adUserDrawService.getUserWithdraw(id));
		return mav;
	}
	
	//탈퇴 회원 정보 삭제
	@Override
	@RequestMapping(value = "/aduserWithdraw/readUserWithdraw.do", method = RequestMethod.GET)
	public ModelAndView removeUserWithdraw(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		adUserDrawService.removeUsersWithdraw(id);
		ModelAndView mav = new ModelAndView("redirect:listadUsersWithdraw.do");
		return mav;
	}

}
