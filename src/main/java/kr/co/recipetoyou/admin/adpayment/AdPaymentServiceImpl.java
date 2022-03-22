package kr.co.recipetoyou.admin.adpayment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import kr.co.recipetoyou.util.PagingVO;

@Service("adPaymentService")
public class AdPaymentServiceImpl implements AdPaymentService {
	@Autowired
	private AdPaymentDAO dao;
	

	//전체 주문 조회
	@Override
	public List<AdPaymentVO> listPayUsers(PagingVO vo) throws Exception {		
		List<AdPaymentVO> payList = dao.listPayPaging(vo);
		return payList;
	}

	//주문 수 조회
	@Override
	public int payCount(PagingVO vo) throws DataAccessException {
		return dao.payCount(vo);
	}
		
	//주문 상세 정보 조회
	@Override
	public AdPaymentVO getPayInfo(int id) throws DataAccessException {		
		return dao.readPay(id);
	}
		
	//결제취소
	@Override
	public int removePay(int id) throws DataAccessException {	
		return dao.deletePay(id);	
	}
		
}
