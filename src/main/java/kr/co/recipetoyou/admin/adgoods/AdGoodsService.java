package kr.co.recipetoyou.admin.adgoods;

import java.io.IOException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.fasterxml.jackson.core.JsonProcessingException;

import kr.co.recipetoyou.admin.adgoods.category.AdGoodsCateVO;
import kr.co.recipetoyou.util.PageMaker;
import kr.co.recipetoyou.util.PagingVO;

public interface AdGoodsService {

	
	//전체 상품 조회
	public List<AdGoodsVO> listProduct(PagingVO vo) throws Exception;
		
	//조회된 상품 수 조회
	public int prodCount(PagingVO vo) throws DataAccessException;
		
	//상품 상세 페이지
	public AdGoodsVO adgoodsGetDetail(int prod_code) throws Exception;
	
	//상품 상세 정보
	public AdGoodsVO getadGoodsInfo(int prod_code) throws JsonProcessingException;
		
	//카테고리 리스트
	public List<AdGoodsCateVO> cateList() throws Exception;
		
	//상품명 검색
	//public List<AdGoodsVO> listSearch(PagingVO vo) throws Exception;
	
	//상품 등록
	public void register(AdGoodsVO agvo) throws Exception;
		
	//검색 결과 갯수
	public int countSearch(PagingVO vo) throws Exception;
	
	//이미지 데이터 반환
	public List<AdgoodsImgVO> getGoodsImage(int prod_code) throws Exception;
	
	//상품 정보 수정
	public int goodsModify(AdGoodsVO agvo) throws Exception;
	
	//상품 정보 삭제
	public int goodsDelete(int prod_code) throws Exception;
	
	//상품 이미지 삭제
	public void removeImage(int prod_code)throws Exception;
	
	//재고 관리
	public void updageStock(AdGoodsVO agvo) throws Exception;
}
