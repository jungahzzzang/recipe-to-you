package kr.co.recipetoyou.board.recipe;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import kr.co.recipetoyou.user.UserVO;
import kr.co.recipetoyou.util.PageMaker;
import kr.co.recipetoyou.util.PagingVO;

@Controller("recipeContoller")
public class RecipeContollerImpl implements RecipeController {

	private static final Logger logger = LoggerFactory.getLogger("RecipeContollerImpl.class");

	@Autowired
	private RecipeService recipeService;

	@Autowired
	private RecipeVO recipeVO;

	@RequestMapping(value = "/community/communityRecipeMain.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView communityRecipeMain(PagingVO vo, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

 

		PageMaker pm = new PageMaker();
		pm.setVo(vo);
		String _type = vo.getType();
		String searchVar = "";
		if (_type != null) {

			vo.setTypeArr(vo.getType().split(","));
			for (int i = 0; i < vo.getTypeArr().length; i++) {
				searchVar += vo.getTypeArr()[i];
			}

			vo.setType(searchVar);
		}

		pm.setTotalCount(recipeService.recipeCount(vo));
		int cnt = pm.getTotalCount();

		List<RecipeVO> recipeList = recipeService.recipeList(vo);

		List<RecipeCateVO> cateTitleList = recipeService.recipeCateTitleList();
		List<RecipeCateVO> cateDetailList = recipeService.recipeCateDetailList();

		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("userVO");

		ModelAndView mav = new ModelAndView();

		mav.addObject("recipeList", recipeList);
		mav.addObject("cateTitleList", cateTitleList);
		mav.addObject("cateDetailList", cateDetailList);
		mav.addObject("cnt", cnt);
		mav.addObject("pm", pm);

		return mav;
	}

	@RequestMapping(value = "/community/communityRecipeWrite.do", method = RequestMethod.GET)
	public ModelAndView communityRecipeWrite(HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {

		ObjectMapper objm = new ObjectMapper();

		List<RecipeCateVO> list = recipeService.recipeCateList();

		String cateList = objm.writeValueAsString(list);

		ModelAndView mav = new ModelAndView();
		logger.info("cateList: " + cateList);

		model.addAttribute("cateList", cateList);
		System.out.println("=========write=========");
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("userVO");
		System.out.println(userVO.getUser_id());

		return mav;

	}

	@RequestMapping(value = "/community/communityRecipeWriteProcess.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity communityRecipeWriteProcess(MultipartHttpServletRequest multipartRequest,
			HttpServletResponse response) throws Exception {

		multipartRequest.setCharacterEncoding("utf-8");
		String imageFileName = null;

		Map recipeMap = new HashMap();
		Enumeration enun = multipartRequest.getParameterNames();
		while (enun.hasMoreElements()) {
			String name = (String) enun.nextElement();

			// if(name.equals("recipe_idx")) recipe_idx =
			// multipartRequest.getParameter(name);

			String value = multipartRequest.getParameter(name);
			System.out.println("name:" + name + " | " + "value:" + value);
			recipeMap.put(name, value);
		}

		HttpSession session = multipartRequest.getSession();
		UserVO userVO = (UserVO) session.getAttribute("userVO");
		System.out.println("write user_id:" + userVO.getUser_id());
		String user_id = userVO.getUser_id();
		recipeMap.put("user_id", user_id);

		String recipe_img = upload(multipartRequest);
		recipeMap.put("recipe_img", recipe_img);

		recipeService.addRecipe(recipeMap);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");

		String message;
		ResponseEntity resEnt = null;

		try {
			// 서비스 호출
			message = "<script>";
			message += " alert('새글을 추가했습니다.');";
			message += " location.href='" + multipartRequest.getContextPath() + "/community/communityRecipeMain.do';";
			message += "</script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);

		} catch (Exception e) {

			message = "<script>";
			message += " alert('오류가 발생했습니다. 다시 시도해 주세요.');";
			message += " location.href='" + multipartRequest.getContextPath() + "/community/communityRecipeMain.do';";
			message += "</script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);

			e.printStackTrace();
		}

		return resEnt;
	}

	@RequestMapping(value = "/community/communityRecipeDetail.do", method = RequestMethod.GET)
	public ModelAndView communityRecipeDetail(@RequestParam(value = "recipe_idx", required = false) int recipe_idx,
			PagingVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		recipeVO = recipeService.recipeDetail(recipe_idx);
		PageMaker pm = new PageMaker();
		pm.setVo(vo);

		pm.setTotalCount(recipeService.recipeReviewCount(recipe_idx));
		int cnt = pm.getTotalCount();

		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("userVO");
		String user_id = "";
		if (userVO != null) {
			if (userVO.getUser_id() == null || userVO.getUser_id() == "") {
				user_id = "";
			} else {
				System.out.println("write user_id:" + userVO.getUser_id());
				user_id = userVO.getUser_id();
			}
		}

		List<RecipeReviewVO> recipeReviewVO = recipeService.recipeReviewList(vo);

		ModelAndView mav = new ModelAndView();
		mav.addObject("recipeVO", recipeVO);
		mav.addObject("recipeReviewVO", recipeReviewVO);
		mav.addObject("cnt", cnt);
		mav.addObject("user_id", user_id);
		mav.addObject("pm", pm);

		return mav;
	}

	@RequestMapping(value = "/community/communityRecipeModify.do", method = RequestMethod.GET)
	public ModelAndView communityRecipeModify(@RequestParam("recipe_idx") int recipe_idx, Model model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		recipeVO = recipeService.recipeModify(recipe_idx);
		ObjectMapper objm = new ObjectMapper();

		List<RecipeCateVO> list = recipeService.recipeCateList();

		String cateList = objm.writeValueAsString(list);

		ModelAndView mav = new ModelAndView();
		logger.info("cateList: " + cateList);

		model.addAttribute("cateList", cateList);
		mav.addObject("recipeVO", recipeVO);

		return mav;
	}

	@RequestMapping(value = "/community/communityRecipeReviewWrite.do", method = RequestMethod.POST)
	public String communityRecipeReviewWrite(RecipeReviewVO recipeReviewVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("userVO");
		recipeReviewVO.setUser_id(userVO.getUser_id());

		recipeService.addRecipeReview(recipeReviewVO);

		ModelAndView mav = new ModelAndView();

		return "redirect:/community/communityRecipeDetail.do?recipe_idx=" + recipeReviewVO.getRecipe_idx();
	}

	@RequestMapping(value = "/community/communityRecipeModifyProcess.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity communityRecipeModifyProcess(MultipartHttpServletRequest multipartRequest,
			HttpServletResponse response) throws Exception {

		multipartRequest.setCharacterEncoding("utf-8");
		String imageFileName = null;

		Map recipeMap = new HashMap();
		Enumeration enun = multipartRequest.getParameterNames();
		while (enun.hasMoreElements()) {
			String name = (String) enun.nextElement();

			// if(name.equals("recipe_idx")) recipe_idx =
			// multipartRequest.getParameter(name);

			String value = multipartRequest.getParameter(name);
			System.out.println("name:" + name + " | " + "value:" + value);
			recipeMap.put(name, value);
		}

		HttpSession session = multipartRequest.getSession();
		UserVO userVO = (UserVO) session.getAttribute("userVO");
		System.out.println(userVO.getUser_id());
		// String user_id = userVO.getUser_id();

		String recipe_img = upload(multipartRequest);
		System.out.println("=====================================\n 이미지명:" + recipe_img);
		recipeMap.put("recipe_img", recipe_img);

		recipeService.updateRecipe(recipeMap);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");

		String message;
		ResponseEntity resEnt = null;

		try {
			// 서비스 호출
			message = "<script>";
			message += " alert('글을 업데이트 했습니다.');";
			message += " location.href='" + multipartRequest.getContextPath() + "/community/communityRecipeMain.do';";
			message += "</script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);

		} catch (Exception e) {

			message = "<script>";
			message += " alert('오류가 발생했습니다. 다시 시도해 주세요.');";
			message += " location.href='" + multipartRequest.getContextPath() + "/community/communityRecipeMain.do';";
			message += "</script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);

			e.printStackTrace();
		}

		return resEnt;
	}

	@Override
	public ModelAndView communityRecipeModifyProcess(int recipe_idx, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value = "/community/communityRecipeDelete.do", method = RequestMethod.GET)
	public String communityRecipeDelete(@RequestParam("recipe_idx") int recipe_idx, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		recipeService.recipeDelete(recipe_idx);
		return "redirect:/community/communityRecipeMain.do";
	}

	@RequestMapping(value = "/mine/imageUpload.do", method = RequestMethod.POST)
	public void imageUpload(HttpServletRequest request, HttpServletResponse response,
			MultipartHttpServletRequest multiFile, @RequestParam MultipartFile upload) throws Exception {
		UUID uid = UUID.randomUUID();
		OutputStream out = null;
		PrintWriter printWriter = null;
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		/*
		 * 차후 번호 붙여서 파일 저장하기 Enumeration enun = multiFile.getParameterNames(); String
		 * recipe_idx = null; while (enun.hasMoreElements()) { String name = (String)
		 * enun.nextElement(); if(name.equals("recipe_idx")) recipe_idx =
		 * multiFile.getParameter(name); } System.out.println("idx:"+recipe_idx);
		 */
		try {
			String fileName = upload.getOriginalFilename();
			byte[] bytes = upload.getBytes();
			
			String _path = request.getSession().getServletContext().getRealPath("/");
			String separator = File.separator;
			int index = 0;
			String realWorkspace = "";
			String[] arr= {};
			
			if(separator.equals("/")) {
				arr = _path.split(separator); 
			}else {
				System.out.println("else");
				arr = _path.split("\\\\"); 
			}
			while(index < arr.length-1) {
			  if(arr[index].equals("wtpwebapps")) {
				  realWorkspace=arr[index+1];
			  }
			  System.out.println(arr[index]);
			  index++;
			}
			_path = _path.substring(0, _path.indexOf("\\", 1));
			_path += separator+realWorkspace+"/src/main/webapp/Resources/Upload/Recipe/";
			

			String ckUploadPath = _path + uid + "_" + fileName;
			File folder = new File(_path);
			if (!folder.exists()) {
				try {
					folder.mkdirs();
				} catch (Exception e) {
					e.getStackTrace();
				}
			}
			out = new FileOutputStream(new File(ckUploadPath));
			out.write(bytes);
			out.flush();
			String callback = request.getParameter("CKEditorFuncNum");
			printWriter = response.getWriter();
			String fileUrl = "/recipetoyou/mine/ckImgSubmit.do?uid=" + uid + "&fileName=" + fileName;
			printWriter.println("{\"filename\" : \"" + fileName + "\", \"uploaded\" : 1, \"url\":\"" + fileUrl + "\"}");
			printWriter.flush();
			System.out.println("upload complete");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (printWriter != null) {
					printWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return;
	}

	@RequestMapping(value = "/mine/ckImgSubmit.do")
	public void ckSubmit(@RequestParam(value = "uid") String uid, @RequestParam(value = "fileName") String fileName,
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String _path = request.getSession().getServletContext().getRealPath("/");
		String separator = File.separator;
		int index = 0;
		String realWorkspace = "";
		String[] arr= {};
		
		if(separator.equals("/")) {
			arr = _path.split(separator); 
		}else {
			System.out.println("else");
			arr = _path.split("\\\\"); 
		}
		while(index < arr.length-1) {
		  if(arr[index].equals("wtpwebapps")) {
			  realWorkspace=arr[index+1];
		  }
		  System.out.println(arr[index]);
		  index++;
		}
		_path = _path.substring(0, _path.indexOf("\\", 1));
		_path += separator+realWorkspace+"/src/main/webapp/Resources/Upload/Recipe/";
		
		
		String sDirPath = _path + uid + "_" + fileName;
		File imgFile = new File(sDirPath);
		if (imgFile.isFile()) {
			byte[] buf = new byte[1024];
			int readByte = 0;
			int length = 0;
			byte[] imgBuf = null;
			FileInputStream fileInputStream = null;
			ByteArrayOutputStream outputStream = null;
			ServletOutputStream out = null;
			try {
				fileInputStream = new FileInputStream(imgFile);
				outputStream = new ByteArrayOutputStream();
				out = response.getOutputStream();
				while ((readByte = fileInputStream.read(buf)) != -1) {
					outputStream.write(buf, 0, readByte);
				}
				imgBuf = outputStream.toByteArray();
				length = imgBuf.length;
				out.write(imgBuf, 0, length);
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				outputStream.close();
				fileInputStream.close();
				out.close();
			}
		}

	}

	private String upload(MultipartHttpServletRequest multipartRequest) throws ServletException, IOException {
		String fileName = null;

		String _path = multipartRequest.getSession().getServletContext().getRealPath("/");
		String separator = File.separator;
		int index = 0;
		String realWorkspace = "";
		String[] arr= {};
		
		if(separator.equals("/")) {
			arr = _path.split(separator); 
		}else {
			System.out.println("else");
			arr = _path.split("\\\\"); 
		}
		while(index < arr.length-1) {
		  if(arr[index].equals("wtpwebapps")) {
			  realWorkspace=arr[index+1];
		  }
		  System.out.println(arr[index]);
		  index++;
		}
		_path = _path.substring(0, _path.indexOf("\\", 1));
		_path += separator+realWorkspace+"/src/main/webapp/Resources/Upload/Recipe";
		
		Iterator<String> fileNames = multipartRequest.getFileNames();
		fileName = fileNames.next();
		MultipartFile mFile = multipartRequest.getFile(fileName);
		String originalFilename = mFile.getOriginalFilename();

		if (originalFilename != "" && originalFilename != null) {
			fileName = originalFilename;
			File file = new File(_path + "/" + fileName);
			if (mFile.getSize() != 0) { // File Null Check
				if (!file.exists()) { // 경로상에 존재하지 않는다면
					file.getParentFile().mkdirs(); // 경로에 해당하는 디렉토리들을 생성
					mFile.transferTo(new File(_path + "/" + originalFilename)); // 임시로
				} // 저장한 MultipartFile을 실제 파일로 전송
			}
		}

		return fileName;
	}

}
