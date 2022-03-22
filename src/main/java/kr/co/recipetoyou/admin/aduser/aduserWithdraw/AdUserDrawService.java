package kr.co.recipetoyou.admin.aduser.aduserWithdraw;

import java.util.List;

import org.springframework.dao.DataAccessException;

import kr.co.recipetoyou.admin.aduser.aduserWithdraw.AdUserDrawVO;
import kr.co.recipetoyou.util.PagingVO;

public interface AdUserDrawService {
	
	//=============================================================================
		//탈퇴 회원 정보 조회 
		public List<AdUserDrawVO> listUsersWithdraw(PagingVO vo) throws Exception;

		//탈퇴 회원 정보 회원 수 조회
		public int userWithdrawCount(PagingVO vo) throws DataAccessException;
		
		//탈퇴 회원 정보 상세 조회 
		public AdUserDrawVO getUserWithdraw(String id) throws DataAccessException;

		//탈퇴 회원 정보 삭제
		public int removeUsersWithdraw(String id) throws DataAccessException;

}
