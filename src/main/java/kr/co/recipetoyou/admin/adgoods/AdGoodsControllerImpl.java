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
	
	
	//???????????????(PageMaker ?????? ??????)
	//?????? ?????? ?????? ??????
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
		
		//????????? ?????????
		mav.addObject("pm", new PageMaker(vo, adGoodsService.prodCount(vo)));
		
		return mav;
	}
	
	//?????????????????? ????????????
	@Override
	@RequestMapping(value = "/adgoods/listProd.do", method = RequestMethod.GET)
	public void listProduct(PagingVO vo, Model model) throws Exception {
		
		logger.info("C: listVO ??? ??????"+vo);
		
		model.addAttribute("ListProd", adGoodsService.listProduct(vo));
		
	}
	
	
	//?????? ?????? ?????? ??????
	@Override
	@RequestMapping(value = "/adgoods/adgoodsInfo.do", produces = "application/json", method = {RequestMethod.GET, RequestMethod.POST})
	public void getadGoodsDetail(int prod_code, Model model, PagingVO vo) throws Exception{
		
		logger.info("????????? ?????? : "+prod_code);
		
		ObjectMapper objm = new ObjectMapper();
		
		
		//???????????? ????????? ??????
		model.addAttribute("cateList", objm.writeValueAsString(adGoodsService.cateList()));
		
		//?????? ????????? ?????? ??????
		model.addAttribute("vo", vo);

		//?????? ??????
		model.addAttribute("goodsVO", adGoodsService.adgoodsGetDetail(prod_code));
	
	}
	
	//?????? ?????? ???????????? ??????
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

	//?????? ??????
	@Override
	@RequestMapping(value = "/adgoods/register.do", method = RequestMethod.POST)
	public ModelAndView uploadGoodsRegister(AdGoodsVO agvo, RedirectAttributes rttr) throws Exception {
		
		adGoodsService.register(agvo);
		
		rttr.addFlashAttribute("goodsResult", agvo.getProd_name());
		
		//?????? ?????? ??? ?????? ?????? ???????????? ???????????????
		ModelAndView mav = new ModelAndView("redirect:/adgoods/listProduct.do");
		return mav;
	}
	
	//?????? ?????? ?????????
	/*
	 * 1.????????? ?????? ??????
	 * 2.????????? ????????? ?????? ?????? ??? ??????
	 * 3.??? ????????? ?????? List ????????? ??????
	 * 4.ResponseEntity??? ????????? ???(view)??? ?????? ????????? 200??? List ?????? ??????
	 * 5.???(view)?????? ajax??? ?????? ?????? ??? JSON ????????? ???????????? ??????						//, consumes = MediaType.APPLICATION_JSON_VALUE
	 */
	@Override																				      //???????????? ?????? ???????????? ????????? ?????????
	@RequestMapping(value = "/adgoods/uploadAction.do", produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<AdgoodsImgVO>> uploadAction(@RequestParam MultipartFile[] uploadFile, HttpServletRequest request) throws Exception {
		
		
		//????????? ?????? ??????
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
		
		/*?????? ?????? ????????? ??? ?????? ???????????? ????????? ?????? ?????? ?????? ??????*/
		//?????? ?????? ????????? ??????
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date();
		
		String str = dateformat.format(date);
		
		//2022-01-29 ??? ????????? -??? / or  \??? ??????
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
		
		//?????? ??????
		File uploadPath = new File(_path, datePath);
		
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		
		//????????? ?????? ?????? ??????
		List<AdgoodsImgVO> list = new ArrayList();
		
		for(MultipartFile multipartFile : uploadFile) {
			
			AdgoodsImgVO imagevo = new AdgoodsImgVO();
			
			//?????? ??????
			String uploadfileName = multipartFile.getOriginalFilename();
			imagevo.setFileName(uploadfileName);
			imagevo.setUploadPath(datePath);
			
			/*uuid ?????? ?????? ??????*/
			//????????? ????????? ?????? ????????? ???????????? ????????? ??? ????????? ????????? ????????? ????????? UUID(?????? ?????? ?????????)??? ??????????????????.
			String uuid = UUID.randomUUID().toString();
			imagevo.setUuid(uuid);
			
			uploadfileName = uuid + "_" + uploadfileName;
			
			//?????? ?????? + ?????? ?????? ?????? File ??????
			File saveFile = new File(uploadPath, uploadfileName);
			
			//?????? ??????
			try {
				//?????? ?????? ????????? transferTo()??????
				multipartFile.transferTo(saveFile);
				
				//????????? ??????
				File thumbnailFile = new File(uploadPath, "s_" + uploadfileName);
				
					BufferedImage thumbimg = ImageIO.read(saveFile);
					
					//??????
					double ratio = 3;
					//?????? ??????
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
	
	//????????? ??????
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
			
			//????????? ?????? ??????
			file = new File(_path+URLDecoder.decode(fileName, "UTF-8"));
			
			file.delete();
			
			//?????? ????????? ??????
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
	
	
	//????????? ??????
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
	
	//????????? ?????? ??????
	@Override
	@RequestMapping(value = "/adgoods/getImageList.do", produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<AdgoodsImgVO>> getImageList(int prod_code) throws Exception {
	
		return new ResponseEntity<List<AdgoodsImgVO>>(adGoodsService.getGoodsImage(prod_code), HttpStatus.OK);
	}

	
	//?????? ?????? ??????
	@Override
	@RequestMapping(value = "/adgoods/adgoodsModify.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView goodsModify(@RequestParam(value = "prod_code") int prod_code, AdGoodsVO agvo, RedirectAttributes rttr, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int result = adGoodsService.goodsModify(agvo);
		rttr.addFlashAttribute("modify_result", result);
		
		ModelAndView mav = new ModelAndView("redirect:listProduct.do");
		mav.addObject("prod_code", prod_code);
		return mav;	
	}

	
	//?????? ?????? ??????
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
				//?????? ?????????
				Path path = Paths.get(_path, agvo.getUploadPath(), agvo.getUuid()+"_"+agvo.getFileName());
				pathList.add(path);
				
				//????????? ?????????
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
