package kr.co.recipetoyou.admin;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.recipetoyou.user.UserVO;

@Repository("adminDAO")
public class AdminDAOImpl implements AdminDAO{

	@Autowired
	private SqlSession sqlSession;		//DB 연결 (XML에서 만들어진 객체를 가져다 사용하겠다. = 의존 주입)
	
	private static final String NAMESPACE = "mapper.admin";		//mapper 구분하는 값 namespace
	
	//관리자 목록 조회
	@Override
	public List<AdminVO> selectAllAdminList() throws DataAccessException {
		List<AdminVO> adminList = sqlSession.selectList(NAMESPACE+".selectAllAdminList");
		return adminList;
	}
	
	//관리자 로그인
	@Override
	public AdminVO loginById(AdminVO adminVO) throws DataAccessException {
		AdminVO vo = sqlSession.selectOne(NAMESPACE+".loginById", adminVO);
		return vo;
	}

}
