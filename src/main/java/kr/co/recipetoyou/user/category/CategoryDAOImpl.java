package kr.co.recipetoyou.user.category;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;

import kr.co.recipetoyou.admin.adgoods.AdgoodsImgVO;
import kr.co.recipetoyou.util.PagingVO;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "mapper.main";
	
	@Override
	public List<CategoryVO> goodsInfo() throws DataAccessException{
		List<CategoryVO> goodsInfoList = sqlSession.selectList(NAMESPACE+".goodsInfo");
		return goodsInfoList;
	}
	
	//이미지 데이터 반환
	@Override
	public List<AdgoodsImgVO> getGoodsInfoImage(int prod_code) throws JsonProcessingException {
		return sqlSession.selectList(NAMESPACE+".getGoodsImageList", prod_code);
	}
	//이미지 데이터 반환
	@Override
	public List<AdgoodsImgVO> getBargainImage(int prod_code) throws JsonProcessingException {
		return sqlSession.selectList(NAMESPACE+".getBargainList", prod_code);
	}
	
	
	  @Override public CategoryVO getGoodsInfo(int prod_code) throws
	  JsonProcessingException { return
	  sqlSession.selectOne(NAMESPACE+".getGoodsInfo", prod_code); }
	 
	@Override
	public List<CategoryVO> bargain() throws DataAccessException {
		List<CategoryVO> bargainList = sqlSession.selectList(NAMESPACE+".bargain");
		return bargainList;
	}
	
	
	  @Override public CategoryVO goodsDetailInfo(int prod_code) throws DataAccessException{
		  return sqlSession.selectOne(NAMESPACE+".goodsDetailInfo", prod_code);
		  
	  }
	 

	@Override
	public List<CategoryVO> goodsDetail() throws DataAccessException {
		List<CategoryVO> goodsDetail = sqlSession.selectList(NAMESPACE+".goodsDetail");
		return goodsDetail;
	}

	@Override
	public int cateCount(PagingVO vo, int type) throws DataAccessException {
		int result = 0;
		switch(type) {
		case 1:
			result = sqlSession.selectOne(NAMESPACE+".cateNewCount", vo);
			 break;
		case 2:
			result = sqlSession.selectOne(NAMESPACE+".cateBestCount", vo);
			break;
		case 3:
			result = sqlSession.selectOne(NAMESPACE+".cateSaleCount", vo);
			break;
		default:
			break;
		}
		return result;
	}

	@Override
	public List<CategoryVO> listGoods(PagingVO vo, int type) throws DataAccessException {
		List<CategoryVO> listGoods = null;
		switch(type) {
		case 1:
			 listGoods = sqlSession.selectList(NAMESPACE+".listNewGoods", vo);
			 break;
		case 2:
			listGoods = sqlSession.selectList(NAMESPACE+".listBestGoods", vo);
			break;
		case 3:
			listGoods = sqlSession.selectList(NAMESPACE+".listSaleGoods", vo);
			break;
		default:
			break;
		}
		return listGoods;
		 
	}

	@Override
	public List<AdgoodsImgVO> getGoodsDetailList(int prod_code) throws JsonProcessingException {
		return sqlSession.selectList(NAMESPACE+".getGoodsDetailList", prod_code);
	}

	@Override
	public AdgoodsImgVO getGoodsDetailImage(int prod_code) throws JsonProcessingException {
		return sqlSession.selectOne(NAMESPACE+".getGoodsDetailImage", prod_code);
	}

	@Override
	public List<AdgoodsImgVO> getNewGoodsList(int prod_code) throws JsonProcessingException {
		return sqlSession.selectList(NAMESPACE+".getNewGoodsList", prod_code);
	}
}
