package kr.co.recipetoyou.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import kr.co.recipetoyou.util.PagingVO;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;

	//전체 회원 조회
	@Override
	public List<UserVO> listUsers(PagingVO vo) throws Exception {
			
		List<UserVO> userList = userDAO.listPaging(vo);
			
		return userList;
	}

	//회원 수 조회
	@Override
	public int userCount() throws DataAccessException {
			
		return userDAO.userCount();
	}
		
	//회원 상세 정보 조회
	@Override
	public UserVO getUserInfo(String id) throws DataAccessException {
				
		return userDAO.readUser(id);
	}
		
	//회원 정보 삭제
	@Override
	public int removeUsers(String id) throws DataAccessException {
			
		return userDAO.deleteUser(id);
			
	}
		
	//회원 정보 수정
	@Override
	public void updateUserInfo(UserVO vo) throws DataAccessException {
		
		userDAO.updateUser(vo);
			
	}
	 
	
	

}
