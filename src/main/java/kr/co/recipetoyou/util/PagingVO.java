package kr.co.recipetoyou.util;

public class PagingVO {
	//페이지 정보, 페이지 크기 정보를 저장하는 객체
		private int page;
		private int pageSize;
		private int rowStart;
		private int rowEnd;
		private int total;	//전체 상품 수
		private PageMaker pmake;	//현재 페이지, 페이지당 상품 표시 수 정보
		
		private String keyword;	//검색할 키워드
		private String type;	//검색할 타입
		private String[] typeArr;	//검색 타입 배열
		private int cateCode;
		private int recipe_idx;
		private int prod_code;
		private String prod_name;
		
		private String title;
		private String user_id;
		private String content;

		private String searchOption;
		private int faq_cate_code;
		
		private int prod_inq_code;
		

		public PagingVO() {
			this.page = 1;
			this.pageSize = 10;
		}
		
		public PagingVO(int page, int pageSize) {
			this.page = page;
			this.pageSize = pageSize;
		}

		public int getPage() {
			return page;
		}

		public void setPage(int page) {
			if(page <=0) {
				this.page = 1;
				return;
			}
			this.page = page;
		}

		public int getPageSize() {
			return pageSize;
		}

		public void setPageSize(int pageSize) {
			if(pageSize <=0 || pageSize > 100) {
				this.pageSize = 10;			
				return;
			}
			this.pageSize = pageSize;			
		}
		
		//페이징처리 시작하는 값생성
		//멤버변수가 아니지만 gettet와 setter를 생성하면 Mapper에서 접근가능하다.
		//Mapper에서 사용하는 법 #{pageStart}
		public int getPageStart() {
			return (this.page - 1)*this.pageSize;
		}
	
		
		public int getRowStart() {
			rowStart = ((page - 1) * pageSize) + 1;
			return rowStart;
		}
		 
		public int getRowEnd() {
			rowEnd = rowStart + pageSize - 1;
			return rowEnd;
		}
		
		public String getKeyword() {
			return keyword;
		}
		public void setKeyword(String keyword) {
			this.keyword = keyword;
		}
		/*
		 * public String getType() { return type; } public void setType(String type) {
		 * this.type = type; } public String[] getTypeArr() { return typeArr; } public
		 * void setTypeArr(String[] typeArr) { this.typeArr = typeArr; }
		 */
		
		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String[] getTypeArr() {
			return typeArr;
		}

		public void setTypeArr(String[] typeArr) {
			this.typeArr = typeArr;
		}

		public int getCateCode() {
			return cateCode;
		}

		public void setCateCode(int cateCode) {
			this.cateCode = cateCode;
		}
		
		public int getRecipe_idx() {
			return recipe_idx;
		}

		public void setRecipe_idx(int recipe_idx) {
			this.recipe_idx = recipe_idx;
		}
		
		public int getProd_inq_code() {
			return prod_inq_code;
		}

		public void setProd_inq_code(int prod_inq_code) {
			this.prod_inq_code = prod_inq_code;
		}

		
		public int getTotal() {
			return total;
		}

		public void setTotal(int total) {
			this.total = total;
		}

		public PageMaker getPmake() {
			return pmake;
		}

		public void setPmake(PageMaker pmake) {
			this.pmake = pmake;
		}

		public int getProd_code() {
			return prod_code;
		}

		public void setProd_code(int prod_code) {
			this.prod_code = prod_code;
		}

		public String getProd_name() {
			return prod_name;
		}

		public void setProd_name(String prod_name) {
			this.prod_name = prod_name;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getSearchOption() {
			return searchOption;
		}

		public void setSearchOption(String searchOption) {
			this.searchOption = searchOption;
		}

		public void setRowStart(int rowStart) {
			this.rowStart = rowStart;
		}

		public void setRowEnd(int rowEnd) {
			this.rowEnd = rowEnd;
		}
		

		public int getFaq_cate_code() {
			return faq_cate_code;
		}

		public void setFaq_cate_code(int faq_cate_code) {
			this.faq_cate_code = faq_cate_code;
		}
		
		public String getUser_id() {
			return user_id;
		}

		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}

		//toString()
		@Override
		public String toString() {
			System.out.println("page"+page);	
			System.out.println("pageSize"+pageSize);
		return "PagingVO [page=" + page + ", pageSize=" + pageSize + ",keyword=" + keyword + ",type="+type+",cateCode="+cateCode +",faq_cate_code="+faq_cate_code+"]";
		}

}

