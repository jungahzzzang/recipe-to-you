package kr.co.recipetoyou.admin.adsend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import kr.co.recipetoyou.admin.adorder.AdOrderVO;
import kr.co.recipetoyou.admin.adpayment.AdPaymentVO;
import kr.co.recipetoyou.admin.aduser.AdUserVO;
import kr.co.recipetoyou.util.PagingVO;

@Service("sendService")
public class AdSendServiceImpl implements AdSendService {

	@Autowired
	private AdSendDAO sendDAO;
	
	//전체 발송내역 조회
	@Override
	public List<AdSendVO> listSend(PagingVO vo) throws Exception {		
		List<AdSendVO> sendList = sendDAO.sendListPaging(vo);	
		return sendList;
	}

	//발송내역 수 조회
	@Override
	public int sendListCount(PagingVO vo) throws DataAccessException {
		return sendDAO.sendListCount(vo);
	}
		
	//회원 상세 정보 조회
	@Override
	public AdUserVO getSendUserInfo(String id) throws DataAccessException {		
		return sendDAO.readUserSend(id);
	}	
	
	//주문 내역 목록 조회
	@Override
	public AdOrderVO getSendOrderInfo(int ord) throws DataAccessException {		
		return sendDAO.readOrderSend(ord);
	}
	
	//결제 내역 목록 조회
	@Override
	public AdPaymentVO getSendPaymentInfo(int pay) throws DataAccessException {		
		return sendDAO.readPaymentSend(pay);
	}
	
}

