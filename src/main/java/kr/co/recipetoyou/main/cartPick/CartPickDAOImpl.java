package kr.co.recipetoyou.main.cartPick;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import org.springframework.web.bind.annotation.RequestParam;

import kr.co.recipetoyou.main.cartPick.vo.CartAddVO;
import kr.co.recipetoyou.main.cartPick.vo.FavVO;
import kr.co.recipetoyou.main.cartPick.vo.PickVO;
import kr.co.recipetoyou.main.cartPick.vo.ProdVO;
import kr.co.recipetoyou.user.mypage.vo.UserAddrVO;


@Repository("cartPickDAO")
public class CartPickDAOImpl implements CartPickDAO {

	@Autowired
	private SqlSession sqlSession;

	//찜하기 조회
	@Override
	public List<PickVO> selectAllCartPickList(String user_id) throws DataAccessException {
		
		List<PickVO> pickList = sqlSession.selectList("mapper.member.selectAllCartPickList",user_id);
		return pickList;
	}
	
	//찜목록 상품 삭제
	@Override
	public int deletePick(@RequestParam("prod_name") String prod_name) throws DataAccessException {
		int result = sqlSession.delete("mapper.member.deletePick", prod_name);
		System.out.println("dao 호출"+prod_name);
		return result;
	}


	//마이페이지에서 찜하기 담기 클릭 시 1.장바구니 담기
	@Override
	public void insertCart(CartAddVO cartAddVO) throws DataAccessException {
		System.out.println("insertCart DAO 호출");
		sqlSession.insert("mapper.member.insertCart", cartAddVO);	
	}
	
	//마이페이지 2. 장바구니 조회
	@Override
	public List<ProdVO> selectAllCartList(String user_id) throws DataAccessException {
		System.out.println("listCarts DAO 호출");
		return sqlSession.selectList("mapper.member.selectAllCartList", user_id);
	}

	
	//마이페이지 3.장바구니 조회 삭제	
	@Override
	public int deleteCart(String prod_name) throws DataAccessException {
		int result = sqlSession.delete("mapper.member.deleteCart", prod_name);
		System.out.println("dao 호출"+prod_name);
		return result;
	}
	
	
	//4. 장바구니 수정
	@Override
	public void modifyCart(CartAddVO cartAddVO) throws Exception {
		sqlSession.update("mapper.member.modifyCart", cartAddVO);
			
	}
	
	//5. 장바구니 총합
	@Override
	public int sumMoney(String user_id) throws DataAccessException {
		sqlSession.selectOne("mapper.member.sumMoney","user_id");
		return sqlSession.selectOne("mapper.member.sumMoney", "user_id");
	}
	
	//6. 장바구니 동일한 상품 레코드 확인
	@Override
	public int selectCart(String user_id) throws DataAccessException {
		return sqlSession.selectOne("mapper.cartPick.selectCart", user_id);
		
	}
	
	//7. 장바구니 수량 변경
	@Override
	public void updateCount(CartAddVO cartAddVO) throws DataAccessException {
		System.out.println("CARTADD:"+cartAddVO.toString());
		sqlSession.update("mapper.member.updateCart", cartAddVO);
			
	}
	
	//cartPick.xml
	@Override
	public int selectCheckCartProd(int prod_code) {
		return sqlSession.selectOne("mapper.cartPick.selectCheckCartProd", prod_code);
	}
	//cartPick.xml
	@Override
	public UserAddrVO selectAddr(String user_id) {
		return sqlSession.selectOne("mapper.cartPick.selectAddr",user_id);
	}
	  
	 
	

}
