package kr.co.recipetoyou.admin.adrecipe;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.recipetoyou.util.PagingVO;

@Repository("adRecipeDAO")
public class AdRecipeDAOImpl implements AdRecipeDAO {

	@Autowired
	private SqlSession sqlSession;
	
	//페이징
	@Override
	public List<AdRecipeVO> listRecipePage(int page) throws Exception {
		//페이지가 0인 경우 1로 바꿔서 처리
		if(page <= 0) {
			page = 1;
		}
		page = (page - 1)*10;
		return sqlSession.selectList("mapper.adrecipe.listRecipePage", page);
	}
		
	//페이징 처리하는 동작(PagingVO 객체 사용)
	@Override
	public List<AdRecipeVO> listRecipePaging(PagingVO vo) throws Exception {
		System.out.println("DAO: listRecipePageVO 호출");
		return sqlSession.selectList("mapper.adrecipe.listRecipePaging", vo);
	}
		
	//레시피 게시글 전체 수 조회
	//DB 테이블에 있는 모든 회원의 주문 수 계산 후 리턴
	@Override
	public int recipeCount(PagingVO vo) throws DataAccessException {	
		return sqlSession.selectOne("mapper.adrecipe.recipeCount", vo);
	}

	//레시피 게시글 삭제 
	@Override
	public int deleteRecipe(@RequestParam("id") String id) throws DataAccessException {	
		int result = sqlSession.delete("mapper.adrecipe.deleteRecipe", id);
		return result;
	}
	
	//레시피 게시글 상세 정보 조회
	@Override
	public AdRecipeVO readRecipe(String id) throws DataAccessException {
		return sqlSession.selectOne("mapper.adrecipe.readRecipe", id);
	}	
}
