package kr.co.recipetoyou.admin.adorder;

import java.util.List;

import org.springframework.dao.DataAccessException;

import kr.co.recipetoyou.util.PagingVO;

public interface AdOrderService {

	List<AdOrderVO> listOrdUsers(PagingVO vo) throws Exception;

	int ordCount(PagingVO vo) throws DataAccessException;

	AdOrderVO getOrdInfo(int id) throws DataAccessException;

	int removeOrd(int id) throws DataAccessException;

}
