package kr.co.recipetoyou.main.order;

import java.util.List;

import kr.co.recipetoyou.user.UserVO;
import kr.co.recipetoyou.user.mypage.vo.UserAddrVO;

public interface OrderService {


	public int addOrder(String cart_code, List<String> quantity);

	public List<OrderVO> selectOrderList(String user_id);

	public UserVO selectUserInfo(String user_id);
	
	public UserAddrVO selectUserAddrInfo(String user_id);


}
