package kr.co.recipetoyou.admin.adgoods.Inquiry;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.recipetoyou.util.PagingVO;

@Service("adInquiryService")
public class AdInqReviewServiceImpl implements AdInqReviewService {
	
	@Autowired
	AdInqReviewDAO adInquiryDAO;
	
	@Autowired
	AdInqReviewDAO adInqReviewDAO;

	//상품 문의 목록
	@Override
	public List<AdInquiryVO> listInquiry(PagingVO vo) throws Exception {
		
		List<AdInquiryVO> inquiryList = adInquiryDAO.listPaging(vo);
		
		return inquiryList;
	}

	//문의 상세 정보
	@Override
	public AdInquiryVO adInquiryDetail(int prod_inq_code) throws Exception {
		
		return adInquiryDAO.readInquiry(prod_inq_code);
	}

	//총 문의 수
	@Override
	public int inquiryAllCount(PagingVO vo) throws Exception {
		
		return adInquiryDAO.inquiryAllCount(vo);
	}

	
	//검색 결과 개수
	@Override
	public int inquiryCount(PagingVO vo) throws Exception {
		
		return adInquiryDAO.inquiryCount(vo);
	}

	//문의 답변
	@Override
	public int updateProdQna(AdInquiryVO vo) throws Exception {
		
		int result = adInquiryDAO.updateProdQna(vo);
		
		return result;
		
	}

	//후기 목록
	@Override
	public List<AdReviewVO> listReview(PagingVO vo) throws Exception {
		
		List<AdReviewVO> reviewList = adInqReviewDAO.getReviewList(vo);
		
		return reviewList;
	}

	@Override
	public int reviewAllCount(PagingVO vo) throws Exception {
		
		return adInqReviewDAO.reviewAllCount(vo);
	}

	@Override
	public int reviewCount(PagingVO vo) throws Exception {
		
		return adInqReviewDAO.reviewCount(vo);
	}

	@Override
	public AdReviewVO adReviewDetail(int prod_review_code) throws Exception {
		
		return adInqReviewDAO.getReviewDetail(prod_review_code);
	}

}
