package kr.co.recipetoyou.util;

import java.io.UnsupportedEncodingException;

import java.net.URLEncoder;



public class PageMaker {
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	

	//PagingVO안에 page, pageSize 있음
	private PagingVO vo;
	
	//화면에 보여지는 페이지블럭의 수
	private int displayPageNum = 10;

	public PageMaker() {}
	//게시글 총 갯수, 시작페이지, 끝페이지, 이전, 다음, pagingVO, 페이지블럭 수 
	public PageMaker(int totalCount, int startPage, int endPage, boolean prev, boolean next, PagingVO vo,
			int displayPageNum) {
		//super();
		this.totalCount = totalCount;
		this.startPage = startPage;
		this.endPage = endPage;
		this.prev = prev;
		this.next = next;
		this.vo = vo;
		this.displayPageNum = displayPageNum;
	}
	
	public PageMaker(PagingVO vo, int totalCount) {
		this.vo = vo;
		this.totalCount = totalCount;
		
		//마지막페이지
		this.endPage = (int)(Math.ceil(vo.getPage()/10.0))*10;
		
		//시작 페이지
		this.startPage = this.endPage - 9;
		
		//전체 마지막 페이지
		int realEnd = (int)(Math.ceil(totalCount * 1.0/vo.getPageSize()));
		
		//전체 마지막 페이지(realEnd)가 화면에 보이는 마지막 페이지(endPage)보다 작은 경우, 보이는 페이지(endPage) 값 조정
		if(realEnd<this.endPage) {
			this.endPage = realEnd;
		}
		
		//시작페이지(startPage)값이 1보다 큰 경우 true
		this.prev = this.startPage>1;
		
		//마지막 페이지(endPage)값이 1보다 큰 경우 true
		this.next = this.endPage<realEnd;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) { //변경
		//totalCount : 게시물의 총 갯수
		this.totalCount = totalCount;
		System.out.println("DB에서 총 글의 개수를 계산" + totalCount);
		//총 글의 개수를 가지고 왔을때 필요한 정보를 계산
		calcDate();
	}
	
	private void calcDate() {
		//endPage : 현재 페이지의 끝 번호 (10, 20, 30 등등)
		endPage = (int) (Math.ceil(vo.getPage()/(double)displayPageNum) * displayPageNum);
		//startPage : 현재 페이지의 시작 번호 (1, 11, 21 등등) 
		startPage = (endPage - displayPageNum) +1;
		
		int tempEndPage = (int) (Math.ceil(totalCount/(double)vo.getPageSize()));
		if(endPage > tempEndPage) endPage = tempEndPage;
		if (endPage > tempEndPage)
		{
		endPage = tempEndPage;
		}
		//prev : 이전 페이지로 이동하는 링크의 존재 여부
		prev = (startPage == 1? false:true);
		//next : 다음 페이지로 이동하는 링크의 존재 여부
		next = (endPage * vo.getPageSize() >= totalCount? false:true);
		System.out.println("페이징처리정보 계산");
		System.out.println("endPage"+endPage);
		System.out.println("startPage"+startPage);
		System.out.println("tempEndPage"+tempEndPage);
		System.out.println("prev"+prev);
		System.out.println("next"+next);
		
	}
	

	
	private String encoding(String keyword) {
		if(keyword == null || keyword.trim().length() == 0)
		 { return ""; }
		 
		 try {
		  return URLEncoder.encode(keyword, "UTF-8");
		 } catch(UnsupportedEncodingException e)
		 { return ""; }
	}
	
	

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public PagingVO getVo() {
		return vo;
	}

	public void setVo(PagingVO vo) { //변경
		this.vo = vo;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}
	

	
	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", vo=" + vo + ", displayPageNum=" + displayPageNum + "]";
	}	
	
}
