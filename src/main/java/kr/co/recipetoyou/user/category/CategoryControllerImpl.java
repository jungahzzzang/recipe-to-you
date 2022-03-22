package kr.co.recipetoyou.user.category;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.recipetoyou.admin.adgoods.AdgoodsImgVO;
import kr.co.recipetoyou.main.inqreview.InqReviewService;
import kr.co.recipetoyou.main.inqreview.InquiryVO;
import kr.co.recipetoyou.main.inqreview.ReviewVO;
import kr.co.recipetoyou.util.PageMaker;
import kr.co.recipetoyou.util.PagingVO;


@Controller("categoryController")
public class CategoryControllerImpl implements CategoryController{
	
	private static final Logger logger = LoggerFactory.getLogger("CategoryControllerImpl.class");

	@Autowired
	private CategoryService service;
	
	@Autowired
	private CategoryVO categoryVO;
	
	@Autowired
	private InqReviewService inqReviewService;
	
	
	@Override
	@RequestMapping(value="/main.do", method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		List<CategoryVO> goodsInfo = service.goodsInfoList();
		List<CategoryVO> bargain = service.bargainList();
		logger.info(viewName);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("goodsInfo", goodsInfo);
		mav.addObject("bargain", bargain);
		return mav;
	}
	
	
	//이미지 출력
	@Override
	@RequestMapping(value = "/user/getImageInfo.do")
	public ResponseEntity<byte[]> getGoodsListImage(String fileName, HttpServletRequest request) throws Exception {
		
		String _path = request.getSession().getServletContext().getRealPath("/");
		String separator = File.separator;
		int index = 0;
		String realWorkspace = "";
		String[] arr= {};
		
		if(separator.equals("/")) {
			arr = _path.split(separator); 
		}else {
			arr = _path.split("\\\\"); 
		}
		while(index < arr.length-1) {
		  if(arr[index].equals("wtpwebapps")) {
			  realWorkspace=arr[index+1];
		  }
		  index++;
		}
		_path = _path.substring(0, _path.indexOf("\\", 1));
		_path += separator+realWorkspace+"/src/main/webapp/Resources/Admin/Img/AdgoodsImg/";
			
		File file = new File(_path+fileName);
		ResponseEntity<byte[]> result = null;
			
		try {	
			HttpHeaders header = new HttpHeaders();
			header.add("Content-type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		}catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//이미지 정보 반환
	@Override
	@RequestMapping(value = "/user/getImageList.do", produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<AdgoodsImgVO>> getGoodsImageList(int prod_code) throws Exception {
		
		return new ResponseEntity<List<AdgoodsImgVO>>(service.getGoodsInfoImage(prod_code), HttpStatus.OK);
	}
		
	@RequestMapping(value="/user/benefitPage.do",method=RequestMethod.GET)
	public ModelAndView benefitPage(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	
	
	@Override
	@RequestMapping(value="/user/goodsView.do",method=RequestMethod.GET)
	public ModelAndView goodsView(PagingVO vo, int prod_code, HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String) request.getAttribute("viewName");
		CategoryVO goodsDetailInfo = service.goodsDetailInfo(prod_code);
		
		AdgoodsImgVO agi = service.getGoodsDetailImage(prod_code);
		List<CategoryVO> goodsDetail = service.goodsDetailList();
		logger.info(viewName);
		ModelAndView mav = new ModelAndView();
		
		//문의 목록
		List<InquiryVO> inquiryList = inqReviewService.getInquiryList(vo);
		int qnacnt = inqReviewService.qnaCount(vo);
		
		mav.addObject("inquiryList", inquiryList);
		
		if(!inquiryList.isEmpty()) {
			mav.addObject("cnt", qnacnt);
		}else {
			mav.addObject("listCheck", "empty");
		}
		
		//후기 목록
		List<ReviewVO> reviewList = inqReviewService.getReviewList(vo);
		int reviewcnt = inqReviewService.reviewCount(vo);
		
		mav.addObject("reviewList", reviewList);
		
		if(!reviewList.isEmpty()) {
			mav.addObject("reviewcnt", reviewcnt);
		}else {
			mav.addObject("listCheck", "empty");
		}
		
		//상품 정보
		mav.setViewName(viewName);
		mav.addObject("goodsDetailInfo", goodsDetailInfo);
		mav.addObject("goodsDetail", goodsDetail);
		mav.addObject("goodsInfo", service.getGoodsInfo(prod_code));
		mav.addObject("agi", agi);
		
		//문의 페이지 데이터
		mav.addObject("qnapm", new PageMaker(vo, inqReviewService.qnaCount(vo)));
		//후기 페이지 데이터
		mav.addObject("reviewpm", new PageMaker(vo, inqReviewService.reviewCount(vo)));
		
		return mav;
	}
	
	//goddsViewProcess.do
	
	@RequestMapping(value="/user/kf365Page",method=RequestMethod.GET)
	public ModelAndView kf365Page(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		
		return mav;
	}
	
	@RequestMapping(value="/user/kf365TestPage.do",method=RequestMethod.GET)
	public ModelAndView kf365TestPage(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@RequestMapping(value="/user/saleEventPage.do",method=RequestMethod.GET)
	public ModelAndView saleEventPage(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@RequestMapping(value="/user/newGoodsPage.do",method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView newGoodsPage(PagingVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception{
		int type= 1;
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		
		List listGoods = service.listGoods(vo,type);
		int cnt = service.cateCount(vo,type); 
		if(!listGoods.isEmpty()) {
			mav.addObject("goodsList", listGoods);
			int i=0;
			
			mav.addObject("cnt", cnt);
		}else {
			mav.addObject("listCheck", "empty");
		}
		
		mav.addObject("pm", new PageMaker(vo, service.cateCount(vo,type)));
		
		return mav;
	}
	
	@RequestMapping(value="/user/bestGoodsPage.do",method=RequestMethod.GET)
	public ModelAndView bestGoodsPage(PagingVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception{
		int type=2;
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
	
		List listGoods = service.listGoods(vo,type);
		int cnt = service.cateCount(vo,type); 
		if(!listGoods.isEmpty()) {
			mav.addObject("goodsList", listGoods);
			int i=0;
			mav.addObject("cnt", cnt);
		}else {
			mav.addObject("listCheck", "empty");
		}
		
		mav.addObject("pm", new PageMaker(vo, service.cateCount(vo,type)));
		
		return mav;
	}
	

	
	@RequestMapping(value="/user/saleGoodsPage.do",method=RequestMethod.GET)
	public ModelAndView saleGoodsPage(PagingVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception{
		int type=3;
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		
		List listGoods = service.listGoods(vo,type);
		int cnt = service.cateCount(vo,type); 
		if(!listGoods.isEmpty()) {
			mav.addObject("goodsList", listGoods);
			int i=0;
			
			mav.addObject("cnt", cnt);
		}else {
			mav.addObject("listCheck", "empty");
		}
		
		mav.addObject("pm", new PageMaker(vo, service.cateCount(vo,type)));
		
		return mav;
	}
	

}
