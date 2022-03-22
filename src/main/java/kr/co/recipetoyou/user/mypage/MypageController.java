package kr.co.recipetoyou.user.mypage;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.recipetoyou.user.UserVO;
import kr.co.recipetoyou.user.mypage.vo.CouponVO;


import kr.co.recipetoyou.user.mypage.vo.QnAVO;


public interface MypageController {
	
	//쿠폰 내역 조회
	public ModelAndView listCoupons(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	//포인트 내역 조회
	public ModelAndView listPoints(HttpServletRequest request, HttpServletResponse response) throws Exception;

	//배송지관리 조회
	public ModelAndView listAddress(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	//주문내역 조회
	public ModelAndView listOrders(HttpServletRequest request, HttpServletResponse response) throws Exception;

	//주문내역 상세 정보 조회
	public void orderDetail(@RequestParam("ord_code")int ord_code, Model model) throws Exception;
	
	//주문 취소
	public ModelAndView orderCancle(@RequestParam("ord_code") int ord_code, HttpServletRequest request, HttpServletResponse response) throws Exception; 
	
	//주문내역 연도별 조회
	public void searchOrderYear(Date ord_date, Model model) throws Exception; 
	String searchOrderYear(int ord_date, Model model) throws Exception;
	
	//상품문의 조회
	public ModelAndView listQnA(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	//상품문의 삭제 
	public ModelAndView removeQnA(@RequestParam("prod_inq_code") int prod_inq_code, HttpServletRequest	request, HttpServletResponse response) throws Exception;
	 
	//상품리뷰 조회
	public ModelAndView listReviews(HttpServletRequest request, HttpServletResponse response) throws Exception;

	//배송지 수정
	public ModelAndView addrModify(HttpServletRequest request, HttpServletResponse response) throws Exception;

	//상품문의 수정
	public ModelAndView modifyQnA(@RequestParam("prod_inq_code") int prod_inq_code, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	//배송지 삭제
	public ModelAndView removeAddress(@RequestParam("addr_code") String addr_code, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	//이메일 중복성 체크
	public String emailChk(String filterJSON, HttpServletResponse response, Model model) throws Exception;


	  public ModelAndView mypageUserInfo(UserVO userVO, HttpServletRequest request, HttpServletResponse response) throws Exception;

	  String mypageUserInfoProcess(UserVO userVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

      //예진-회원정보수정
	  public String modify(@ModelAttribute("userVO") UserVO userVO, HttpSession session, RedirectAttributes ra) throws Exception;
	  //회원탈퇴
	  public ModelAndView removeUser(@RequestParam("user_id") String user_id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	
}
