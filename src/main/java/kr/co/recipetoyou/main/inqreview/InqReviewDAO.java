package kr.co.recipetoyou.main.inqreview;

import java.util.List;
import java.util.Map;

import kr.co.recipetoyou.util.PagingVO;

public interface InqReviewDAO {
	
	//문의 페이징
	public List<InquiryVO> inqlistPaging(int page)throws Exception;
	
	//문의 목록
	public List<InquiryVO> getInquiryList(PagingVO vo)throws Exception;
	
	//문의 등록
	public void insertInquiry(InquiryVO vo)throws Exception;
	
	//총 문의 수
	public int qnaCount(PagingVO vo) throws Exception;
	
	//후기 페이징
	public List<ReviewVO> revlistPaging(int page) throws Exception;
	
	//후기 목록
	public List<ReviewVO> getReviewList(PagingVO vo)throws Exception;
	
	//후기 작성
	public void insertReview(ReviewVO vo)throws Exception;
	
	public int reviewCount(PagingVO vo) throws Exception;
	
	//후기 조회
	public ReviewVO getReviewDetail(int prod_review_code)throws Exception;
	
	public int checkOrderUser(Map<String, Object>map)throws Exception;

}
