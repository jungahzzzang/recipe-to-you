package kr.co.recipetoyou.board.recipe;

import java.sql.Date;

import org.springframework.stereotype.Component;

import kr.co.recipetoyou.util.PagingVO;

@Component("recipeReviewVO")
public class RecipeReviewVO {
	
	private int recipe_comment_idx;
	private int recipe_idx;
	private String user_id;
	private Date reg_date;
	private String content;
	private int recipe_star;
	private RecipeVO recipeVO;
	private PagingVO pagingVO;
	
	public RecipeReviewVO() {
		
	}
	
	public RecipeReviewVO(int recipe_comment_idx, int recipe_idx, String user_id, Date reg_date, String content,
			int recipe_star) {
		super();
		this.recipe_comment_idx = recipe_comment_idx;
		this.recipe_idx = recipe_idx;
		this.user_id = user_id;
		this.reg_date = reg_date;
		this.content = content;
		this.recipe_star = recipe_star;
	}

	public RecipeReviewVO(int recipe_comment_idx, int recipe_idx, String user_id, Date reg_date, String content,
			int recipe_star, RecipeVO recipeVO) {
		super();
		this.recipe_comment_idx = recipe_comment_idx;
		this.recipe_idx = recipe_idx;
		this.user_id = user_id;
		this.reg_date = reg_date;
		this.content = content;
		this.recipe_star = recipe_star;
		this.recipeVO = recipeVO;
	}

	public RecipeReviewVO(int recipe_comment_idx, int recipe_idx, String user_id, Date reg_date, String content,
			int recipe_star, RecipeVO recipeVO, PagingVO pagingVO) {
		super();
		this.recipe_comment_idx = recipe_comment_idx;
		this.recipe_idx = recipe_idx;
		this.user_id = user_id;
		this.reg_date = reg_date;
		this.content = content;
		this.recipe_star = recipe_star;
		this.recipeVO = recipeVO;
		this.pagingVO = pagingVO;
	}
	
	public PagingVO getPagingVO() {
		return pagingVO;
	}

	public void setPagingVO(PagingVO pagingVO) {
		this.pagingVO = pagingVO;
	}

	public RecipeVO getRecipeVO() {
		return recipeVO;
	}

	public void setRecipeVO(RecipeVO recipeVO) {
		this.recipeVO = recipeVO;
	}

	public int getRecipe_comment_idx() {
		return recipe_comment_idx;
	}

	public void setRecipe_comment_idx(int recipe_comment_idx) {
		this.recipe_comment_idx = recipe_comment_idx;
	}

	public int getRecipe_idx() {
		return recipe_idx;
	}

	public void setRecipe_idx(int recipe_idx) {
		this.recipe_idx = recipe_idx;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRecipe_star() {
		return recipe_star;
	}

	public void setRecipe_star(int recipe_star) {
		this.recipe_star = recipe_star;
	}

	@Override
	public String toString() {
		return "RecipeReviewVO [recipe_comment_idx=" + recipe_comment_idx + ", recipe_idx=" + recipe_idx + ", user_id="
				+ user_id + ", reg_date=" + reg_date + ", content=" + content + ", recipe_star=" + recipe_star
				+ ", recipeVO=" + recipeVO + "]";
	}
	
	
	
}
