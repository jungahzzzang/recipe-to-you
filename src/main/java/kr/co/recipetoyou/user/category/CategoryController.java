package kr.co.recipetoyou.user.category;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

import kr.co.recipetoyou.admin.adgoods.AdgoodsImgVO;
import kr.co.recipetoyou.util.PagingVO;

public interface CategoryController {

	ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception;

	ResponseEntity<byte[]> getGoodsListImage(String fileName, HttpServletRequest request) throws Exception;

	ResponseEntity<List<AdgoodsImgVO>> getGoodsImageList(int prod_code) throws Exception;

	ModelAndView goodsView(PagingVO vo, int prod_code, HttpServletRequest request, HttpServletResponse response) throws Exception;

	


}
