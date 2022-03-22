package kr.co.recipetoyou.admin.adgoods;

import org.springframework.http.MediaType;


import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import kr.co.recipetoyou.util.PageMaker;
import kr.co.recipetoyou.util.PagingVO;
import net.coobird.thumbnailator.Thumbnails;


@Controller("productController")
@EnableAspectJAutoProxy
public class AdGoodsControllerImpl implements AdGoodsController {
	
	private static final Logger logger = LoggerFactory.getLogger("ProductControllerImpl.class");
	
	@Autowired
	AdGoodsService adGoodsService;
	
	
	//글목록보기(PageMaker 객체 사용)
	//전체 상품 목록 조회
	@Override
	@RequestMapping(value = "/adgoods/listProduct.do", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public ModelAndView listPageGet(PagingVO vo, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.getServletContext();
		ObjectMapper objm = new ObjectMapper();
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		List prodList = adGoodsService.listProduct(vo);
		List list = adGoodsService.cateList();
		String cateList = objm.writeValueAsString(list);
		
		int cnt = adGoodsService.prodCount(vo);
		int searchcnt = adGoodsService.countSearch(vo);
		
		if(!prodList.isEmpty()) {
			mav.addObject("prodList", prodList);
			mav.addObject("cnt", cnt);
			mav.addObject("searchcnt", searchcnt);
			mav.addObject("cateList", cateList);
		}else {
			mav.addObject("listCheck", "empty");
		}
		
		//페이지 데이터
		mav.addObject("pm", new PageMaker(vo, adGoodsService.prodCount(vo)));
		
		return mav;
	}
	
	//페이징처리한 상품목록
	@Override
	@RequestMapping(value = "/adgoods/listProd.do", method = RequestMethod.GET)
	public void listProduct(PagingVO vo, Model model) throws Exception {
		
		logger.info("C: listVO 겟 호출"+vo);
		
		model.addAttribute("ListProd", adGoodsService.listProduct(vo));
		
	}
	
	
	//상품 상세 정보 조회
	@Override
	@RequestMapping(value = "/adgoods/adgoodsInfo.do", produces = "application/json", method = {RequestMethod.GET, RequestMethod.POST})
	public void getadGoodsDetail(int prod_code, Model model, PagingVO vo) throws Exception{
		
		logger.info("클릭한 상품 : "+prod_code);
		
		ObjectMapper objm = new ObjectMapper();
		
		
		//카테고리 리스트 정보
		model.addAttribute("cateList", objm.writeValueAsString(adGoodsService.cateList()));
		
		//목록 페이지 조건 정보
		model.addAttribute("vo", vo);

		//상품 정보
		model.addAttribute("goodsVO", adGoodsService.adgoodsGetDetail(prod_code));
	
	}
	
	//상품 등록 페이지로 이동
	@Override
	@RequestMapping(value = "/adgoods/moveRegister.do", method = RequestMethod.GET)
	public ModelAndView moveRegister(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		ObjectMapper objm = new ObjectMapper();
		
		List list = adGoodsService.cateList();
		
		String cateList = objm.writeValueAsString(list);
		
		model.addAttribute("cateList", cateList);
		
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
		
	}

	//상품 등록
	@Override
	@RequestMapping(value = "/adgoods/register.do", method = RequestMethod.POST)
	public ModelAndView uploadGoodsRegister(AdGoodsVO agvo, RedirectAttributes rttr) throws Exception {
		
		adGoodsService.register(agvo);
		
		rttr.addFlashAttribute("goodsResult", agvo.getProd_name());
		
		//상품 등록 후 상품 목록 페이지로 리다이렉트
		ModelAndView mav = new ModelAndView("redirect:/adgoods/listProduct.do");
		return mav;
	}
	
	//첨부 파일 업로드
	/*
	 * 1.이미지 파일 저장
	 * 2.썸네일 이미지 파일 생성 및 저장
	 * 3.각 이미지 정보 List 객체에 저장
	 * 4.ResponseEntity를 통해서 뷰(view)로 상태 코드가 200인 List 객체 전송
	 * 5.뷰(view)에서 ajax를 통해 요청 시 JSON 타입의 데이터를 요청						//, consumes = MediaType.APPLICATION_JSON_VALUE
	 */
	@Override																				      //서버에서 뷰로 변환하는 데이터 인코딩
	@RequestMapping(value = "/adgoods/uploadAction.do", produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<AdgoodsImgVO>> uploadAction(@RequestParam MultipartFile[] uploadFile, HttpServletRequest request) throws Exception {
		
		
		//이미지 파일 체크
		for(MultipartFile multipartFile : uploadFile) {
			
			File checkfile = new File(multipartFile.getOriginalFilename());
			String filetype = null;
			
			try {
				
				filetype = Files.probeContentType(checkfile.toPath());
				logger.info("TYPE : " +filetype);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			if(!filetype.startsWith("image")) {
				
				List<AdgoodsImgVO> list = null;
				return new ResponseEntity<List<AdgoodsImgVO>>(list, HttpStatus.BAD_REQUEST);		
			}
		}
		
		/*너무 많은 파일이 한 곳에 모여있지 않도록 날짜 폴더 경로 생성*/
		//날짜 경로 문자열 얻기
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date();
		
		String str = dateformat.format(date);
		
		//2022-01-29 에 포함된 -를 / or  \로 변경
		String datePath = str.replace("-", File.separator);
		
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
		
		//폴더 생성
		File uploadPath = new File(_path, datePath);
		
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		
		//이미지 정보 담는 객체
		List<AdgoodsImgVO> list = new ArrayList();
		
		for(MultipartFile multipartFile : uploadFile) {
			
			AdgoodsImgVO imagevo = new AdgoodsImgVO();
			
			//파일 이름
			String uploadfileName = multipartFile.getOriginalFilename();
			imagevo.setFileName(uploadfileName);
			imagevo.setUploadPath(datePath);
			
			/*uuid 적용 파일 이름*/
			//동일한 이름을 가진 파일을 덮어쓰지 않도록 각 파일이 고유한 이름을 갖도록 UUID(범용 고유 식별자)가 포함되도록함.
			String uuid = UUID.randomUUID().toString();
			imagevo.setUuid(uuid);
			
			uploadfileName = uuid + "_" + uploadfileName;
			
			//파일 경로 + 파일 이름 합친 File 객체
			File saveFile = new File(uploadPath, uploadfileName);
			
			//파일 저장
			try {
				//파일 저장 메서드 transferTo()호출
				multipartFile.transferTo(saveFile);
				
				//썸네일 생성
				File thumbnailFile = new File(uploadPath, "s_" + uploadfileName);
				
					BufferedImage thumbimg = ImageIO.read(saveFile);
					
					//비율
					double ratio = 3;
					//넓이 높이
					int width = (int)(thumbimg.getWidth()/ratio);
					int height = (int)(thumbimg.getHeight()/ratio);
					
				Thumbnails.of(saveFile).size(width, height).toFile(thumbnailFile);	
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			list.add(imagevo);
		}//for
		
		ResponseEntity<List<AdgoodsImgVO>> result = new ResponseEntity<List<AdgoodsImgVO>>(list, HttpStatus.OK);
		
		return result;
	}
	
	//이미지 삭제
	@Override
	@RequestMapping(value = "/adgoods/deleteFile.do")
	@ResponseBody
	public ResponseEntity<String> deleteAction(String fileName, int prod_code, HttpServletRequest request) throws Exception {
		
		logger.info("deleteFile......." + fileName);
		
		File file = null;
		
		try{
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
			
			//썸네일 파일 삭제
			file = new File(_path+URLDecoder.decode(fileName, "UTF-8"));
			
			file.delete();
			
			//원본 이미지 삭제
			String originFile = file.getAbsolutePath().replace("s_", "");
			
			logger.info("originFileName : " + originFile);
			
			file = new File(originFile);
			
			file.delete();
			
			adGoodsService.removeImage(prod_code);
			
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
			return new ResponseEntity<String>("fail", HttpStatus.NOT_IMPLEMENTED);
		}
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	
	//이미지 출력
	@Override
	@RequestMapping(value = "/adgoods/getImageInfo.do")
	@ResponseBody
	public ResponseEntity<byte[]> getadGoodsImage(String fileName, HttpServletRequest request) throws Exception {
		
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
	@RequestMapping(value = "/adgoods/getImageList.do", produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<AdgoodsImgVO>> getImageList(int prod_code) throws Exception {
	
		return new ResponseEntity<List<AdgoodsImgVO>>(adGoodsService.getGoodsImage(prod_code), HttpStatus.OK);
	}

	
	//상품 정보 수정
	@Override
	@RequestMapping(value = "/adgoods/adgoodsModify.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView goodsModify(@RequestParam(value = "prod_code") int prod_code, AdGoodsVO agvo, RedirectAttributes rttr, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int result = adGoodsService.goodsModify(agvo);
		rttr.addFlashAttribute("modify_result", result);
		
		ModelAndView mav = new ModelAndView("redirect:listProduct.do");
		mav.addObject("prod_code", prod_code);
		return mav;	
	}

	
	//상품 정보 삭제
	@Override
	@RequestMapping(value = "/adgoods/adgoodsDelete.do")
	public ModelAndView goodsDelete(int prod_code, RedirectAttributes rttr, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		List<AdgoodsImgVO> fileList = adGoodsService.getGoodsImage(prod_code);
		
		if(fileList != null) {
			List<Path> pathList = new ArrayList();
			
			fileList.forEach(agvo ->{
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
				//원본 이미지
				Path path = Paths.get(_path, agvo.getUploadPath(), agvo.getUuid()+"_"+agvo.getFileName());
				pathList.add(path);
				
				//썸네일 이미지
				path = Paths.get(_path, agvo.getUploadPath(), "s_"+agvo.getUuid()+"_"+agvo.getFileName());
				pathList.add(path);
			});
			
			pathList.forEach(path ->{
				path.toFile().delete();
			});
		}
		
		int result = adGoodsService.goodsDelete(prod_code);
		rttr.addFlashAttribute("delete_result", result);
		
		ModelAndView mav = new ModelAndView("redirect:listProduct.do");
		return mav;
	}

	
	@RequestMapping(value="/adgoods/ckimageUpload.do", method = RequestMethod.POST) 
	public void imageUpload(HttpServletRequest request, HttpServletResponse response, 
			MultipartHttpServletRequest multiFile , @RequestParam MultipartFile upload) throws Exception{ 
		UUID uid = UUID.randomUUID(); 
		OutputStream out = null; 
		PrintWriter printWriter = null; 
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); 
		try{ 
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
			
			String ckUploadPath = _path+ uid + "_" + fileName;
			File folder = new File(_path); 
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
			String fileUrl = "/recipetoyou/adgoods/ckimageSubmit.do?uid=" + uid + "&fileName=" + fileName;
			printWriter.println("{\"filename\" : \""+fileName+"\", \"uploaded\" : 1, \"url\":\""+fileUrl+"\"}"); 
			printWriter.flush(); 
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
	
	@RequestMapping(value="/adgoods/ckimageSubmit.do")
	public void ckSubmit(@RequestParam(value="uid") String uid , @RequestParam(value="fileName") String fileName 
			, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{ 
		
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
		
		String sDirPath = _path + uid + "_" + fileName; 
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
