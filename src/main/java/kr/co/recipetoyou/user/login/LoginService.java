package kr.co.recipetoyou.user.login;

import java.util.List;

import org.springframework.dao.DataAccessException;

import kr.co.recipetoyou.user.UserVO;

public interface LoginService {

	public List<UserVO> listUsers() throws DataAccessException;
	public int addUser(UserVO userVO) throws DataAccessException;
	public int removeUser(String id) throws DataAccessException;
	public UserVO login(UserVO userVO) throws DataAccessException;
}