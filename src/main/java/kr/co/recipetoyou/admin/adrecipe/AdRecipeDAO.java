package kr.co.recipetoyou.admin.adrecipe;

import java.util.List;

import org.springframework.dao.DataAccessException;

import kr.co.recipetoyou.util.PagingVO;

public interface AdRecipeDAO {

	List<AdRecipeVO> listRecipePage(int page) throws Exception;

	List<AdRecipeVO> listRecipePaging(PagingVO vo) throws Exception;

	int recipeCount(PagingVO vo) throws DataAccessException;

	int deleteRecipe(String id) throws DataAccessException;

	AdRecipeVO readRecipe(String id) throws DataAccessException;

}
