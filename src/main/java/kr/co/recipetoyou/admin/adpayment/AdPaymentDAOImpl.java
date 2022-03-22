package kr.co.recipetoyou.admin.adpayment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.recipetoyou.util.PagingVO;

@Repository("adPaymentDAO")
public class AdPaymentDAOImpl implements AdPaymentDAO {
	
	@Autowired 
	private SqlSession sqlSession;
	
	//페이징
	@Override
	public List<AdPaymentVO> listPayPage(int page) throws Exception {
		//페이지가 0인 경우 1로 바꿔서 처리
		if(page <= 0) {
			page = 1;
		}
		page = (page - 1)*10;
		return sqlSession.selectList("mapper.adpayment.listPayPage", page);
	}
		
	//페이징 처리하는 동작(PagingVO 객체 사용)
	@Override
	public List<AdPaymentVO> listPayPaging(PagingVO vo) throws Exception {
		System.out.println("DAO: listPayPageVO 호출");
		return sqlSession.selectList("mapper.adpayment.listPayPaging", vo);
	}
		
	//결제 전체 수 조회
	//DB 테이블에 있는 모든 회원의 주문 수 계산 후 리턴
	@Override
	public int payCount(PagingVO vo) throws DataAccessException {	
		return sqlSession.selectOne("mapper.adpayment.payCount", vo);
	}

	//결제 취소
	@Override
	public int deletePay(@RequestParam("id") int id) throws DataAccessException {	
		int result = sqlSession.delete("mapper.adpayment.deletePay", id);
		return result;
	}
	
	//주문 상세 정보 조회
	@Override
	public AdPaymentVO readPay(int id) throws DataAccessException {
		return sqlSession.selectOne("mapper.adpayment.readPay", id);
	}
}
