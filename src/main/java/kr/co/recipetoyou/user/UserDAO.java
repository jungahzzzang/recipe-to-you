package kr.co.recipetoyou.user;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.recipetoyou.util.PagingVO;

public interface UserDAO {

	
	//페이징
	public List<UserVO> listPage(int page) throws Exception;
	
	//페이징 처리하는 동작(PagingVO 객체 사용)
	public List<UserVO> listPaging(PagingVO vo) throws Exception;
		
	//회원 수 조회
	public int userCount() throws DataAccessException;
		
	//회원 상세 정보 조회
	public UserVO readUser(String id) throws DataAccessException;
		
	//회원 정보 삭제
	public int deleteUser(@RequestParam("id") String id) throws DataAccessException;
		
	///회원 정보 수정
	public void updateUser(UserVO vo) throws DataAccessException;

}
