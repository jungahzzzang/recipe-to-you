package kr.co.recipetoyou.main.order;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.recipetoyou.user.UserVO;
import kr.co.recipetoyou.user.mypage.vo.UserAddrVO;

@Repository("orderDAO")
public class OrderDAOImpl implements OrderDAO{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<OrderVO> selectProdPrice(String cart_code) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.member.selectProdPrice",cart_code);
	}

	@Override
	public void insertOrder(OrderVO ord) {
		sqlSession.insert("mapper.member.insertOrder", ord);
		
	}

	@Override
	public int selectOrdCheck(OrderVO ord) {
		return sqlSession.selectOne("mapper.member.selectOrdCheck",ord);
	}

	@Override
	public void updateOrder(OrderVO ord) {
		sqlSession.update("mapper.member.updateOrder", ord);
	}

	@Override
	public List<OrderVO> selectOrdList(String user_id) {
		return sqlSession.selectList("mapper.member.selectOrdList",user_id);
	}

	@Override
	public UserVO selectUserInfo(String user_id) {
		return sqlSession.selectOne("mapper.member.selectUserInfo",user_id);
	}

	@Override
	public UserAddrVO selectUserAddr(String user_id) {
		return sqlSession.selectOne("mapper.member.selectUserAddr",user_id);
	}

}
