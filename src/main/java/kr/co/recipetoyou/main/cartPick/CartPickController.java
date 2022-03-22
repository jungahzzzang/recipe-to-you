package kr.co.recipetoyou.main.cartPick;


import javax.servlet.http.HttpServletRequest;  


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.recipetoyou.main.cartPick.vo.CartAddVO;
import kr.co.recipetoyou.main.cartPick.vo.FavVO;
import kr.co.recipetoyou.main.cartPick.vo.PickVO;


public interface CartPickController {

	//찜하기 목록 조회
	public ModelAndView listPicks (HttpServletRequest request, HttpServletResponse response) throws Exception;
	//찜하기 목록 삭제
	public ModelAndView removePick(@RequestParam("prod_name") String prod_name, HttpServletRequest request, HttpServletResponse response) throws Exception; 
	//장바구니 목록 조회
	public ModelAndView list(HttpSession session, ModelAndView mav) throws Exception;
	//장바구니 목록 삭제
	public ModelAndView removeCarts (@RequestParam("prod_name") String prod_name, HttpServletRequest request, HttpServletResponse response) throws Exception;
	//찜하기 장바구니 페이지에 추가 담기
	public String insertCart(@ModelAttribute("info") CartAddVO cartAddVO, HttpSession session) throws Exception;
	//장바구니 수정
	public String updateCart(@RequestParam int[] prod_quantity, @RequestParam int[] prod_code, HttpSession session) throws Exception;
	 
}

