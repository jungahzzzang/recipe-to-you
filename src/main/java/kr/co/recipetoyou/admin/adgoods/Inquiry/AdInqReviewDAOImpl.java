package kr.co.recipetoyou.admin.adgoods.Inquiry;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import kr.co.recipetoyou.main.inqreview.ReviewVO;
import kr.co.recipetoyou.util.PagingVO;

@Repository("adInquiryDAO")
public class AdInqReviewDAOImpl implements AdInqReviewDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "mapper.adinqreview";

	//페이징
	@Override
	public List<AdInquiryVO> listPage(int page) throws Exception {
		
		//페이지가 0인 경우 1로 바꿔서 처리
				if(page <= 0) {
					page = 1;
				}
				page = (page - 1)*10;
				return sqlSession.selectList(NAMESPACE+".listinqPage", page);
	}

	//전체 목록 조회
	@Override
	public List<AdInquiryVO> listPaging(PagingVO vo) throws Exception {
		
		return sqlSession.selectList(NAMESPACE+".getadInquiryList", vo);
	}

	//문의 상세 페이지
	@Override
	public AdInquiryVO readInquiry(int prod_inq_code) throws Exception {
		
		System.out.println("prod_code"+prod_inq_code);
		
		return sqlSession.selectOne(NAMESPACE+".getadInquiryDetail", prod_inq_code);
	}

	//총 문의 수
	@Override
	public int inquiryAllCount(PagingVO vo) throws DataAccessException {
		
		return sqlSession.selectOne(NAMESPACE+".getInquiryAllCount", vo);
	}

	//검색 결과 개수
	@Override
	public int inquiryCount(PagingVO vo) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+".getInquiryCount", vo);
	}
	
	//문의 답변 수정
	@Override
	public int updateProdQna(AdInquiryVO vo) throws Exception {
		
		return sqlSession.update(NAMESPACE+".updateProdQna", vo);
		
	}
	
	///////////////////////////////////////////////
	
	//후기 페이징
	@Override
	public List<AdReviewVO> revlistPaging(int page) throws Exception {
		
		//페이지가 0인 경우 1로 바꿔서 처리
				if(page<=0) {
					page = 1;
				}
				page = (page -1)*10;
				
				return sqlSession.selectList(NAMESPACE+".listadrevPage", page);
	}

	//후기 목록
	@Override
	public List<AdReviewVO> getReviewList(PagingVO vo) throws Exception {
		
		return sqlSession.selectList(NAMESPACE+".getadReviewList", vo);
	}

	//총 후기 개수
	@Override
	public int reviewAllCount(PagingVO vo) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+".getReviewAllCount", vo);
	}
	
	//검색 결과에 맞는 후기 개수
	@Override
	public int reviewCount(PagingVO vo) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+".getReviewCount", vo);
	}

	//후기 상세 조회
	@Override
	public AdReviewVO getReviewDetail(int prod_review_code) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+".adreviewDetail", prod_review_code);
	}

	



}
