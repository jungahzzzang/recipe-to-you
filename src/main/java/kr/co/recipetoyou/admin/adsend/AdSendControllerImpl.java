package kr.co.recipetoyou.admin.adsend;

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

import kr.co.recipetoyou.util.PageMaker;
import kr.co.recipetoyou.util.PagingVO;

// 발송코드 및 주문/결제 테이블 내용을 출력하지 못하였음. 필요 기능 구현은 추가로 알아보고 해야될 듯

@Controller("sendController")
@EnableAspectJAutoProxy
public class AdSendControllerImpl implements AdSendController {

	private static final Logger logger = LoggerFactory.getLogger("SendControllerImpl.class");

	@Autowired
	private AdSendService sendService;
	
	@RequestMapping(value = "/adsend/*.do", method = RequestMethod.GET)
	public ModelAndView form(@RequestParam(value = "result", required = false) String result, HttpServletRequest request, HttpServletResponse response) throws Exception{
		//String viewName = getViewName(request);
		String viewName = (String)request.getAttribute("viewName");		
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("result", result);
		return mav;
	}
	
	//페이징처리한 발송내역목록
	@Override
	@RequestMapping(value = "/adsend/listSend.do", method = RequestMethod.GET)
	public void listSendGET(PagingVO vo, Model model) throws Exception{
		logger.info("C: listVO 겟 호출" + vo);
		model.addAttribute("ListUsers", sendService.listSend(vo));
	}
		
	//발송내역목록보기(PageMaker객체 사용)
	//전체 발송내역 조회
	@Override
	@RequestMapping(value = "/adsend/listadSend.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView sendlistPageGet(PagingVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
	    PageMaker pm = new PageMaker();
		pm.setVo(vo);
	    pm.setTotalCount(sendService.sendListCount(vo)); 
		logger.info("C: vo는 "+ vo);
		logger.info("info 레벨 : viewName = "+viewName);  
		int cnt = sendService.sendListCount(vo);  
		List<AdSendVO> sendList = sendService.listSend(vo);
	    ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("sendList", sendList);
		mav.addObject("cnt", cnt);
		mav.addObject("pm",pm);	 
		return mav;
	}	
	
	//회원 상세 정보 조회
	@Override
	@RequestMapping(value = "/adsend/adSendUserInfo.do", method = RequestMethod.GET)
	public ModelAndView getUserSendInfo(@RequestParam(value="id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("클릭한 아이디:"+id);
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("userVO", sendService.getSendUserInfo(id));
		return mav;
	}	

	//주문 상세 정보 조회
	@Override
	@RequestMapping(value = "/adsend/adSendOrderInfo.do", method = RequestMethod.GET)
	public ModelAndView getOrderSendInfo(@RequestParam(value="ord") int ord,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("클릭한 아이디:"+ord);
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("orderVO", sendService.getSendOrderInfo(ord));
		return mav;
	}	
	
	//결제 상세 정보 조회
	@Override
	@RequestMapping(value = "/adsend/adSendPaymentInfo.do", method = RequestMethod.GET)
	public ModelAndView getPaymentSendInfo(@RequestParam(value="pay") int pay,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("클릭한 아이디:"+pay);
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("paymentVO", sendService.getSendPaymentInfo(pay));
		return mav;

	}
}
