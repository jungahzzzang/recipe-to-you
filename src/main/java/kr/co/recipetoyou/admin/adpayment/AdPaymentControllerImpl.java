package kr.co.recipetoyou.admin.adpayment;

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

@Controller("adPaymentController")
public class AdPaymentControllerImpl implements AdPaymentController {

	private static final Logger logger = LoggerFactory.getLogger("AdPaymentControllerImpl.class");
	
	@Autowired
	private AdPaymentService service;
	
	//페이징처리한 글목록
	@Override
	@RequestMapping(value = "/adpayment/listPay.do", method = RequestMethod.GET)
	public void listPayGET(PagingVO vo, Model model) throws Exception{
		logger.info("C: listPayVO 겟 호출" + vo);
		model.addAttribute("ListPayUsers", service.listPayUsers(vo));
	}
		
	//글목록보기(PageMaker객체 사용)
	//전체 주문 조회
	@Override
	@RequestMapping(value = "/adpayment/listadPay.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView listPayPageGet(PagingVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
	    PageMaker pm = new PageMaker();
		pm.setVo(vo);
	    pm.setTotalCount(service.payCount(vo)); 
		logger.info("C: vo는 "+ vo);
		logger.info("info 레벨 : viewName = "+viewName);  
		int cnt = service.payCount(vo);  
		List<AdPaymentVO> payList = service.listPayUsers(vo);
	    ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("payList", payList);
		mav.addObject("cnt", cnt);
		mav.addObject("pm",pm);	 
		return mav;
	}
	
	//페이징 이동 시에 필요함 
	@RequestMapping(value = "/adpayment/*Form.do", method = RequestMethod.GET)
	 public ModelAndView form(@RequestParam(value = "result", required = false) String result, HttpServletRequest request, HttpServletResponse response) throws Exception{
	 	//String viewName = getViewName(request);
		String viewName = (String)request.getAttribute("viewName");	
	 	ModelAndView mav = new ModelAndView(viewName);
	 	mav.addObject("result", result);
	 	return mav;
	 }
	
	//주문 상세 정보 조회
	@Override
	@RequestMapping(value = "/adpayment/adPayInfo.do", method = RequestMethod.GET)
	public ModelAndView getPayInfo(@RequestParam(value="id") int id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("클릭한 아이디:"+id);
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("adPayIngVO", service.getPayInfo(id));
		return mav;
	}

	//결제취소 
	@Override
	@RequestMapping(value = "/adpayment/removePay.do", method = RequestMethod.GET)
	public ModelAndView removePay(@RequestParam("id") int id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("id : " + id);
		request.setCharacterEncoding("utf-8");
		service.removePay(id);
		ModelAndView mav = new ModelAndView("redirect:listadPay.do");
		return mav;
	}
}
