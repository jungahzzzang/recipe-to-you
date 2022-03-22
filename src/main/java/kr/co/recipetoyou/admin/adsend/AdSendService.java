package kr.co.recipetoyou.admin.adsend;

import java.util.List;

import org.springframework.dao.DataAccessException;

import kr.co.recipetoyou.admin.adorder.AdOrderVO;
import kr.co.recipetoyou.admin.adpayment.AdPaymentVO;
import kr.co.recipetoyou.admin.aduser.AdUserVO;
import kr.co.recipetoyou.util.PagingVO;

public interface AdSendService {

	public List<AdSendVO> listSend(PagingVO vo) throws Exception;

	public int sendListCount(PagingVO vo) throws DataAccessException;

	public AdUserVO getSendUserInfo(String id) throws DataAccessException;

	public AdOrderVO getSendOrderInfo(int ord) throws DataAccessException;

	public AdPaymentVO getSendPaymentInfo(int pay) throws DataAccessException;


}
