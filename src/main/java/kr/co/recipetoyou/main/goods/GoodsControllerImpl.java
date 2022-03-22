package kr.co.recipetoyou.main.goods;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.recipetoyou.main.inqreview.InqReviewService;
import kr.co.recipetoyou.main.inqreview.InquiryVO;
import kr.co.recipetoyou.main.inqreview.ReviewVO;
import kr.co.recipetoyou.user.UserVO;
import kr.co.recipetoyou.util.PageMaker;
import kr.co.recipetoyou.util.PagingVO;


@Controller("goodsController")
public class GoodsControllerImpl implements GoodsController{
	
	private static final Logger logger = LoggerFactory.getLogger("GoodsControllerImpl.class");
	
	@Autowired
	GoodsService goodsService;
	
	@Autowired
	InqReviewService inqReviewService;
	
	@Override
	@ResponseBody
	public ModelAndView listPageGet(PagingVO vo, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		List goodsList = goodsService.listGoods(vo);
		
		if(!goodsList.isEmpty()) {
			mav.addObject("goodsList", goodsList);
		}else {
			mav.addObject("listCheck", "empty");
		}
		
		return mav;
	}
	
	
	  @Override
	  @RequestMapping(value="/prodDetail.do",method = RequestMethod.GET)
	  public ModelAndView main(@RequestParam (value = "prod_code", required = false, defaultValue="0") int prod_code, HttpServletRequest request, HttpServletResponse response) throws Exception {
	  
		  System.out.println("controller 호출"); request.setCharacterEncoding("utf-8");
		  ModelAndView mav = new ModelAndView();
	  
		  //33, 34번 때문에 화면이 안보임. 33,34 주석처리하면 보임.
		  
		  if(prod_code!=0) {
			  GoodsVO goodsVO =
		      goodsService.listProduct(prod_code);
			  mav.addObject("goodsVO", goodsVO);
		  }
	  		return mav;
	  	}
	 
	


		
}
