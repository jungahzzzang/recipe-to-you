package kr.co.recipetoyou.admin.adgoods.Inquiry;

import java.util.List;

import kr.co.recipetoyou.util.PagingVO;

public interface AdInqReviewService {
	
	//전체 문의 조회
	public List<AdInquiryVO> listInquiry(PagingVO vo)throws Exception;
	
	//문의 상세 페이지
	public AdInquiryVO adInquiryDetail(int prod_inq_code)throws Exception;
	
	//총 문의 수
	public int inquiryAllCount(PagingVO vo)throws Exception;
	
	//검색 결과 개수
	public int inquiryCount(PagingVO vo) throws Exception;
	
	//문의 답변
	public int updateProdQna(AdInquiryVO vo)throws Exception;
	
	//////////////////////////////////////////////////////
	
	//전체 후기 조회
	public List<AdReviewVO> listReview(PagingVO vo)throws Exception;
	
	//후기 총 개수
	public int reviewAllCount(PagingVO vo) throws Exception;
	
	//후기 검색 결과
	public int reviewCount(PagingVO vo)throws Exception;
	
	//후기 상세 조회
	public AdReviewVO adReviewDetail(int prod_review_code) throws Exception;

}
