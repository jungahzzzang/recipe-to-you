package kr.co.recipetoyou.main.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.recipetoyou.user.UserVO;
import kr.co.recipetoyou.user.mypage.vo.UserAddrVO;

@Service("orderService")
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDAO orderDAO;

	@Override
	public int addOrder(String cart_code, List<String> quantity) {

		List<OrderVO> list = orderDAO.selectProdPrice(cart_code);
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i).getPrice()+" "+list.get(i).getProd_code() +" "+Integer.parseInt(quantity.get(i))
					+" "+list.get(i).getStatus()+" "+list.get(i).getUser_id());
			OrderVO ord = new OrderVO(list.get(i).getUser_id() , list.get(i).getProd_code() , Integer.parseInt(quantity.get(i)), list.get(i).getPrice());
			
			int flag = orderDAO.selectOrdCheck(ord);
			
			if(flag != 1) {
				orderDAO.insertOrder(ord);
			}else {
				orderDAO.updateOrder(ord);
			}
		}
		return 1;
	}

	@Override
	public List<OrderVO> selectOrderList(String user_id) {
		return orderDAO.selectOrdList(user_id);
		
	}

	@Override
	public UserVO selectUserInfo(String user_id) {
		return orderDAO.selectUserInfo(user_id);
	}

	@Override
	public UserAddrVO selectUserAddrInfo(String user_id) {
		return orderDAO.selectUserAddr(user_id);
	}


}
