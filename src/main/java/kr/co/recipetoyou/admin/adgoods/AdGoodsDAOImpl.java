package kr.co.recipetoyou.admin.adgoods;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;

import kr.co.recipetoyou.admin.adgoods.category.AdGoodsCateVO;
import kr.co.recipetoyou.util.PageMaker;
import kr.co.recipetoyou.util.PagingVO;

@Repository("adgoodsDAO")
public class AdGoodsDAOImpl implements AdGoodsDAO{
	
	@Autowired
	private SqlSession sqlSession;	//DB 연결 (XML에서 만들어진 객체를 가져다 사용하겠다. = 의존 주입)
	
	private static final String NAMESPACE = "mapper.adgoods"; 	//mapper 구분하는 값 namespace
	
	//페이징
	@Override
	public List<AdGoodsVO> listPage(int page) throws Exception {
		
		//페이지가 0인 경우 1로 바꿔서 처리
		if(page <= 0) {
			page = 1;
		}
		page = (page - 1)*10;
		return sqlSession.selectList(NAMESPACE+".listPage", page);
	}

	//페이징 처리, 상품 목록, 상품명으로 검색
	@Override
	public List<AdGoodsVO> listPaging(PagingVO vo) throws Exception {
		
		return sqlSession.selectList(NAMESPACE+".getadGoodsList", vo);
	}
	
	
	//상품 수 조회
	//DB 테이블에 있는 모든 상품수 계산 후 리턴
	@Override
	public int goodsCount(PagingVO vo) throws DataAccessException {
		
	
		return sqlSession.selectOne(NAMESPACE+".getGoodsCount", vo);
	}

	//상품 상세 페이지
	@Override
	public AdGoodsVO readGoods(int prod_code) throws DataAccessException {
		
		return sqlSession.selectOne(NAMESPACE+".adGoodsDetail", prod_code);
	}
	
	//상품 정보
	@Override
	public AdGoodsVO getadGoodsInfo(int prod_code) throws JsonProcessingException {
		
		return sqlSession.selectOne(NAMESPACE+".getadGoodsInfo", prod_code);
	}
	
	//카테고리
	@Override
	public List<AdGoodsCateVO> cateList() throws IOException {
		
		return sqlSession.selectList(NAMESPACE+".cateList");
	}
	
	//검색 결과 개수
	@Override
	public int countSearch(PagingVO vo) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+".getSearchCount", vo);
	}
	
	//상품 등록
	@Override
	public void register(AdGoodsVO agvo) throws Exception {
		
		sqlSession.insert(NAMESPACE+".register", agvo);
		
	}
	
	//이미지 등록
	@Override
	public void imageUpload(AdgoodsImgVO imagevo) throws Exception {
		
		
		sqlSession.insert(NAMESPACE+".imageUpload", imagevo);
		
	}

	//이미지 데이터 반환
	@Override
	public List<AdgoodsImgVO> getGoodsImage(int prod_code) throws JsonProcessingException {
		
		return sqlSession.selectList(NAMESPACE+".getImageList", prod_code);
	}

	//상품 정보 수정
	@Override
	public int goodsModify(AdGoodsVO agvo) throws Exception {
		
	
		return sqlSession.update(NAMESPACE+".goodsModify", agvo);
	}

	//상품 정보 삭제
	@Override
	public int goodsDelete(int prod_code) throws Exception {
		
		return sqlSession.delete(NAMESPACE+".goodsDelete", prod_code);
	}
	
	//지정 상품 이미지 삭제
	@Override
	public void removeImage(int prod_code) throws Exception {
		
		
		sqlSession.delete(NAMESPACE+".removeImageAll",prod_code);
		
	}

	//재고 관리
	@Override
	public void updageStock(AdGoodsVO agvo) throws Exception {
		
		sqlSession.update(NAMESPACE+".updageStock", agvo);
		
	}


}
