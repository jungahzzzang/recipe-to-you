package kr.co.recipetoyou.admin.aduser.aduserWithdraw;

import java.util.List;

import org.springframework.dao.DataAccessException;

import kr.co.recipetoyou.admin.aduser.aduserWithdraw.AdUserDrawVO;
import kr.co.recipetoyou.util.PagingVO;

public interface AdUserDrawDAO {
	
	//===================================================================================
		//탈퇴 회원 목록 페이징
		public List<AdUserDrawVO> listPageWithdraw(int page) throws Exception;
		
		//탈퇴 회원 목록 처리하는 동작(PagingVO 객체 사용)
		public List<AdUserDrawVO> listPagingWithdraw(PagingVO vo) throws Exception;
		
		//탈퇴 회원 목록 회원 수 조회
		public int userWithdrawCount(PagingVO vo) throws DataAccessException;
		
		//탈퇴 회원 상세 정보 조회
		public AdUserDrawVO readUserWithdraw(String id) throws DataAccessException;

		//탈퇴 회원 정보 삭제
		public int deleteUserWithdraw(String id) throws DataAccessException;

}
