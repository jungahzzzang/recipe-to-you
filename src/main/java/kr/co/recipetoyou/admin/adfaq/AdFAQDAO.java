package kr.co.recipetoyou.admin.adfaq;

import java.util.List;

import org.springframework.dao.DataAccessException;

import kr.co.recipetoyou.admin.adgoods.category.AdGoodsCateVO;
import kr.co.recipetoyou.util.PagingVO;

public interface AdFAQDAO {

	public List<AdFAQVO> FAQListPage(int page) throws Exception;

	public List<AdFAQVO> FAQListPaging(PagingVO vo) throws Exception;

	public int FAQListCount(PagingVO vo);

	public int deleteFAQ(String id) throws DataAccessException;

	public List<AdFAQCategoryVO> cateFAQList() throws DataAccessException;

	public List<AdFAQVO> listFAQSearch(AdFAQCategoryVO option) throws Exception ;

	public void register(AdFAQVO vo) throws Exception ;

	public int countFAQSearch(AdFAQCategoryVO option) throws Exception ;

}
