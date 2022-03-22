package kr.co.recipetoyou.admin.adorder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;


import kr.co.recipetoyou.util.PagingVO;

@Service("adOrderService")
public class AdOrderServiceImpl implements AdOrderService {
	@Autowired
	private AdOrderDAO dao;
	

	//전체 주문 조회
	@Override
	public List<AdOrderVO> listOrdUsers(PagingVO vo) throws Exception {		
		List<AdOrderVO> ordList = dao.listOrdPaging(vo);
		return ordList;
	}

	//주문 수 조회
	@Override
	public int ordCount(PagingVO vo) throws DataAccessException {
		return dao.ordCount(vo);
	}
		
	//주문 상세 정보 조회
	@Override
	public AdOrderVO getOrdInfo(int id) throws DataAccessException {		
		return dao.readOrd(id);
	}
		
	//결제취소
	@Override
	public int removeOrd(int id) throws DataAccessException {	
		return dao.deleteOrd(id);	
	}
		
	//주문 정보 수정
//	@Override
//	public void updateOrdInfo(AdOrderVO vo) throws DataAccessException {
//		dao.updateOrdIng(vo);	
//	}
}
