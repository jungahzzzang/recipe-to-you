package kr.co.recipetoyou.board.recipe;

import java.sql.Date;

import org.springframework.stereotype.Component;

import kr.co.recipetoyou.util.PagingVO;

@Component("recipeVO")
public class RecipeVO {
	
	private String recipe_idx;
	private int prod_code;
	private String recipe_title;
	private String recipe_content;
	private String recipe_ingre;
	private int recipe_cate_code;
	private String recipe_img;
	private String user_id;
	private Date recipe_reg_date;
	private PagingVO pagingVO;
	
	


	public PagingVO getPagingVO() {
		return pagingVO;
	}

	public void setPagingVO(PagingVO pagingVO) {
		this.pagingVO = pagingVO;
	}

	public RecipeVO() {
		// TODO Auto-generated constructor stub
	}

	public RecipeVO(String recipe_idx, int prod_code, String recipe_title, String recipe_content, String recipe_ingre,
			int recipe_cate_code, String recipe_img, String user_id, Date recipe_reg_date) {
		super();
		this.recipe_idx = recipe_idx;
		this.prod_code = prod_code;
		this.recipe_title = recipe_title;
		this.recipe_content = recipe_content;
		this.recipe_ingre = recipe_ingre;
		this.recipe_cate_code = recipe_cate_code;
		this.recipe_img = recipe_img;
		this.user_id = user_id;
		this.recipe_reg_date = recipe_reg_date;
	}

	public String getRecipe_idx() {
		return recipe_idx;
	}

	public void setRecipe_idx(String recipe_idx) {
		this.recipe_idx = recipe_idx;
	}

	public int getProd_code() {
		return prod_code;
	}

	public void setProd_code(int prod_code) {
		this.prod_code = prod_code;
	}

	public String getRecipe_title() {
		return recipe_title;
	}

	public void setRecipe_title(String recipe_title) {
		this.recipe_title = recipe_title;
	}

	public String getRecipe_content() {
		return recipe_content;
	}

	public void setRecipe_content(String recipe_content) {
		this.recipe_content = recipe_content;
	}

	public String getRecipe_ingre() {
		return recipe_ingre;
	}

	public void setRecipe_ingre(String recipe_ingre) {
		this.recipe_ingre = recipe_ingre;
	}

	public int getRecipe_cate_code() {
		return recipe_cate_code;
	}

	public void setRecipe_cate_code(int recipe_cate_code) {
		this.recipe_cate_code = recipe_cate_code;
	}

	public String getRecipe_img() {
		return recipe_img;
	}

	public void setRecipe_img(String recipe_img) {
		this.recipe_img = recipe_img;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Date getRecipe_reg_date() {
		return recipe_reg_date;
	}

	public void setRecipe_reg_date(Date recipe_reg_date) {
		this.recipe_reg_date = recipe_reg_date;
	}

	@Override
	public String toString() {
		return "RecipeVO [recipe_idx=" + recipe_idx + ", prod_code=" + prod_code + ", recipe_title=" + recipe_title
				+ ", recipe_content=" + recipe_content + ", recipe_ingre=" + recipe_ingre + ", recipe_cate_code="
				+ recipe_cate_code + ", recipe_img=" + recipe_img + ", user_id=" + user_id + ", recipe_reg_date="
				+ recipe_reg_date + "]";
	}
	
	

}
