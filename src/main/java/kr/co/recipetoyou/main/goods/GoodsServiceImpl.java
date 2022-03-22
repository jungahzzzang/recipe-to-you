package kr.co.recipetoyou.main.goods;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import kr.co.recipetoyou.admin.adgoods.AdGoodsDAO;
import kr.co.recipetoyou.admin.adgoods.AdgoodsImgVO;
import kr.co.recipetoyou.util.PagingVO;

@Service("goodsService")
@Transactional(propagation = Propagation.REQUIRED)
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsDAO goodsDAO;
	

	@Override
	public GoodsVO listProduct(int prod_code)throws Exception {
		GoodsVO goodsVO = goodsDAO.selectProdCode(prod_code);
		return goodsVO;
	}

	@Override
	public List<GoodsVO> listGoods(PagingVO vo) throws Exception {
		List<GoodsVO> goodsList = goodsDAO.listPaging(vo);
		
		goodsList.forEach(goodsvo->{
			try {
				int prod_code = goodsvo.getProd_code();
				List<AdgoodsImgVO> imageList  = goodsDAO.goodsImageList(prod_code);
				goodsvo.setImageList(imageList);
			
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (JsonMappingException e) {
			// TODO: handle exception
		}catch (IOException e) {
			// TODO: handle exception
		}
		});
		return goodsList;
	}
	
	//상품 상세 조회
	@Override
	public GoodsVO goodsDetail(int prod_code) throws Exception {
		
		return goodsDAO.selectProdCode(prod_code);
	}
	


}
