package kr.co.recipetoyou.admin.adsend;

import java.util.List;

import org.springframework.dao.DataAccessException;

import kr.co.recipetoyou.admin.adorder.AdOrderVO;
import kr.co.recipetoyou.admin.adpayment.AdPaymentVO;
import kr.co.recipetoyou.admin.aduser.AdUserVO;
import kr.co.recipetoyou.util.PagingVO;

public interface AdSendDAO {

	public List<AdSendVO> sendListPage(int page) throws Exception;
	
	public List<AdSendVO> sendListPaging(PagingVO vo) throws Exception;

	public int sendListCount(PagingVO vo) throws DataAccessException;

	public AdUserVO readUserSend(String id) throws DataAccessException;

	public AdOrderVO readOrderSend(int ord) throws DataAccessException;

	public AdPaymentVO readPaymentSend(int pay) throws DataAccessException;


}

