package kr.co.recipetoyou.admin.adfaq;

import java.util.List;

import org.springframework.dao.DataAccessException;

import kr.co.recipetoyou.admin.adrecipe.AdRecipeVO;
import kr.co.recipetoyou.util.PagingVO;

public interface AdNoticeDAO {

	List<AdNoticeVO> listNoticePage(int page) throws Exception;

	List<AdNoticeVO> listNoticePaging(PagingVO vo) throws Exception;

	int noticeCount(PagingVO vo) throws DataAccessException;

	int deleteNotice(String id) throws DataAccessException;

	AdNoticeVO readNotice(String id) throws DataAccessException;

}
