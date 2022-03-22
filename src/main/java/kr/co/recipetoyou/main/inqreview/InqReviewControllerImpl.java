package kr.co.recipetoyou.main.inqreview;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import kr.co.recipetoyou.admin.adgoods.AdgoodsImgVO;
import kr.co.recipetoyou.user.UserVO;
import kr.co.recipetoyou.user.category.CategoryService;
import kr.co.recipetoyou.user.category.CategoryVO;

@Controller("inqreviewController")
public class InqReviewControllerImpl implements InqReviewController {
	
	private static final Logger logger = LoggerFactory.getLogger("InqReviewControllerImpl.class");
	
	private static final String UPLOAD_DIR = "C:\\git-recipetoyouuu\\RecipeToYou\\src\\main\\webapp\\Resources\\Admin\\Img\\AdgoodsImg\\";
	
	@Autowired
	InqReviewService inqReviewService;
	
	@Autowired
	private CategoryService service;
	
	//문의 작성
	@Override
	@RequestMapping(value = "/goods/insertInquiry.do", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView insertInquiry(@RequestParam(value = "prod_code")int prod_code, InquiryVO vo, HttpServletRequest request) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("userVO");
		vo.setUser_id(userVO.getUser_id());

		mav.addObject("prod_code", vo.getProd_code());
		inqReviewService.insertInquiry(vo);
		System.out.println("============"+prod_code);
		
		CategoryVO goodsDetailInfo = service.goodsDetailInfo(prod_code);
		
		AdgoodsImgVO agi = service.getGoodsDetailImage(prod_code);
		List<CategoryVO> goodsDetail = service.goodsDetailList();

		mav.addObject("goodsDetailInfo", goodsDetailInfo);
		mav.addObject("goodsDetail", goodsDetail);
		mav.addObject("goodsInfo", service.getGoodsInfo(prod_code));
		
		mav.setViewName("redirect:/user/goodsView.do?prod_code"+vo.getProd_code());
		
		return mav;
	}
	
	//후기 작성 페이지로 이동
	@Override
	@RequestMapping(value = "/goods/moveReview.do", method = RequestMethod.GET)
	public ModelAndView moveReviewForm(@RequestParam(value = "prod_code")int prod_code, ReviewVO vo, HttpServletRequest request) throws Exception {
		
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("prod_code", vo.getProd_code());
		
		System.out.println("============"+prod_code);
		
		return mav;
	}



	@Override
	public void readReview(int prod_review_code, ReviewVO vo, Model model) throws Exception {
		
		//후기 정보
		model.addAttribute("review", inqReviewService.getReviewDetail(prod_review_code));
		
	}
	
	//후기 작성
	@Override
	@RequestMapping(value = "/goods/insertReview.do", method = RequestMethod.POST)
	public ModelAndView insertReview(@RequestParam(value = "prod_code")int prod_code, ReviewVO vo, HttpServletRequest request) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("userVO");
		vo.setUser_id(userVO.getUser_id());

		mav.addObject("prod_code", vo.getProd_code());
		inqReviewService.insertReview(vo);
		System.out.println("============"+prod_code);
		
		CategoryVO goodsDetailInfo = service.goodsDetailInfo(prod_code);
		
		AdgoodsImgVO agi = service.getGoodsDetailImage(prod_code);
		List<CategoryVO> goodsDetail = service.goodsDetailList();

		mav.addObject("goodsDetailInfo", goodsDetailInfo);
		mav.addObject("goodsDetail", goodsDetail);
		mav.addObject("goodsInfo", service.getGoodsInfo(prod_code));
		
		mav.setViewName("redirect:/user/goodsView.do?prod_code"+vo.getProd_code());
		
		return mav;
	}


	@Override
	@RequestMapping(value="/goods/ckimageUpload.do", method = RequestMethod.POST) 
	public void qnaUpload(HttpServletRequest request, HttpServletResponse response,
			MultipartHttpServletRequest multiFile, MultipartFile upload) throws Exception {
		
		UUID uid = UUID.randomUUID(); 
		OutputStream out = null; 
		PrintWriter printWriter = null; 
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); 
		try{ 
			String fileName = upload.getOriginalFilename(); 
			byte[] bytes = upload.getBytes(); 
			String ckUploadPath = UPLOAD_DIR+ uid + "_" + fileName;
			System.out.println("path:"+ckUploadPath);
			File folder = new File(UPLOAD_DIR); 
			if(!folder.exists()){ 
				try{ folder.mkdirs(); 
				}catch(Exception e){ 
					e.getStackTrace(); 
				} 
			} 
			out = new FileOutputStream(new File(ckUploadPath)); 
			out.write(bytes); 
			out.flush(); 
			String callback = request.getParameter("CKEditorFuncNum"); 
			printWriter = response.getWriter(); 
			String fileUrl = "/recipetoyou/goods/ckimageSubmit.do?uid=" + uid + "&fileName=" + fileName;
			printWriter.println("{\"filename\" : \""+fileName+"\", \"uploaded\" : 1, \"url\":\""+fileUrl+"\"}"); 
			printWriter.flush(); 
			System.out.println("upload complete");
		}catch(IOException e){
			e.printStackTrace();
		} finally { 
			try {
				if(out != null) { 
					out.close(); 
				} 
				if(printWriter != null) { 
					printWriter.close(); 
				} 
			} catch(IOException e) { 
				e.printStackTrace(); 
			} 
		}return; 
		
	}

	
	@Override
	@RequestMapping(value="/goods/ckimageSubmit.do")
	public void ckedSubmit(String uid, String fileName, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String sDirPath = UPLOAD_DIR + uid + "_" + fileName; 
		File imgFile = new File(sDirPath); 
		if(imgFile.isFile()){ 
			byte[] buf = new byte[1024]; 
			int readByte = 0; 
			int length = 0;
			byte[] imgBuf = null; 
			FileInputStream fileInputStream = null; 
			ByteArrayOutputStream outputStream = null; 
			ServletOutputStream out = null; 
			try{ 
				fileInputStream = new FileInputStream(imgFile); 
				outputStream = new ByteArrayOutputStream(); 
				out = response.getOutputStream();
				while((readByte = fileInputStream.read(buf)) != -1){ 
					outputStream.write(buf, 0, readByte); 
				} 
				imgBuf = outputStream.toByteArray(); 
				length = imgBuf.length; out.write(imgBuf, 0, length); 
				out.flush(); 
			}catch(IOException e){ 
				e.printStackTrace();
			}finally { 
				outputStream.close(); 
				fileInputStream.close(); 
				out.close(); 
			}
		}

	}


}
