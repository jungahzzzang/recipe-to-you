package kr.co.recipetoyou.admin;

import java.util.List;


import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.recipetoyou.user.UserVO;

public interface AdminService {

	//관리자 로그인
	public AdminVO login(AdminVO adminVO) throws DataAccessException;
	
	//관리자 목록 조회
	public List<AdminVO> listAdmin() throws DataAccessException;
	

}
