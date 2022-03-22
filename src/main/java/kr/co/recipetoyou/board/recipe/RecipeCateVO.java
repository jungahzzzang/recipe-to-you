package kr.co.recipetoyou.board.recipe;

import org.springframework.stereotype.Component;

@Component("recipeCateVO")
public class RecipeCateVO {

	private int recipe_cate_code;
	private String recipe_cate;
	private int recipe_cate_parent;
	
	public RecipeCateVO() {
	}
	public RecipeCateVO(int recipe_cate_code, String recipe_cate, int recipe_cate_parent) {
		super();
		this.recipe_cate_code = recipe_cate_code;
		this.recipe_cate = recipe_cate;
		this.recipe_cate_parent = recipe_cate_parent;
	}
	public int getRecipe_cate_code() {
		return recipe_cate_code;
	}
	public void setRecipe_cate_code(int recipe_cate_code) {
		this.recipe_cate_code = recipe_cate_code;
	}
	public String getRecipe_cate() {
		return recipe_cate;
	}
	public void setRecipe_cate(String recipe_cate) {
		this.recipe_cate = recipe_cate;
	}
	public int getRecipe_cate_parent() {
		return recipe_cate_parent;
	}
	public void setRecipe_cate_parent(int recipe_cate_parent) {
		this.recipe_cate_parent = recipe_cate_parent;
	}
	
	
}
