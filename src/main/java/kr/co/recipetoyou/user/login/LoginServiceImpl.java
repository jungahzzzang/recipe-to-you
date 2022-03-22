package kr.co.recipetoyou.user.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.co.recipetoyou.user.UserVO;


@Service("loginService")
@Transactional(propagation = Propagation.REQUIRED)
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDAO loginDAO;

	@Override
	public List<UserVO> listUsers() throws DataAccessException {
		List<UserVO> usersList = loginDAO.selectAllUserList();
		return usersList;
	}

	@Override
	public int addUser(UserVO userVO) throws DataAccessException {
		return loginDAO.insertUser(userVO);
	}

	@Override
	public int removeUser(String id) throws DataAccessException {
		return loginDAO.deleteUser(id);
	}

	@Override
	public UserVO login(UserVO userVO) throws DataAccessException {
		return loginDAO.loginById(userVO);
	}

}
