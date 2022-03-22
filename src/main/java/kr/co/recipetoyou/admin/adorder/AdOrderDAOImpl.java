package kr.co.recipetoyou.admin.adorder;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import kr.co.recipetoyou.util.PagingVO;

@Repository("adOrderDAO")
public class AdOrderDAOImpl implements AdOrderDAO {
	
	@Autowired 
	private SqlSession sqlSession;
	
	//페이징
	@Override
	public List<AdOrderVO> listOrdPage(int page) throws Exception {
		//페이지가 0인 경우 1로 바꿔서 처리
		if(page <= 0) {
			page = 1;
		}
		page = (page - 1)*10;
		return sqlSession.selectList("mapper.adorder.listOrdPage", page);
	}
		
	//페이징 처리하는 동작(PagingVO 객체 사용)
	@Override
	public List<AdOrderVO> listOrdPaging(PagingVO vo) throws Exception {
		System.out.println("DAO: listOrdPageVO 호출");
		return sqlSession.selectList("mapper.adorder.listOrdPaging", vo);
	}
		
	//주문 전체 수 조회
	//DB 테이블에 있는 모든 회원의 주문 수 계산 후 리턴
	@Override
	public int ordCount(PagingVO vo) throws DataAccessException {	
		return sqlSession.selectOne("mapper.adorder.ordCount", vo);
	}

	//결제 취소
	@Override
	public int deleteOrd(@RequestParam("id") int id) throws DataAccessException {	
		int result = sqlSession.delete("mapper.adorder.deleteOrd", id);
		return result;
	}
	
	//주문 상세 정보 조회
	@Override
	public AdOrderVO readOrd(int id) throws DataAccessException {
		return sqlSession.selectOne("mapper.adorder.readOrd", id);
	}
		
}
