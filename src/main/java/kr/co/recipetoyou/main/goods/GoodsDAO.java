package kr.co.recipetoyou.main.goods;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import kr.co.recipetoyou.admin.adgoods.AdgoodsImgVO;
import kr.co.recipetoyou.util.PagingVO;

public interface GoodsDAO {

	//페이징
	public List<GoodsVO> listPage(int page)throws Exception;
	
	//페이징 처리, 상품 목록
	public List<GoodsVO> listPaging(PagingVO vo) throws Exception;
	
	//상품 조회
	public GoodsVO selectProdCode(int prod_code)throws Exception;
	
	//이미지 데이터 반환
	public List<AdgoodsImgVO> goodsImageList(int prod_code) throws JsonProcessingException;



}
