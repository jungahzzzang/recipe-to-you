package kr.co.recipetoyou.user.category;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.fasterxml.jackson.core.JsonProcessingException;

import kr.co.recipetoyou.admin.adgoods.AdgoodsImgVO;
import kr.co.recipetoyou.util.PagingVO;

public interface CategoryDAO {

	List<CategoryVO> goodsInfo() throws DataAccessException;

	List<CategoryVO> bargain() throws DataAccessException;

	List<AdgoodsImgVO> getGoodsInfoImage(int prod_code) throws JsonProcessingException;

	CategoryVO getGoodsInfo(int prod_code) throws JsonProcessingException;

	CategoryVO goodsDetailInfo(int prod_code) throws DataAccessException;

	List<CategoryVO> goodsDetail() throws DataAccessException;

	int cateCount(PagingVO vo, int type) throws DataAccessException;

	List<CategoryVO> listGoods(PagingVO vo, int type) throws DataAccessException;


	List<AdgoodsImgVO> getBargainImage(int prod_code) throws JsonProcessingException;


	AdgoodsImgVO getGoodsDetailImage(int prod_code) throws JsonProcessingException;

	List<AdgoodsImgVO> getGoodsDetailList(int prod_code) throws JsonProcessingException;

	List<AdgoodsImgVO> getNewGoodsList(int prod_code) throws JsonProcessingException;

}
