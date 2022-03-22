package kr.co.recipetoyou.admin.adgoods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import kr.co.recipetoyou.admin.adgoods.category.AdGoodsCateVO;
import kr.co.recipetoyou.main.cartPick.vo.ProdVO;
import kr.co.recipetoyou.util.PageMaker;
import kr.co.recipetoyou.util.PagingVO;

@Service("adgoodsService")
public class AdGoodsServiceImpl implements AdGoodsService {
	
	private static final Logger logger = LoggerFactory.getLogger("ProductServiceImpl.class");
	
	@Autowired
	AdGoodsDAO adGoodsDAO;
	
	//전체 상품 조회
	@Override
	public List<AdGoodsVO> listProduct(PagingVO vo) throws Exception {

		List<AdGoodsVO> prodList = adGoodsDAO.listPaging(vo);
		
		
		prodList.forEach(agvo->{
		
			try {
					int prod_code = agvo.getProd_code();
					List<AdgoodsImgVO> imageList  = adGoodsDAO.getGoodsImage(prod_code);
					agvo.setImageList(imageList);
				
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (JsonMappingException e) {
				// TODO: handle exception
			}catch (IOException e) {
				// TODO: handle exception
			}
			
		});
		
		
		return prodList;
	}
	
	//상품 수 조회
	@Override
	public int prodCount(PagingVO vo) throws DataAccessException {
		
		return adGoodsDAO.goodsCount(vo);
	}
	
	//상품 상세 정보 페이지 
	@Override
	public AdGoodsVO adgoodsGetDetail(int prod_code) throws Exception {
		
		return adGoodsDAO.readGoods(prod_code);
	}
	
	//상품 정보
	@Override
	public AdGoodsVO getadGoodsInfo(int prod_code) throws JsonProcessingException {
		
		AdGoodsVO goodsVO = adGoodsDAO.getadGoodsInfo(prod_code);
		goodsVO.setImageList(adGoodsDAO.getGoodsImage(prod_code));
		
		return goodsVO;
	}
	
	//카테고리
	@Override
	public List<AdGoodsCateVO> cateList() throws IOException {
		
		logger.info("(service)cateList.....");
		
		return adGoodsDAO.cateList();
	}

	//검색 결과 갯수
	@Override
	public int countSearch(PagingVO vo) throws Exception {
		
		return adGoodsDAO.countSearch(vo);
	}
	
	//상품 등록
	@Transactional
	@Override
	public void register(AdGoodsVO agvo) throws Exception {
		
		logger.info("(service) register........");
		adGoodsDAO.register(agvo);
		
		//이미지가 없는 경우 register() 메서드 실행 종료
		if(agvo.getImageList() == null || agvo.getImageList().size() == 0) {
			return;
		}
		//업로드 이미지 정보 DB 등록
		for(AdgoodsImgVO imagevo : agvo.getImageList()) {
			imagevo.setProd_code(agvo.getProd_code());
			adGoodsDAO.imageUpload(imagevo);
		}
		
	}
	
	//이미지 데이터
	@Override
	public List<AdgoodsImgVO> getGoodsImage(int prod_code) throws Exception {
		
		return adGoodsDAO.getGoodsImage(prod_code);
	}

	//상품 정보 수정
	@Transactional
	@Override
	public int goodsModify(AdGoodsVO agvo) throws Exception {
		
		int result = adGoodsDAO.goodsModify(agvo);
		
		if(result == 1 && agvo.getImageList() != null && agvo.getImageList().size() > 0) {
			adGoodsDAO.removeImage(agvo.getProd_code());
			agvo.getImageList().forEach(imagevo->{

					
					try {
						imagevo.setProd_code(agvo.getProd_code());
						adGoodsDAO.imageUpload(imagevo);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			});
		}
		
		return result;
	}

	//상품 정보 삭제
	@Override
	public int goodsDelete(int prod_code) throws Exception {
		
		return adGoodsDAO.goodsDelete(prod_code);
	}
	
	//상품 이미지 삭제
	@Override
	public void removeImage(int prod_code) throws Exception {
		adGoodsDAO.removeImage(prod_code);
		
	}

	//재고 관리
	@Override
	public void updageStock(AdGoodsVO agvo) throws Exception {
		
		adGoodsDAO.updageStock(agvo);
		
	}

	

	
	
	

}
