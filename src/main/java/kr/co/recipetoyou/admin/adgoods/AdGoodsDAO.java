package kr.co.recipetoyou.admin.adgoods;

import java.io.IOException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.fasterxml.jackson.core.JsonProcessingException;

import kr.co.recipetoyou.admin.adgoods.category.AdGoodsCateVO;
import kr.co.recipetoyou.util.PageMaker;
import kr.co.recipetoyou.util.PagingVO;

public interface AdGoodsDAO {
	
	//페이징
	public List<AdGoodsVO> listPage(int page) throws Exception;
		
	//페이징 처리하는 동작(PagingVO 객체 사용), 상품 목록
	public List<AdGoodsVO> listPaging(PagingVO vo) throws Exception;
		
	//상품 총 개수
	public int goodsCount(PagingVO vo) throws DataAccessException;
		
	//상품 상세 정보 조회
	public AdGoodsVO readGoods(int prod_code) throws DataAccessException;
	
	//상품 상세 정보
	public AdGoodsVO getadGoodsInfo(int prod_code) throws JsonProcessingException;
		
	//카테고리
	public List<AdGoodsCateVO> cateList() throws IOException;
	
	//상품 등록
	public void register(AdGoodsVO agvo) throws Exception;

	//검색 결과 갯수
	public int countSearch(PagingVO vo) throws Exception;
	
	//이미지 등록
	public void imageUpload(AdgoodsImgVO imagevo) throws Exception;
	
	//이미지 데이터 반환
	public List<AdgoodsImgVO> getGoodsImage(int prod_code) throws JsonProcessingException;
	
	//상품 정보 수정
	public int goodsModify(AdGoodsVO agvo) throws Exception;
	
	//상품 정보 삭제
	public int goodsDelete(int prod_code) throws Exception;
	
	//지정 상품 이미지 삭제
	public void removeImage(int prod_code) throws Exception;
	
	//재고 수량 조절
	public void updageStock(AdGoodsVO agvo) throws Exception;

}
