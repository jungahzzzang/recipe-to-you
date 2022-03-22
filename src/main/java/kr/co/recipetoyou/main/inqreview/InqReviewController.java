package kr.co.recipetoyou.main.inqreview;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

public interface InqReviewController {
	
	//문의 작성
	public ModelAndView insertInquiry(@RequestParam(value = "prod_code")int prod_code,InquiryVO vo, HttpServletRequest request)throws Exception;
	
	//후기 작성 페이지로 이동
	public ModelAndView moveReviewForm(@RequestParam(value = "prod_code")int prod_code,ReviewVO vo, HttpServletRequest request) throws Exception;
	
	//후기 작성
	public ModelAndView insertReview(@RequestParam(value = "prod_code")int prod_code,ReviewVO vo, HttpServletRequest request)throws Exception;
	
	public void readReview(int prod_review_code, ReviewVO vo, Model model)throws Exception;
	
	//ck에디터 이미지 업로드
	public void qnaUpload(HttpServletRequest request, HttpServletResponse response, MultipartHttpServletRequest multiFile , @RequestParam MultipartFile upload) throws Exception;
	
	//ck이미지 전송
	public void ckedSubmit(@RequestParam(value="uid") String uid , @RequestParam(value="fileName") String fileName 
			, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
