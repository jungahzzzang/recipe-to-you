package kr.co.recipetoyou.admin.aduser;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.recipetoyou.util.PagingVO;

public interface AdUserService {

	//전체 회원 조회
	public List<AdUserVO> listUsers(PagingVO vo) throws Exception;
			
	//회원 수 조회
	public int userCount(PagingVO vo) throws DataAccessException;
			
	//회원 상세 정보 조회
	public AdUserVO getUserInfo(String id) throws DataAccessException;
			
	//회원 정보 삭제
	public int removeUsers(@RequestParam("id") String id)throws DataAccessException;
			
	//회원 정보 수정
	public void updateUserInfo(AdUserVO vo) throws DataAccessException;
}
