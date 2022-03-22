package kr.co.recipetoyou.board.recipe;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.recipetoyou.util.PagingVO;

@Repository("RecipeDAO")
public class RecipeDAOImpl implements RecipeDAO{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<RecipeVO> selectRecipeList(PagingVO vo) {
		if(vo.getCateCode() % 1000 == 0) {
			vo.setCateCode(vo.getCateCode()/1000);
			System.out.println("cateCode:"+vo.getCateCode());
		}
		System.out.println("type:"+vo.getType());
		List<RecipeVO> recipeList = sqlSession.selectList("mapper.recipe.selectRecipeList",vo);
		return recipeList;
	}

	@Override
	public List<RecipeCateVO> selectRecipeCateTitleList() {
		List<RecipeCateVO> recipeCateTitleList = sqlSession.selectList("mapper.recipe.selectRecipeCateTitleList");
		return recipeCateTitleList;
	}

	@Override
	public List<RecipeCateVO> selectRecipeCateDetailList() {
		List<RecipeCateVO> recipeCateTitleList = sqlSession.selectList("mapper.recipe.selectRecipeCateDetailList");
		return recipeCateTitleList;
	}

	@Override
	public List<RecipeCateVO> selectRecipeCateList() {
		List<RecipeCateVO> recipeCateList = sqlSession.selectList("mapper.recipe.selectRecipeCateList");
		return recipeCateList;
	}

	@Override
	public void insertRecipe(Map recipeMap) {
		sqlSession.insert("mapper.recipe.insertRecipe",recipeMap);
		
	}

	@Override
	public RecipeVO selectRecipeDetail(int recipe_idx) {
		RecipeVO recipeVO = sqlSession.selectOne("mapper.recipe.selectRecipeDetail",recipe_idx);
		return recipeVO;
	}

	@Override
	public RecipeVO modifyRecipe(int recipe_idx) {
		return sqlSession.selectOne("mapper.recipe.modifyRecipe",recipe_idx);
	}

	@Override
	public void deleteRecipe(int recipe_idx) {
		sqlSession.delete("mapper.recipe.deleteRecipe",recipe_idx);
		
	}

	@Override
	public void updateRecipe(Map recipeMap) {
		sqlSession.update("mapper.recipe.updateRecipe",recipeMap);
		
	}

	@Override
	public int selectRecipeCount(PagingVO vo) {
		int result = sqlSession.selectOne("mapper.recipe.recipeCount",vo);
		return result;
	}

	@Override
	public int selectRecipeReviewCount(int recipe_idx) {
		
		
		return sqlSession.selectOne("mapper.recipe.selectRecipeReviewCount",recipe_idx);
	}

	@Override
	public List<RecipeReviewVO> selectRecipeReviewList(PagingVO vo) {
		List<RecipeReviewVO> list = sqlSession.selectList("mapper.recipe.selectRecipeReviewList", vo);
		System.out.println(list);
		return list;
	}

	@Override
	public void insertRecipeReview(RecipeReviewVO recipeReviewVO) {
		sqlSession.insert("mapper.recipe.insertRecipeReview",recipeReviewVO);
		
	}
	
	

}
