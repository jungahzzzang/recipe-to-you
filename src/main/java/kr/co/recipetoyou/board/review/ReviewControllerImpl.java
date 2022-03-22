package kr.co.recipetoyou.board.review;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("reviewController")
public class ReviewControllerImpl {
	
	
	@RequestMapping(value="/reviewWrite.do", method=RequestMethod.GET)
	public ModelAndView review() {
		ModelAndView mav = new ModelAndView();
		
		return mav;
	}

}
