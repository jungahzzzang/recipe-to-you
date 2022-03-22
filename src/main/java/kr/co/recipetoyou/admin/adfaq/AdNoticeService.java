package kr.co.recipetoyou.admin.adfaq;

import java.util.List;

import org.springframework.dao.DataAccessException;

import kr.co.recipetoyou.util.PagingVO;

public interface AdNoticeService {

	List<AdNoticeVO> listNotice(PagingVO vo) throws Exception;

	int noticeCount(PagingVO vo) throws DataAccessException;

	AdNoticeVO getNoticeInfo(String id) throws DataAccessException;

	int removeNotice(String id) throws DataAccessException;

}
