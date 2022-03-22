package kr.co.recipetoyou.admin.aduser.aduserWithdraw;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import kr.co.recipetoyou.admin.aduser.aduserWithdraw.AdUserDrawDAO;
import kr.co.recipetoyou.admin.aduser.aduserWithdraw.AdUserDrawVO;
import kr.co.recipetoyou.util.PagingVO;

@Service("aduserDrawService")
public class AdUserDrawServiceImpl implements AdUserDrawService{
	
	@Autowired
	private AdUserDrawDAO adUserDrawDAO;

//======================================================================
	//탈퇴 회원 정보 조회
	@Override
	public List<AdUserDrawVO> listUsersWithdraw(PagingVO vo) throws Exception {		
		List<AdUserDrawVO> userWithdrawList = adUserDrawDAO.listPagingWithdraw(vo);	
		return userWithdrawList;
	}

	//탈퇴 회원 정보 회원 수 조회
	@Override
	public int userWithdrawCount(PagingVO vo) throws DataAccessException {
		return adUserDrawDAO.userWithdrawCount(vo);
	}	 
	
	//회원 상세 정보 조회
	@Override
	public AdUserDrawVO getUserWithdraw(String id) throws DataAccessException {		
		return adUserDrawDAO.readUserWithdraw(id);
	}

	//회원 정보 삭제
	@Override
	public int removeUsersWithdraw(String id) throws DataAccessException {	
		return adUserDrawDAO.deleteUserWithdraw(id);	
	}

}
