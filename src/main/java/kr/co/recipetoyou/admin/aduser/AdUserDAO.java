package kr.co.recipetoyou.admin.aduser;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.recipetoyou.util.PagingVO;

public interface AdUserDAO {
	
	//전체 회원 조회
		//public List<UserVO> selectAllUserList() throws DataAccessException;
		
		//페이징
		public List<AdUserVO> listPage(int page) throws Exception;
		
		//페이징 처리하는 동작(PagingVO 객체 사용)
		public List<AdUserVO> listPaging(PagingVO vo) throws Exception;
			
		//회원 수 조회
		public int userCount(PagingVO vo) throws DataAccessException;
			
		//회원 상세 정보 조회
		public AdUserVO readUser(String id) throws DataAccessException;
			
		//회원 정보 삭제
		public int deleteUser(@RequestParam("id") String id) throws DataAccessException;
			
		///회원 정보 수정
		public void updateUser(AdUserVO vo) throws DataAccessException;

}
