package kr.co.recipetoyou.user.login;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import kr.co.recipetoyou.user.UserVO;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<UserVO> selectAllUserList() throws DataAccessException {
		List<UserVO> usersList = sqlSession.selectList("mapper.user.selectAllUserList");
		return usersList;
	}

	@Override
	public int insertUser(UserVO userVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.user.insertUser", userVO);
		return result;
	}

	@Override
	public int deleteUser(String id) throws DataAccessException {
		int result = sqlSession.delete("mapper.user.deleteUser", id);
		return result;
	}

	@Override
	public UserVO loginById(UserVO userVO) throws DataAccessException {
		UserVO vo = sqlSession.selectOne("mapper.user.loginById", userVO);
		return vo;
	}


}
