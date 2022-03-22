package kr.co.recipetoyou.user.login;

import java.util.List;

import org.springframework.dao.DataAccessException;

import kr.co.recipetoyou.user.UserVO;

public interface LoginDAO {

	public List<UserVO> selectAllUserList() throws DataAccessException;
	public int insertUser(UserVO userVO) throws DataAccessException;
	public int deleteUser(String id) throws DataAccessException;
	public UserVO loginById(UserVO userVO) throws DataAccessException;

}
