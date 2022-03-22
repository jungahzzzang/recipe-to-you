package kr.co.recipetoyou.main.cartPick;

import java.util.HashMap; 
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import kr.co.recipetoyou.main.cartPick.vo.CartAddVO;
import kr.co.recipetoyou.main.cartPick.vo.FavVO;
import kr.co.recipetoyou.main.cartPick.vo.PickVO;
import kr.co.recipetoyou.main.cartPick.vo.ProdVO;
import kr.co.recipetoyou.user.UserVO;
import kr.co.recipetoyou.user.mypage.vo.UserAddrVO;


@Controller("cartpickController")
public class CartPickControllerImpl implements CartPickController {
	private static final Logger logger = LoggerFactory.getLogger("CartPickControllerImpl.class");

	@Autowired
	private CartPickService cartPickService;

	@Autowired
	private PickVO pickVO;

	@Autowired 
	private CartAddVO cartAddVO;

	@Autowired 
	private ProdVO prodVO;

	@Autowired 
	private FavVO favVO;




	//찜 목록 조회하기
	@Override
	@RequestMapping(value = "/picklist_add.do", method = RequestMethod.GET)
	public ModelAndView listPicks (HttpServletRequest request, HttpServletResponse response) throws Exception {

		String viewName = (String) request.getAttribute("viewName");

		logger.info("info : "+viewName);
		logger.debug("debug : "+viewName);
		
		//아이디 세션불러오기
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("userVO");
		String user_id = "";
		if(userVO != null) {
			if(userVO.getUser_id() == null || userVO.getUser_id() == "") {
				user_id = "";
			}else {
				user_id = userVO.getUser_id();
			}
		}
		
		cartAddVO.setUser_id(user_id);
		List<PickVO> pickList = cartPickService.listPicks(user_id);
		ModelAndView mav = new ModelAndView();		
		mav.addObject("pickList", pickList);	//view에 전달할 객체 생성

		return mav;
	}

	//찜 목록 삭제하기
	@Override
	@RequestMapping(value = "/removePick.do", method = RequestMethod.GET)
	public ModelAndView removePick(String prod_name, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("removePick controller 호출");
		request.setCharacterEncoding("utf-8");
		cartPickService.removePick(prod_name);
		ModelAndView mav = new ModelAndView("redirect:/picklist_add.do");
		return mav;
	}

	//마이페이지 찜하기 페이지에서 담기 클릭 시 장바구니 페이지에 추가 담기 기능
	@Override
	@RequestMapping(value="/insertCart.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String insertCart(@ModelAttribute CartAddVO cartAddVO, HttpSession session) throws Exception {
					
		//아이디 세션불러오기
		UserVO userVO = (UserVO) session.getAttribute("userVO");
		String user_id = "";
		if(userVO != null) {
			if(userVO.getUser_id() == null || userVO.getUser_id() == "") {
				user_id = "";
			}else {
				user_id = userVO.getUser_id();
			}
		}
		cartAddVO.setUser_id(user_id);	
		//장바구니에 상품있는지 점검
		int count = cartPickService.commCart(user_id, cartAddVO.getProd_code());
		if(count == 0) {
			cartPickService.insertCart(cartAddVO);
		}else {
			System.out.println("수량:"+cartAddVO.getProd_quantity());
			cartPickService.updateCart(cartAddVO);
		}
			return "redirect:/cart.do";
	}
		
	//수정
	@Override
	@RequestMapping(value = "/updateCart.do")
	public String updateCart(int[] prod_quantity, int[] prod_code, HttpSession session) throws Exception {
		//session의 id
		String user_id =(String) session.getAttribute("user_id");
			
		//레코드 갯수 만큼 반복문 실행
		for(int i=0; i<prod_code.length; i++) {
			CartAddVO cartAddVO = new CartAddVO();
			cartAddVO.setUser_id(user_id);					//사용자 아이디
			cartAddVO.setProd_code(prod_code[i]);			//상품 코드
			cartAddVO.setProd_quantity(prod_quantity[i]);	//상품 수량
			cartPickService.modifyCart(cartAddVO);
		}
			return "redirect:/cart.do";
	}

	
	//장바구니 조회
	@Override
	@RequestMapping(value = "/cart.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView list(HttpSession session, ModelAndView mav) throws Exception {
		
		//아이디 세션불러오기
		UserVO userVO = (UserVO) session.getAttribute("userVO");
		String user_id = "";
		if(userVO != null) {
			if(userVO.getUser_id() == null || userVO.getUser_id() == "") {
				user_id = "";
			}else {
				user_id = userVO.getUser_id();
			}
		}
		
		System.out.println("listCarts Controller 호출");
		
	   Map<String, Object> map = new HashMap<>();
		
	   List<ProdVO> cartList = cartPickService.listCarts(user_id);
	   UserAddrVO addr = cartPickService.getAddr(user_id);
	   int sumMoney = cartPickService.sumMoney(user_id);
	   //장바구니ㅣ 전체 금액에 따라 배송비 구분
	   //배송료 (3만원이상 무료, 미만 3000원) - 삼항연산자 사용
	   int fee = sumMoney >= 30000 ? 0: 3000;
	   
	   map.put("list", cartList);			//장바구니 정보 cartList에 저장
	   map.put("count", cartList.size());	//장바구니 상품 유무
	   map.put("sumMoney", sumMoney);		//상품 총합
	   map.put("fee", fee);					//배송금액
	   map.put("allSum", sumMoney+fee);		//장바구니 총합
	   mav.setViewName("cart");				//cart.do
	   mav.addObject("cartList", cartList);
	   mav.addObject("addrList", addr);
	   mav.addObject("map", map);			//map에 저장
	  			
	   return mav;
	}

	
	
	//장바구니 목록 삭제
	@Override
	@RequestMapping(value = "/removeCart.do", method = RequestMethod.GET)
	public ModelAndView removeCarts(String prod_name, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		request.setCharacterEncoding("utf-8");
		cartPickService.removeCart(prod_name);
		ModelAndView mav = new ModelAndView("redirect:/cart.do");
		return mav;
	}
		
		
}
 











