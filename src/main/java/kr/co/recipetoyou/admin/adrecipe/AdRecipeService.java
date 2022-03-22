package kr.co.recipetoyou.admin.adrecipe;

import java.util.List;

import org.springframework.dao.DataAccessException;

import kr.co.recipetoyou.util.PagingVO;

public interface AdRecipeService {

	List<AdRecipeVO> listRecipe(PagingVO vo) throws Exception;

	int recipeCount(PagingVO vo) throws DataAccessException;

	AdRecipeVO getRecipeInfo(String id) throws DataAccessException;

	int removeRecipe(String id) throws DataAccessException;

}
