package kr.co.recipetoyou.main.cartPick;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.recipetoyou.main.cartPick.vo.CartAddVO;
import kr.co.recipetoyou.main.cartPick.vo.FavVO;
import kr.co.recipetoyou.main.cartPick.vo.PickVO;
import kr.co.recipetoyou.main.cartPick.vo.ProdVO;
import kr.co.recipetoyou.user.mypage.vo.UserAddrVO;

public interface CartPickService {

	//찜 목록 조회
	public List<PickVO> listPicks (String user_id) throws DataAccessException;
	//찜 목록 삭제
	public int removePick(@RequestParam("prod_name")String prod_name) throws DataAccessException;
	//마이페이지 장바구니에 담기 
	public void insertCart(CartAddVO cartAddVO) throws DataAccessException;
	//장바구니 수정
	public void modifyCart(CartAddVO cartAddVO) throws Exception;
	//장바구니 총합
	public int sumMoney(String user_id) throws DataAccessException;
	//동일 상품 확인
	public int commCart(String user_id,int prod_code) throws DataAccessException;
	//수량 수정
	public void updateCart(CartAddVO cartAddVO) throws DataAccessException;
	
	//마이페이지 장바구니 조회
	public List<ProdVO> listCarts(String user_id) throws Exception;
	
	//마이페이지 장바구니 조회 삭제
	public int removeCart(String prod_name) throws DataAccessException;

	//cartPick.xml
	public UserAddrVO getAddr(String user_id);

}

