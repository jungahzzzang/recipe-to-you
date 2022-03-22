package kr.co.recipetoyou.main.goods;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import kr.co.recipetoyou.main.inqreview.InquiryVO;
import kr.co.recipetoyou.main.inqreview.ReviewVO;
import kr.co.recipetoyou.util.PagingVO;

public interface GoodsController {
	
	public ModelAndView main(@RequestParam("prod_code") int prod_code,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	
	public ModelAndView listPageGet(PagingVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	
}
