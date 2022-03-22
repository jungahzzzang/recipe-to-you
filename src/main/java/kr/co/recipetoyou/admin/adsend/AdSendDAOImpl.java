package kr.co.recipetoyou.admin.adsend;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import kr.co.recipetoyou.admin.adorder.AdOrderVO;
import kr.co.recipetoyou.admin.adpayment.AdPaymentVO;
import kr.co.recipetoyou.admin.aduser.AdUserVO;
import kr.co.recipetoyou.util.PagingVO;

@Repository("sendDAO")		
public class AdSendDAOImpl implements AdSendDAO {

	@Autowired
	private SqlSession sqlSession;
	
	//페이징
	@Override
	public List<AdSendVO> sendListPage(int page) throws Exception {
		//페이지가 0인 경우 1로 바꿔서 처리
		if(page <= 0) {
			page = 1;
		}
		page = (page - 1)*10;
		return sqlSession.selectList("mapper.adsend.sendListPage", page);
	}
	
	//페이징 처리하는 동작(PagingVO 객체 사용)
	@Override
	public List<AdSendVO> sendListPaging(PagingVO vo) throws Exception {
		System.out.println("DAO: listPageVO 호출");
		return sqlSession.selectList("mapper.adsend.sendListPaging", vo);
	}
	
	//회원 수 조회
	//DB 테이블에 있는 모든 회원수 계산 후 리턴
	@Override
	public int sendListCount(PagingVO vo) throws DataAccessException {	
		return sqlSession.selectOne("mapper.adsend.sendListCount", vo);
	}	
	
	//회원 상세 정보 조회
	@Override
	public AdUserVO readUserSend(String id) throws DataAccessException {
		return sqlSession.selectOne("mapper.adsend.readUserSend", id);
	}	
	
	//주문 내역 목록 조회
	@Override
	public AdOrderVO readOrderSend(int ord) throws DataAccessException {
		return null;//sqlSession.selectOne("mapper.adsend.readOrderSend", ord);
	}
	
	//결제 내역 목록 조회
	@Override
	public AdPaymentVO readPaymentSend(int pay) throws DataAccessException {
		return sqlSession.selectOne("mapper.adsend.readPaymentSend", pay);
	}

}