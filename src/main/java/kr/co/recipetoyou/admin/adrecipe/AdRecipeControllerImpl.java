package kr.co.recipetoyou.admin.adrecipe;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.recipetoyou.util.PageMaker;
import kr.co.recipetoyou.util.PagingVO;

@Controller("adRecipeController")
public class AdRecipeControllerImpl implements AdRecipeController {

	private static final Logger logger = LoggerFactory.getLogger("AdRecipeControllerImpl.class");
	
	@Autowired
	private AdRecipeService service;

	//페이징처리한 레시피 글목록
	@Override
	@RequestMapping(value = "/adrecipe/listRecipe.do", method = RequestMethod.GET)
	public void listRecipeGET(PagingVO vo, Model model) throws Exception{
		logger.info("C: listRecipeVO 겟 호출" + vo);
		model.addAttribute("ListRecipe", service.listRecipe(vo));
	}
		
	//글목록보기(PageMaker객체 사용)
	//전체 레시피 게시글 조회
	@Override
	@RequestMapping(value = "/adrecipe/listadRecipe.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView lisRecipePageGet(PagingVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		int cnt = service.recipeCount(vo);  
		PageMaker pm = new PageMaker(vo, cnt);
		pm.setVo(vo);
	    pm.setTotalCount(service.recipeCount(vo)); 
		logger.info("C: vo는 "+ vo);
		logger.info("info 레벨 : viewName = "+viewName);  
		List<AdRecipeVO> recipeList = service.listRecipe(vo);
	    ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("recipeList", recipeList);
		mav.addObject("cnt", cnt);
		mav.addObject("pm",pm);	 
		return mav;
	}
	
	//페이징 이동 시에 필요함 
	@RequestMapping(value = "/recipe/*Form.do", method = RequestMethod.GET)
	 public ModelAndView form(@RequestParam(value = "result", required = false) String result, HttpServletRequest request, HttpServletResponse response) throws Exception{
	 	//String viewName = getViewName(request);
		String viewName = (String)request.getAttribute("viewName");	
	 	ModelAndView mav = new ModelAndView(viewName);
	 	mav.addObject("result", result);
	 	return mav;
	 }
	
	//레시피 게시글 상세 정보 조회
	@Override
	@RequestMapping(value = "/adrecipe/adRecipeInfo.do", method = RequestMethod.GET)
	public ModelAndView getRecipeInfo(@RequestParam(value="id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("클릭한 아이디:"+id);
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("adRecipeVO", service.getRecipeInfo(id));
		return mav;
	}
	//레시피 게시글 삭제  
	@Override
	@RequestMapping(value = "/adrecipe/removeRecipe.do", method = RequestMethod.GET)
	public ModelAndView removePay(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("id : " + id);
		request.setCharacterEncoding("utf-8");
		service.removeRecipe(id);
		ModelAndView mav = new ModelAndView("redirect:listadRecipe.do");
		return mav;
	}
}
