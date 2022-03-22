package kr.co.recipetoyou.admin.adpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.recipetoyou.admin.adorder.AdOrderVO;
import kr.co.recipetoyou.admin.adsend.AdSendVO;
import kr.co.recipetoyou.util.PagingVO;

@Service("adPointService")
public class AdPointServiceImpl implements AdPointService {
	
	@Autowired
	private AdPointDAO adPointDAO;
	/*
	 public List<AdPointVO> listPoint() throws Exception { 
	 List<AdPointVO> pointList = adPointDAO.selectAllPointList(); 
	 return pointList; 
	 }
	
	
	//전체 적립금 조회
	@Override
	public List<AdPointVO> listPoint(PagingVO vo) throws Exception {		
		List<AdPointVO> pointList = adPointDAO.listPointPaging(vo);
		return pointList;
	}
	 */
	
	public List<AdPointVO> listPoint() throws Exception {
		List<AdPointVO> pointList = adPointDAO.selectAllPointList();
		return pointList;
	}
	
	
}
