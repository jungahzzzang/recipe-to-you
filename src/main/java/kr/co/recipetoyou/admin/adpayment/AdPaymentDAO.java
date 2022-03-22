package kr.co.recipetoyou.admin.adpayment;

import java.util.List;

import org.springframework.dao.DataAccessException;

import kr.co.recipetoyou.util.PagingVO;

public interface AdPaymentDAO {

	List<AdPaymentVO> listPayPage(int page) throws Exception;

	List<AdPaymentVO> listPayPaging(PagingVO vo) throws Exception;

	int payCount(PagingVO vo) throws DataAccessException;

	int deletePay(int id) throws DataAccessException;

	AdPaymentVO readPay(int id) throws DataAccessException;

}
