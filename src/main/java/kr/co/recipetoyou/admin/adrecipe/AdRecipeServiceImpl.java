package kr.co.recipetoyou.admin.adrecipe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import kr.co.recipetoyou.util.PagingVO;

@Service("adRecipeService")
public class AdRecipeServiceImpl implements AdRecipeService {

	@Autowired
	private AdRecipeDAO dao;
	
	//전체 레시피 게시글 조회
	@Override
	public List<AdRecipeVO> listRecipe(PagingVO vo) throws Exception {		
		List<AdRecipeVO> recipeList = dao.listRecipePaging(vo);
		return recipeList;
	}

	//레시피 게시글 수 조회
	@Override
	public int recipeCount(PagingVO vo) throws DataAccessException {
		return dao.recipeCount(vo);
	}
		
	//레시피 게시글 상세 정보 조회
	@Override
	public AdRecipeVO getRecipeInfo(String id) throws DataAccessException {		
		return dao.readRecipe(id);
	}
		
	//레시피 게시글 삭제
	@Override
	public int removeRecipe(String id) throws DataAccessException {	
		return dao.deleteRecipe(id);	
	}
}
