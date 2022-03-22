package kr.co.recipetoyou.board.notice;

import java.util.List;
import java.util.Map;

import kr.co.recipetoyou.util.PagingVO;

public interface NoticeService {

	public int noticeCount(PagingVO vo);

	public List<NoticeVO> noticeList(PagingVO vo);

	public NoticeVO getNoticeDetail(int notice_idx);

	public int noticeFrequencyCount(PagingVO vo);

	public List<NoticeVO> noticeFrequencyList(PagingVO vo);

	public int noticeOneToOneCount(PagingVO vo);

	public List<NoticeINQVO> noticeOneToOneist(PagingVO vo);

	public void addOnoToOneINQ(NoticeINQVO noticeINQ);


}
