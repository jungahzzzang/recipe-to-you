package kr.co.recipetoyou.admin.adpoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("adPointController")
public class AdPointControllerImpl implements AdPointController {
	
	private static final Logger logger = LoggerFactory.getLogger("AdPointControllerImpl.class");
	
	@Autowired
	private AdPointService adPointService;
	
	@Autowired
	private AdPointVO adPointVO;
	
/*	
	//페이징처리한 포인트목록
	@Override
	@RequestMapping(value = "/adpoint/userPoint.do", method = RequestMethod.GET)
	public void listPointGET(PagingVO vo, Model model) throws Exception{
		logger.info("C: listOrdVO 겟 호출" + vo);
		model.addAttribute("ListOrdUsers", adPointService.listPoint(vo));
	}
	
	*/
	
	
	//adpoint/userPoint
	@RequestMapping(value = "/adpoint/userPoint.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView userPoint(@ModelAttribute("adPointVO") AdPointVO adPointVO,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		//List<AdPointVO> listPoint = adPointService.listPoint();
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("listPoint", listPoint);
		
		return mav;	
	}


	
	//적립금로그 나중에 하기로 했음.
	@RequestMapping(value = "/adpoint/pointRecord.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView pointRecord(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		
		ModelAndView mav = new ModelAndView();
		return mav;	
	}
	

	
		
/*	
	
	//글목록보기(PageMaker객체 사용)
	//전체 주문 조회
	@Override
	@RequestMapping(value = "/adorder/listadOrd.do", method = RequestMethod.GET)
	public ModelAndView listOrdPageGet(PagingVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
	    PageMaker pm = new PageMaker();
		pm.setVo(vo);
	    pm.setTotalCount(service.ordCount()); 
		logger.info("C: vo는 "+ vo);
		logger.info("info 레벨 : viewName = "+viewName);  
		int cnt = service.ordCount();  
		List<AdOrderVO> ordList = service.listOrdUsers(vo);
	    ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("ordList", ordList);
		
		mav.addObject("cnt", cnt);
		mav.addObject("pm",pm);	 
		return mav;
	}
	

	//주문 정보 수정 페이지로 이동
	@Override
	@RequestMapping(value = "/adorder/modOrdInfo.do", method = RequestMethod.GET)
	public ModelAndView updateOrdInfo(@RequestParam(value="id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {	
		logger.info("클릭한 id : "+id);
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);	
		mav.addObject("adOrdVO", service.getOrdInfo(id));
		return mav;
	}
		
	//주문 정보 삭제
	@Override
	@RequestMapping(value = "/adorder/removeOrd.do", method = RequestMethod.GET)
	public ModelAndView removeOrd(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		service.removeOrd(id);
		ModelAndView mav = new ModelAndView("redirect:listadOrd.do");
		return mav;
	}
	
	*/
	
	
}
