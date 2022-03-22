package kr.co.recipetoyou.board.notice;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import kr.co.recipetoyou.user.UserVO;
import kr.co.recipetoyou.util.PageMaker;
import kr.co.recipetoyou.util.PagingVO;

@Controller("noticeController")
public class NoticeControllerImpl implements NoticeController{
	
	
	private static final Logger logger = LoggerFactory.getLogger("NoticeControllerImpl.class");
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private NoticeVO noticeVO;

	@Override
	@RequestMapping(value="/notice/notice.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView notice(PagingVO vo,HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		logger.info(viewName);
		
		PageMaker pm = new PageMaker();
		pm.setVo(vo);
		pm.setTotalCount(noticeService.noticeCount(vo));
		int cnt  = pm.getTotalCount();
		
		List<NoticeVO> noticeList = noticeService.noticeList(vo);
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("cnt",cnt);
		mav.addObject("noticeList",noticeList);
		mav.addObject("pm",pm);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/notice/noticeBulkOrder.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView noticeBulkOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		logger.info(viewName);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		
		return mav;
	}

	@Override
	@RequestMapping(value="/notice/noticeDetail.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView noticeDetail(@RequestParam(value="notice_idx") int notice_idx,HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		logger.info(viewName);
		
		noticeVO = noticeService.getNoticeDetail(notice_idx);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("noticeVO",noticeVO);
		
		return mav;
	}

	@Override
	@RequestMapping(value="/notice/noticeEchoWrapFeedback.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView noticeEchoWrapFeedback(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		logger.info(viewName);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		
		return mav;
	}

	@Override
	@RequestMapping(value="/notice/noticeEchoWrapFeedbackDetail.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView noticeEchoWrapFeedbackDetail(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		logger.info(viewName);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		
		return mav;
	}

	@Override
	@RequestMapping(value="/notice/noticeFrequencyQuestion.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView noticeFrequencyQuestion(@RequestParam(value="faq_cate_code", required=false) String faq_cate_code ,
			PagingVO vo,HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		logger.info(viewName);
		
		if(faq_cate_code != null && faq_cate_code != "") {
			int result = Integer.parseInt(faq_cate_code);
			vo.setCateCode(result);
		}
		
		PageMaker pm = new PageMaker();
		pm.setVo(vo);
		pm.setTotalCount(noticeService.noticeFrequencyCount(vo));
		int cnt  = pm.getTotalCount();
		
		List<NoticeVO> noticeFrequencyList = noticeService.noticeFrequencyList(vo);
		System.out.println(noticeFrequencyList.toString());
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("cnt",cnt);
		mav.addObject("noticeFrequencyList",noticeFrequencyList);
		mav.addObject("pm",pm);
		
		return mav;
	}

	@Override
	@RequestMapping(value="/notice/noticeGoodsOffer.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView noticeGoodsOffer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		logger.info(viewName);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		
		return mav;
	}

	@Override
	@RequestMapping(value="/notice/noticeGoodsOfferDetail.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView noticeGoodsOfferDetail(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		logger.info(viewName);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		
		return mav;
	}

	@Override
	@RequestMapping(value="/notice/noticeOneToOneQuestion.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView noticeOneToOneQuestion(PagingVO vo ,HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		
		logger.info(viewName);
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO)session.getAttribute("userVO");
		vo.setUser_id(userVO.getUser_id());
		System.out.println("=============userid:"+vo.getUser_id());
		PageMaker pm = new PageMaker();
		pm.setVo(vo);
		pm.setTotalCount(noticeService.noticeOneToOneCount(vo));
		int cnt  = pm.getTotalCount();
		
		List<NoticeINQVO> noticeOneToOneList = noticeService.noticeOneToOneist(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("cnt",cnt);
		mav.addObject("noticeOneToOneList",noticeOneToOneList);
		mav.addObject("pm",pm);
		
		return mav;
	}

	@Override
	@RequestMapping(value="/notice/noticeOneToOneQuestionDetail.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView noticeOneToOneQuestionDetail(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	
	@Override
	@RequestMapping(value="/notice/noticeOneToOneWrite.do", method= {RequestMethod.GET,RequestMethod.POST})
	public String noticeOneToOneWrite(NoticeINQVO noticeINQ ,HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("userVO");
		noticeINQ.setUser_id(userVO.getUser_id());
		
		noticeService.addOnoToOneINQ(noticeINQ);
		
		return "redirect:/notice/noticeOneToOneQuestion.do";
	}

	@Override
	@RequestMapping(value="/notice/deliverNotice.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView deliverNotice(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		return mav;
	}

}
