package kr.co.recipetoyou.admin.adgoods.Inquiry;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import kr.co.recipetoyou.main.inqreview.ReviewVO;
import kr.co.recipetoyou.util.PagingVO;

public interface AdInqReviewDAO {
	
	//문의 페이징
	public List<AdInquiryVO> listPage(int page) throws Exception;
	
	//전체 문의 조회
	public List<AdInquiryVO> listPaging(PagingVO vo) throws Exception;
	
	//문의 상세 내용 조회
	public AdInquiryVO readInquiry(int prod_code) throws Exception;
	
	//전체 후기 수 조회
	//DB 테이블에 있는 모든 후기 수 계산 후 리턴
	public int inquiryAllCount(PagingVO vo) throws DataAccessException;
		
	//검색 결과 개수
	public int inquiryCount(PagingVO vo) throws Exception;
	
	//문의 답변
	public int updateProdQna(AdInquiryVO vo)throws Exception;
	
	//후기 페이징
	public List<AdReviewVO> revlistPaging(int page) throws Exception;
	
	//후기 목록
	public List<AdReviewVO> getReviewList(PagingVO vo)throws Exception;
	
	//총 후기 수
	public int reviewAllCount(PagingVO vo) throws Exception;
	
	//검색 결과에 맞는 후기 수
	public int reviewCount(PagingVO vo)throws Exception;
	
	//후기 조회
	public AdReviewVO getReviewDetail(int prod_review_code)throws Exception;
	
	

}
