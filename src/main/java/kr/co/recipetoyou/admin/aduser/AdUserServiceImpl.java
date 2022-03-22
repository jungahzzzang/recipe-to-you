package kr.co.recipetoyou.admin.aduser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import kr.co.recipetoyou.util.PagingVO;

@Service("aduserService")
public class AdUserServiceImpl implements AdUserService{

	@Autowired
	private AdUserDAO aduserDAO;
	

	//전체 회원 조회
	@Override
	public List<AdUserVO> listUsers(PagingVO vo) throws Exception {		
		List<AdUserVO> userList = aduserDAO.listPaging(vo);
		return userList;
	}

	//회원 수 조회
	@Override
	public int userCount(PagingVO vo) throws DataAccessException {
		return aduserDAO.userCount(vo);
	}
		
	//회원 상세 정보 조회
	@Override
	public AdUserVO getUserInfo(String id) throws DataAccessException {		
		return aduserDAO.readUser(id);
	}
		
	//회원 정보 삭제
	@Override
	public int removeUsers(String id) throws DataAccessException {	
		return aduserDAO.deleteUser(id);	
	}
		
	//회원 정보 수정
	@Override
	public void updateUserInfo(AdUserVO vo) throws DataAccessException {
		aduserDAO.updateUser(vo);	
	}
}
