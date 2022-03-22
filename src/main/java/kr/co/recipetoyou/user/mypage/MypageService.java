package kr.co.recipetoyou.user.mypage;

import java.sql.Date;
import java.util.List; 

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;

import kr.co.recipetoyou.main.inqreview.ReviewVO;
import kr.co.recipetoyou.user.UserVO;
import kr.co.recipetoyou.user.mypage.vo.CouponVO;
import kr.co.recipetoyou.user.mypage.vo.MyOrderVO;
import kr.co.recipetoyou.user.mypage.vo.PointVO;

import kr.co.recipetoyou.user.mypage.vo.UserAddrVO;

import kr.co.recipetoyou.user.mypage.vo.QnAVO;


public interface MypageService {

	//쿠폰
	public List<CouponVO> listCoupons(String user_id) throws DataAccessException;
	
	//쿠폰 카운트
	public int getCouponCount(String user_id);

	//포인트
	public List<PointVO> listPoints(String user_id) throws DataAccessException;
	
	//배송지관리 
	public List<UserAddrVO> listAddress() throws DataAccessException;
	
	//주문내역 조회
	public List<MyOrderVO> listOrders(String user_id) throws DataAccessException;

	//주문 상세 페이지
	public MyOrderVO orderDetail(int ord_code) throws Exception;
	
	//주문내역 연도별 조회
	public MyOrderVO searchOrderList(Date ord_date) throws Exception; 
	
	//주문 취소
	public int CancleOrders(int ord_code) throws DataAccessException;
	
	//상품문의
	public List<QnAVO> listQnA() throws DataAccessException;
	
	//상품문의 삭제
	public int deleteQnA(@RequestParam("prod_inq_code") int prod_inq_code) throws DataAccessException;
	
	
	//상품후기
	public List<ReviewVO> listReviews() throws DataAccessException;

	//배송지삭제
	public int deleteAddress(@RequestParam("addr_code") String addr_code) throws DataAccessException;

	//이메일 중복체크
	public int emailChk(UserVO userVO) throws DataAccessException;
	
	//예진 -회원정보수정
	public void pwUpdate(UserVO userVO) throws DataAccessException;
	
	//탈퇴
	public int withdrawUser(@RequestParam("user_id")String user_id) throws DataAccessException;
			
}
