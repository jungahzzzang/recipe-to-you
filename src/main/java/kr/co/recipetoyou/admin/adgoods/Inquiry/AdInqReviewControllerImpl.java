package kr.co.recipetoyou.admin.adgoods.Inquiry;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.recipetoyou.admin.adgoods.AdGoodsVO;
import kr.co.recipetoyou.util.PageMaker;
import kr.co.recipetoyou.util.PagingVO;

@Controller("adinquiryController")
@EnableAspectJAutoProxy
public class AdInqReviewControllerImpl implements AdInqReviewController{
	
	private static final Logger logger = LoggerFactory.getLogger("InquiryControllerImpl.class");
	
	@Autowired
	AdInqReviewService adInquiryService;

	//상품 문의 목록
	@Override
	@RequestMapping(value = "/adgoods/inquiryList.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView listInquiryGet(PagingVO vo, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		List inquiryList = adInquiryService.listInquiry(vo);

		int cnt = adInquiryService.inquiryAllCount(vo);
		int searchcnt = adInquiryService.inquiryCount(vo);
		
		if(!inquiryList.isEmpty()) {
			mav.addObject("inquiryList", inquiryList);
			mav.addObject("searchcnt", searchcnt);
			mav.addObject("cnt", cnt);
		}else {
			mav.addObject("listCheck", "empty");
		}
		
		//페이지 데이터
		mav.addObject("pm", new PageMaker(vo, adInquiryService.inquiryAllCount(vo)));
		
		return mav;
	}

	//상품 문의 목록 조회 및 페이징 처리
	@Override
	@RequestMapping(value = "/adgoods/listInquiry.do")
	public void listInquiry(PagingVO vo, Model model) throws Exception {
		
		model.addAttribute("ListInquiry", adInquiryService.listInquiry(vo));
	}

	//상품 문의 상세 조회
	@Override
	@RequestMapping(value = "/adgoods/adInquiryDetail.do", method = {RequestMethod.GET, RequestMethod.POST})
	public void getInquiryDetail(int prod_inq_code, Model model, PagingVO vo) throws Exception {
		
		//페이징 정보
		model.addAttribute("vo", vo);
		
		//문의 정보
		model.addAttribute("inquiry", adInquiryService.adInquiryDetail(prod_inq_code));
		
		
	}
	
	@Override
	@RequestMapping(value = "/adgoods/updateProdQna.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView updateProdQna(@RequestParam(value = "prod_inq_code") int prod_inq_code, AdInquiryVO vo, RedirectAttributes rttr, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		int result = adInquiryService.updateProdQna(vo);
		rttr.addFlashAttribute("qna_result", result);
		
		ModelAndView mav = new ModelAndView("redirect:inquiryList.do");
		mav.addObject("prod_inq_code", prod_inq_code);
		
		return mav;
	}
	
	////////////////////////////////////////////////

	@Override
	@RequestMapping(value = "/adgoods/adReviewList.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView listReviewGet(PagingVO vo, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		List reviewList = adInquiryService.listReview(vo);
		
		int cnt = adInquiryService.reviewAllCount(vo);
		int searchcnt = adInquiryService.reviewCount(vo);
		
		if(!reviewList.isEmpty()) {
			mav.addObject("reviewList", reviewList);
			mav.addObject("searchcnt", searchcnt);
			mav.addObject("cnt", cnt);
		}else {
			mav.addObject("listCheck", "empty");
		}
		
		//페이지 데이터
		mav.addObject("pm", new PageMaker(vo, adInquiryService.reviewAllCount(vo)));
		
		return mav;
	}

	@Override
	@RequestMapping(value = "/adgoods/listReview.do")
	public void listReview(PagingVO vo, Model model) throws Exception {
		
		model.addAttribute("ListReview", adInquiryService.listReview(vo));
	
	}

	@Override
	@RequestMapping(value = "/adgoods/adReviewDetail.do", method = {RequestMethod.GET, RequestMethod.POST})
	public void getReviewDetail(int prod_review_code, Model model, PagingVO vo) throws Exception {
		
		//페이징 정보
		model.addAttribute("vo", vo);
		
		//문의 정보
		model.addAttribute("review", adInquiryService.adReviewDetail(prod_review_code));
		
	}

	

}
