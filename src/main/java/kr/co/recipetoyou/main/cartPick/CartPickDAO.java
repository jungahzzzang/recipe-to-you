package kr.co.recipetoyou.main.cartPick;

import java.util.List; 

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.recipetoyou.main.cartPick.vo.CartAddVO;
import kr.co.recipetoyou.main.cartPick.vo.FavVO;
import kr.co.recipetoyou.main.cartPick.vo.PickVO;
import kr.co.recipetoyou.main.cartPick.vo.ProdVO;
import kr.co.recipetoyou.user.mypage.vo.UserAddrVO;

public interface CartPickDAO{
	//조회
	public List<PickVO> selectAllCartPickList(String user_id) throws DataAccessException;
	//삭제
	public int deletePick(@RequestParam("prod_name")String prod_name) throws DataAccessException;
	
	//장바구니에 담기, 추가
	public void insertCart (CartAddVO cartAddVO) throws DataAccessException;
	
	//장바구니 수정
	public void modifyCart(CartAddVO cartAddVO) throws Exception;
	
	//장바구니 금액 합계
	public int sumMoney(String user_id) throws DataAccessException;
	
	//장바구니 동일한 상품 점검
	public int selectCart (String user_id) throws DataAccessException;
	
	//장바구니 상품수량 수정
	public void updateCount(CartAddVO cartAddVO) throws DataAccessException;
	
	//장바구니 목록 조회
	public List<ProdVO> selectAllCartList(String user_id) throws DataAccessException;
	
	//장바구니 목록 삭제
	public int deleteCart(String prod_name) throws DataAccessException;
	
	//CartPick.xml
	public int selectCheckCartProd(int prod_code);
	public UserAddrVO selectAddr(String user_id);

	
}
