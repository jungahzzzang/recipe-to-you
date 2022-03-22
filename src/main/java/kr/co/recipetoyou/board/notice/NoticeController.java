package kr.co.recipetoyou.board.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.recipetoyou.util.PagingVO;

public interface NoticeController {
	
	public ModelAndView notice(PagingVO vo,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView noticeBulkOrder(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView noticeDetail(@RequestParam(value="notice_idx") int notice_idx, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView noticeEchoWrapFeedback(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView noticeEchoWrapFeedbackDetail(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView noticeFrequencyQuestion(@RequestParam(value="faq_cate_code", required=false) String faq_cate_code ,PagingVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView noticeGoodsOffer(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView noticeGoodsOfferDetail(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView noticeOneToOneQuestion(PagingVO vo ,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView noticeOneToOneQuestionDetail(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public String noticeOneToOneWrite(NoticeINQVO noticeINQ ,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView deliverNotice(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
