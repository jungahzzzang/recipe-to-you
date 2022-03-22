package kr.co.recipetoyou.admin.aduser;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.recipetoyou.util.PagingVO;

@Repository("aduserDAO")
public class AdUserDAOImpl implements AdUserDAO {
	
	@Autowired
	private SqlSession sqlSession;	//DB 연결 (XML에서 만들어진 객체를 가져다 사용하겠다. = 의존 주입)
	
	private static final String NAMESPACE = "mapper.aduser"; 	//mapper 구분하는 값 namespace
	
	//페이징
	@Override
	public List<AdUserVO> listPage(int page) throws Exception {
		//페이지가 0인 경우 1로 바꿔서 처리
		if(page <= 0) {
			page = 1;
		}
		page = (page - 1)*10;
		return sqlSession.selectList(NAMESPACE+".listPage", page);
	}
	
	//페이징 처리하는 동작(PagingVO 객체 사용)
	@Override
	public List<AdUserVO> listPaging(PagingVO vo) throws Exception {
		System.out.println("DAO: listPageVO 호출");
		return sqlSession.selectList(NAMESPACE+".listPaging", vo);
	}
	
	//회원 수 조회
	//DB 테이블에 있는 모든 회원수 계산 후 리턴
	@Override
	public int userCount(PagingVO vo) throws DataAccessException {	
		return sqlSession.selectOne(NAMESPACE+".userCount",vo);
	}
		
	//회원 정보 삭제
	@Override
	public int deleteUser(@RequestParam("id") String id) throws DataAccessException {	
		int result = sqlSession.delete(NAMESPACE+".deleteUser", id);
		return result;
	}
	
	//회원 상세 정보 조회
	@Override
	public AdUserVO readUser(String id) throws DataAccessException {
		return sqlSession.selectOne(NAMESPACE+".readUser", id);
	}
		
	//회원 정보 수정
	@Override
	public void updateUser(AdUserVO vo) throws DataAccessException {
		System.out.println("dao 사용자 생년월일:"+vo.getUser_birth());
		sqlSession.update(NAMESPACE+".updateUser", vo);
	} 

}
