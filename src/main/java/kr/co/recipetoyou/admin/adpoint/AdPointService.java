package kr.co.recipetoyou.admin.adpoint;

import java.util.List;

import kr.co.recipetoyou.util.PagingVO;

public interface AdPointService {

	public List<AdPointVO> listPoint() throws Exception;
	//List<AdPointVO> listPoint(PagingVO vo) throws Exception;

}
