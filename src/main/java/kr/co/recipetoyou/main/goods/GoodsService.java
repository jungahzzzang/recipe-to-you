package kr.co.recipetoyou.main.goods;

import java.util.List;

import kr.co.recipetoyou.util.PagingVO;

public interface GoodsService {

	public GoodsVO listProduct(int prod_code)throws Exception;
	
	//전체 상품 조회
	public List<GoodsVO> listGoods(PagingVO vo) throws Exception;
	
	//상품 상세 조회
	public GoodsVO goodsDetail(int prod_code)throws Exception;
	

}
