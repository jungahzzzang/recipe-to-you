package kr.co.recipetoyou.admin.adfaq;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;


import kr.co.recipetoyou.util.PagingVO;

@Service("faqService")
public class AdFAQServiceImpl implements AdFAQService {
	
	private static final Logger logger = LoggerFactory.getLogger("AdFAQServiceImpl.class");
	
	@Autowired
	private AdFAQDAO dao;
	
	//전체 FAQ목록 조회
	@Override
		public List<AdFAQVO> listFAQ(PagingVO vo) throws Exception {		
		List<AdFAQVO> FAQList = dao.FAQListPaging(vo);	
		return FAQList;
	}

	//FAQ목록 수 조회
	@Override
	public int FAQListCount(PagingVO vo) throws DataAccessException {
		return dao.FAQListCount(vo);
	}

	
	//FAQ 정보 삭제
	@Override
	public int removeFAQ(String id) throws DataAccessException {	
		return dao.deleteFAQ(id);	
	}
	
	//카테고리
	@Override
	public List<AdFAQCategoryVO> cateFAQList() throws Exception {
		logger.info("(service)cateFAQList.....");
		return dao.cateFAQList();
	}

	//상품명 검색
	@Override
	public List<AdFAQVO> listSearch(AdFAQCategoryVO option) throws Exception {	
		return dao.listFAQSearch(option);
	}
	
	//검색 결과 갯수
	@Override
	public int countFAQSearch(AdFAQCategoryVO  option) throws Exception {	
		return dao.countFAQSearch(option);
	}
	
	//상품 등록
	@Override
	public void register(AdFAQVO vo) throws Exception {	
		logger.info("(service) register........");
		dao.register(vo);
	}
}
