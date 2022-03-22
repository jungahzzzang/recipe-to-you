package kr.co.recipetoyou.admin.adfaq;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;


import kr.co.recipetoyou.util.PagingVO;

@Service("adNoticeService")
public class AdNoticeServiceImpl implements AdNoticeService {

	@Autowired
	private AdNoticeDAO dao;
	
	//전체 레시피 게시글 조회
	@Override
	public List<AdNoticeVO> listNotice(PagingVO vo) throws Exception {		
		List<AdNoticeVO> noticeList = dao.listNoticePaging(vo);
		return noticeList;
	}

	//레시피 게시글 수 조회
	@Override
	public int noticeCount(PagingVO vo) throws DataAccessException {
		return dao.noticeCount(vo);
	}
		
	//레시피 게시글 상세 정보 조회
	@Override
	public AdNoticeVO getNoticeInfo(String id) throws DataAccessException {		
		return dao.readNotice(id);
	}
		
	//레시피 게시글 삭제
	@Override
	public int removeNotice(String id) throws DataAccessException {	
		return dao.deleteNotice(id);	
	}
}
