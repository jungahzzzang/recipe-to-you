package kr.co.recipetoyou.admin.adgoods;

import java.io.IOException; 

import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;

import kr.co.recipetoyou.admin.adgoods.category.AdGoodsCateVO;
import kr.co.recipetoyou.util.PageMaker;
import kr.co.recipetoyou.util.PagingVO;

public interface AdGoodsController {

	
	public ModelAndView listPageGet(PagingVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	//상품 목록 조회 및 페이징 처리
	public void listProduct(PagingVO vo, Model model) throws Exception;
	
	
	//상품 상세 정보 조회
	public void getadGoodsDetail(int prod_code, Model model, PagingVO vo) throws Exception;
	
	//상품 등록 페이지로 이동
	public ModelAndView moveRegister(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	//상품 등록
	public ModelAndView uploadGoodsRegister(AdGoodsVO agvo, RedirectAttributes rttr) throws Exception;
	
	//이미지 업로드
	public ResponseEntity<List<AdgoodsImgVO>> uploadAction(MultipartFile[] uploadFile, HttpServletRequest reuqest)
			throws Exception; 
	
	//이미지 삭제
	public ResponseEntity<String> deleteAction(String fileName, int prod_code, HttpServletRequest request) throws Exception;
	
	//이미지 출력
	public ResponseEntity<byte[]> getadGoodsImage(String fileName, HttpServletRequest request) throws Exception;
	
	//이미지 정보 반환
	public ResponseEntity<List<AdgoodsImgVO>> getImageList(int prod_code) throws Exception;
	
	//상품 정보 수정
	public ModelAndView goodsModify(@RequestParam(value = "prod_code") int prod_code, AdGoodsVO agvo, RedirectAttributes rttr, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	
	//상품 정보 삭제
	public ModelAndView goodsDelete(int prod_code, RedirectAttributes rttr, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	//ck에디터 이미지 업로드
	public void imageUpload(HttpServletRequest request, HttpServletResponse response, MultipartHttpServletRequest multiFile , @RequestParam MultipartFile upload) throws Exception;
	
	//ck이미지 전송
	public void ckSubmit(@RequestParam(value="uid") String uid , @RequestParam(value="fileName") String fileName 
			, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	

	

	
	
}
