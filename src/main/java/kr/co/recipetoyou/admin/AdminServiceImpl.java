package kr.co.recipetoyou.admin;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.recipetoyou.user.UserVO;

@Service("adminService")
@Transactional(propagation =  Propagation.REQUIRED)
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDAO adminDAO;
	
	//관리자 조회
	@Override
	public List<AdminVO> listAdmin() throws DataAccessException {
		List<AdminVO> adminList = adminDAO.selectAllAdminList();
		return adminList;
	}

	//관리자 로그인
	@Override
	public AdminVO login(AdminVO adminVO) throws DataAccessException {
		return adminDAO.loginById(adminVO);
	}

}
