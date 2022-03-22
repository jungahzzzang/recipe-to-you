package kr.co.recipetoyou.admin.adpoint;

import java.util.List;

import kr.co.recipetoyou.util.PagingVO;

public interface AdPointDAO {
	
	public List<AdPointVO> selectAllPointList() throws Exception;

	public List<AdPointVO> listPointPage(int page) throws Exception;

	public List<AdPointVO> listPointPaging(PagingVO vo) throws Exception;

}
