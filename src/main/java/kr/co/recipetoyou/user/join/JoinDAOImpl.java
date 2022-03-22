package kr.co.recipetoyou.user.join;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import kr.co.recipetoyou.user.UserVO;

@Repository("joinDAO")
public class JoinDAOImpl implements JoinDAO {
	@Autowired
	private SqlSession sqlSession;	

	@Override
	public int insertUser(UserVO userVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.user.insertUser", userVO);
		return result;
	}

	@Override
	public int idChk(UserVO userVO) throws DataAccessException {
		int result = sqlSession.selectOne("mapper.user.idChk", userVO);
		return result;
	}
	public int idChk(String user_id) throws DataAccessException {
		int result = sqlSession.selectOne("mapper.user.idChk", user_id);
		return result;
	}

	@Override
	public int mailChk(String user_email) throws DataAccessException {
		int result = sqlSession.selectOne("mapper.user.mailChk", user_email);
		return result;
	}

}
