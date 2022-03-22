package kr.co.recipetoyou.admin.adfaq;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import kr.co.recipetoyou.util.PageMaker;
import kr.co.recipetoyou.util.PagingVO;

@Controller("adNoticeController")
public class AdNoticeControllerImpl implements AdNoticeController {

	private static final Logger logger = LoggerFactory.getLogger("AdNoticeControllerImpl.class");
	
	@Autowired
	private AdNoticeService service;

	//페이징처리한 레시피 글목록
	@Override
	@RequestMapping(value = "/adnotice/listNotice.do", method = RequestMethod.GET)
	public void listNoticeGET(PagingVO vo, Model model) throws Exception{
		logger.info("C: listNoticeVO 겟 호출" + vo);
		model.addAttribute("ListNotice", service.listNotice(vo));
	}
		
	//글목록보기(PageMaker객체 사용)
	//전체 레시피 게시글 조회
	@Override
	@RequestMapping(value = "/adnotice/listadNotice.do", method = RequestMethod.GET)
	public ModelAndView listNoitcePageGet(PagingVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
	    PageMaker pm = new PageMaker();
		pm.setVo(vo);
	    pm.setTotalCount(service.noticeCount(vo)); 
		logger.info("C: vo는 "+ vo);
		logger.info("info 레벨 : viewName = "+viewName);  
		int cnt = service.noticeCount(vo);  
		List<AdNoticeVO> noticeList = service.listNotice(vo);
	    ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("noticeList", noticeList);
		mav.addObject("cnt", cnt);
		mav.addObject("pm",pm);	 
		return mav;
	}
	
	//페이징 이동 시에 필요함 
	@RequestMapping(value = "/adnotice/*Form.do", method = RequestMethod.GET)
	 public ModelAndView form(@RequestParam(value = "result", required = false) String result, HttpServletRequest request, HttpServletResponse response) throws Exception{
	 	//String viewName = getViewName(request);
		String viewName = (String)request.getAttribute("viewName");	
	 	ModelAndView mav = new ModelAndView(viewName);
	 	mav.addObject("result", result);
	 	return mav;
	 }
	
	@Override
	@RequestMapping(value = "/adnotice/adNoticeInfo.do", method = RequestMethod.GET)
	public ModelAndView getNoticeInfo(@RequestParam(value="id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("클릭한 아이디:"+id);
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("adNoticeVO", service.getNoticeInfo(id));
		return mav;
	}

	@Override
	@RequestMapping(value = "/adnotice/removeNotice.do", method = RequestMethod.GET)
	public ModelAndView removeNotice(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("id : " + id);
		request.setCharacterEncoding("utf-8");
		service.removeNotice(id);
		ModelAndView mav = new ModelAndView("redirect:listadNotice.do");
		return mav;
	}
}
