package kr.co.recipetoyou.main.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.recipetoyou.user.UserVO;
import kr.co.recipetoyou.user.mypage.vo.UserAddrVO;

@Controller("orderController")
public class OrderControllerImpl implements OrderController{
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderVO orderVO;
	
	@Override
	@ResponseBody
	@RequestMapping(value="/order/orderRegist.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String orderReg(
		 @RequestParam(value="cart_code[]", required=false) List<String> cart_code, 
		 @RequestParam(value="quantity[]", required=false)  List<String> quantity,
		  HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		
		System.out.println("order.do================================================start");
		if(cart_code != null) {
			for(int i=0;i<cart_code.size();i++) {
				int price = orderService.addOrder(cart_code.get(i),quantity);
				
				orderVO.setPrice(i);
			}
		}
		ModelAndView mav = new ModelAndView();
		return "성공";
	}
	
	@Override
	@RequestMapping(value="/order/order.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView order(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("userVO");
		if(userVO != null) {
			String user_id = userVO.getUser_id();
			
			List<OrderVO> orderList = orderService.selectOrderList(user_id);
		    UserVO user = orderService.selectUserInfo(user_id);
		    UserAddrVO userAddr = orderService.selectUserAddrInfo(user_id);
		    
		    mav.addObject("orderList",orderList);
			mav.addObject("user", user);
			mav.addObject("userAddr", userAddr);
			return mav;
		}else {
			
			return mav;
		}
		
	}


	
	

}
