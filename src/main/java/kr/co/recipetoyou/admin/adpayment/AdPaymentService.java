package kr.co.recipetoyou.admin.adpayment;

import java.util.List;

import org.springframework.dao.DataAccessException;

import kr.co.recipetoyou.util.PagingVO;

public interface AdPaymentService {

	List<AdPaymentVO> listPayUsers(PagingVO vo) throws Exception;

	int payCount(PagingVO vo) throws DataAccessException;

	AdPaymentVO getPayInfo(int id) throws DataAccessException;

	int removePay(int id) throws DataAccessException;

}
