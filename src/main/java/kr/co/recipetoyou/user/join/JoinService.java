package kr.co.recipetoyou.user.join;

import java.util.List;

import org.springframework.dao.DataAccessException;

import kr.co.recipetoyou.user.UserVO;

public interface JoinService {


	public int addUser(UserVO userVO) throws DataAccessException;

	public int idChk(UserVO userVO) throws Exception;

	public int idChk(String user_id) throws Exception;

	public int mailChk(String user_email);

	public void certifiedPhoneNumber(String userPhoneNumber, int randomNumber);

	
	
}
