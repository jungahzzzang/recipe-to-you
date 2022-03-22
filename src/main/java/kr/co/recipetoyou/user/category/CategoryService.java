package kr.co.recipetoyou.user.category;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.fasterxml.jackson.core.JsonProcessingException;

import kr.co.recipetoyou.admin.adgoods.AdgoodsImgVO;
import kr.co.recipetoyou.util.PagingVO;

public interface CategoryService {

	List<CategoryVO> goodsInfoList() throws DataAccessException;

	List<CategoryVO> bargainList() throws DataAccessException;

	List<AdgoodsImgVO> getGoodsInfoImage(int prod_code) throws Exception;

	CategoryVO getGoodsInfo(int prod_code) throws JsonProcessingException;

	CategoryVO goodsDetailInfo(int prod_code) throws DataAccessException;

	List<CategoryVO> goodsDetailList() throws DataAccessException;

	int cateCount(PagingVO vo, int type) throws DataAccessException;

	List<CategoryVO> listGoods(PagingVO vo, int type) throws DataAccessException;
	
	AdgoodsImgVO getGoodsDetailImage(int prod_code) throws DataAccessException, JsonProcessingException;



}
