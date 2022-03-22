package kr.co.recipetoyou.main.goods;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;

import kr.co.recipetoyou.admin.adgoods.AdgoodsImgVO;
import kr.co.recipetoyou.util.PagingVO;

@Repository("goodsDAO")
public class GoodsDAOImpl implements GoodsDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "mapper.goods";
	
	@Override
	public GoodsVO selectProdCode(int prod_code)throws Exception{
		GoodsVO goodsVO = sqlSession.selectOne(NAMESPACE+".selectProdCode", prod_code);
		return goodsVO;
	}
	
	@Override
	public List<GoodsVO> listPage(int page) throws Exception {
		//페이지가 0인 경우 1로 바꿔서 처리
		if(page <= 0) {
			page = 1;
		}
		page = (page - 1)*10;
		return sqlSession.selectList(NAMESPACE+".listPage", page);
	}

	@Override
	public List<GoodsVO> listPaging(PagingVO vo) throws Exception {
		return sqlSession.selectList(NAMESPACE+".selectGoodsList", vo);
	}

	//이미지 데이터 반환
	@Override
	public List<AdgoodsImgVO> goodsImageList(int prod_code) throws JsonProcessingException {
		
		return sqlSession.selectList(NAMESPACE+".goodsImageList", prod_code);
	}
	

	

	

}
