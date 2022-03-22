package kr.co.recipetoyou.user.mypage;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.Session;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;

import kr.co.recipetoyou.admin.adgoods.AdgoodsImgVO;
import kr.co.recipetoyou.main.inqreview.ReviewVO;
import kr.co.recipetoyou.user.UserVO;
import kr.co.recipetoyou.user.mypage.vo.CouponVO;
import kr.co.recipetoyou.user.mypage.vo.MyOrderVO;
import kr.co.recipetoyou.user.mypage.vo.PointVO;

import kr.co.recipetoyou.user.mypage.vo.UserAddrVO;
import kr.co.recipetoyou.util.PagingVO;
import kr.co.recipetoyou.user.mypage.vo.QnAVO;


@Repository("mypageDAO")
public class MypageDAOImpl implements MypageDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	//쿠폰 조회
	@Override
	public List<CouponVO> selectAllCouponList(String user_id) throws DataAccessException {
			
		List<CouponVO> couponList = sqlSession.selectList("mapper.member.selectAllCouponList", user_id);
		return couponList;
	}
	
	//쿠폰 갯수
	@Override
	public int selectCouponCount(String user_id) {
		int result = sqlSession.selectOne("mapper.member.couponCount", user_id);
		return result;
	}
		
	//포인트 조회
	@Override
	public List<PointVO> selectAllPointList(String user_id) throws DataAccessException {
		List<PointVO> pointList = sqlSession.selectList("mapper.member.selectAllPointList", user_id);
		return pointList;
	}

		
	//배송지관리 조회
	@Override 
	public List<UserAddrVO> selectAllAddressList() throws DataAccessException {
		  
		System.out.println("addrlist DAO 호출");
		  
		List<UserAddrVO> addressList = sqlSession.selectList("mapper.member.selectAllAddressList"); 
		return addressList; 
	}

	//주문내역 조회 
	@Override
	public List<MyOrderVO> selectAllOrderList(String user_id) throws DataAccessException {
			
		List<MyOrderVO> OrderList = sqlSession.selectList("mapper.member.selectAllOrderList",user_id);
		return OrderList;
	}
	
	//주문내역 상세 정보 조회
	@Override
	public MyOrderVO orderDetailList(int ord_code) throws DataAccessException {
		
		System.out.println("orderDetail DAO 호출");
		return sqlSession.selectOne("mapper.member.orderDetailList", ord_code);
	}
	
	//주문내역 연도별 검색
	@Override
	public MyOrderVO searchOrderList(Date ord_date) throws DataAccessException {
		System.out.println("sesarOrder DAO 호출");
		return sqlSession.selectOne("mapper.member.searchOrderList", ord_date);
	}

	//주문 취소
	@Override
	public int CancleOrders(int ord_code) throws DataAccessException {
		int result = sqlSession.delete("mapper.member.CancleOrders",ord_code);
		System.out.println("cancleDAO 주문 취소"+ord_code);
		return result;
	}

	//상품문의 조회
	@Override
	public List<QnAVO> selectAllQnAList() throws DataAccessException {
		List<QnAVO> qnaList = sqlSession.selectList("mapper.member.selectAllQnAList");
		return qnaList;
	}

	//상품후기 조회
	@Override
	public List<ReviewVO> selectAllReviewList() throws DataAccessException {
		List<ReviewVO> reviewList = sqlSession.selectList("mapper.member.selectAllReviewList");
		return reviewList;
	}

	@Override
	public List<AdgoodsImgVO> getGoodsImage(int ord_code) throws JsonProcessingException {
		return sqlSession.selectList("mapper.member.getImageList", ord_code);
		
	}


	//상품문의 삭제
	@Override
    public int deleteQnA(@RequestParam("prod_inq_code") int prod_inq_code) throws DataAccessException {
		
		int result = sqlSession.delete("mapper.member.deleteQnA", prod_inq_code);
		return result;

	}

	//배송지 삭제
	@Override
	public int deleteAddress(@RequestParam("addr_code") String addr_code) throws DataAccessException {
		
		int result = sqlSession.delete("mapper.member.deleteAddress", addr_code);
		return result;
	}
	
	
	
	
	//이메일 중복체크
	@Override
	public int emailChk(UserVO userVO) throws DataAccessException {
		int result = sqlSession.selectOne("mapper.member.emailChk", userVO);
		return result;
	}

	
	//예진-회원정보수정
	@Override
	public void pwUpdate(UserVO userVO) throws DataAccessException {
		sqlSession.update("mapper.member.updateUser",userVO);
		
	}

	//회원탈퇴
	@Override
	public int WithdrawUser(@RequestParam("user_id")String user_id) throws DataAccessException {
		int result = sqlSession.delete("mapper.member.withdrawUser", user_id);
		return result;
	}

	

	

	

	
	
}
