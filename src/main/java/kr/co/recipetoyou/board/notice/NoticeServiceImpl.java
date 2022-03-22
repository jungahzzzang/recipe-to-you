package kr.co.recipetoyou.board.notice;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.recipetoyou.util.PagingVO;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private NoticeDAO noticeDAO;

	@Override
	public int noticeCount(PagingVO vo) {
		return noticeDAO.selectNoticeCount(vo);
	}

	@Override
	public List<NoticeVO> noticeList(PagingVO vo) {
		return noticeDAO.selectNoticeList(vo);
	}

	@Override
	public NoticeVO getNoticeDetail(int notice_idx) {
		return noticeDAO.selectNoticeDetail(notice_idx);
	}

	@Override
	public int noticeFrequencyCount(PagingVO vo) {
		return noticeDAO.selectNoticeFrequencyCount(vo);
	}

	@Override
	public List<NoticeVO> noticeFrequencyList(PagingVO vo) {
		return noticeDAO.selectNoticeFrequencyList(vo);
	}

	@Override
	public int noticeOneToOneCount(PagingVO vo) {
		return noticeDAO.selectOneToOneCount(vo);
	}

	@Override
	public List<NoticeINQVO> noticeOneToOneist(PagingVO vo) {
		return noticeDAO.selectOneToOneList(vo);
	}

	@Override
	public void addOnoToOneINQ(NoticeINQVO noticeINQ) {
		noticeDAO.insertINQ(noticeINQ);
		
	}


}
