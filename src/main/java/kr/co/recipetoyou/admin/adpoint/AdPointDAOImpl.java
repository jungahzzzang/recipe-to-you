package kr.co.recipetoyou.admin.adpoint;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.recipetoyou.admin.adorder.AdOrderVO;
import kr.co.recipetoyou.util.PagingVO;

@Repository("adPointDAO")
public class AdPointDAOImpl implements AdPointDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<AdPointVO> selectAllPointList() throws Exception {
		List<AdPointVO> pointList = sqlSession.selectList("mapper.adpoint.selectAllPointList");
		return pointList;
	}

	@Override
	public List<AdPointVO> listPointPage(int page) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdPointVO> listPointPaging(PagingVO vo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
/*	
	//페이징
		@Override
		public List<AdPointVO> listPointPage(int page) throws Exception {
			//페이지가 0인 경우 1로 바꿔서 처리
			if(page <= 0) {
				page = 1;
			}
			page = (page - 1)*10;
			return sqlSession.selectList("mapper.adpoint.listPointPage", page);
		}
			
		//페이징 처리하는 동작(PagingVO 객체 사용)
		@Override
		public List<AdPointVO> listPointPaging(PagingVO vo) throws Exception {
			System.out.println("DAO: listPointPageVO 호출");
			return sqlSession.selectList("mapper.adpoint.listPointPaging", vo);
		}
*/
}
