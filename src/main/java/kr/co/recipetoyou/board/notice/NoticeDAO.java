package kr.co.recipetoyou.board.notice;

import java.util.List;
import java.util.Map;

import kr.co.recipetoyou.util.PagingVO;

public interface NoticeDAO {

	public int selectNoticeCount(PagingVO vo);

	public List<NoticeVO> selectNoticeList(PagingVO vo);

	public NoticeVO selectNoticeDetail(int notice_idx);

	public int selectNoticeFrequencyCount(PagingVO vo);

	public List<NoticeVO> selectNoticeFrequencyList(PagingVO vo);

	public int selectOneToOneCount(PagingVO vo);

	public List<NoticeINQVO> selectOneToOneList(PagingVO vo);

	public void insertINQ(NoticeINQVO noticeINQ);


}
