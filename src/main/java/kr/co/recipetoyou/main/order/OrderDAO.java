package kr.co.recipetoyou.main.order;

import java.util.List;

import kr.co.recipetoyou.user.UserVO;
import kr.co.recipetoyou.user.mypage.vo.UserAddrVO;

public interface OrderDAO {

	public List<OrderVO> selectProdPrice(String cart_code);

	public void insertOrder(OrderVO ord);

	public int selectOrdCheck(OrderVO ord);

	public void updateOrder(OrderVO ord);

	public List<OrderVO> selectOrdList(String user_id);

	public UserVO selectUserInfo(String user_id);

	public UserAddrVO selectUserAddr(String user_id);

}
