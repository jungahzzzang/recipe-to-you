package kr.co.recipetoyou.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ViewNameInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

		try {
			String viewName = getViewName(request);		
			request.setAttribute("viewName", viewName);	
			System.out.println("ViewNameInterceptor"+viewName);
		} catch (Exception e) {
			System.out.println("getViewName() 오류");
			e.printStackTrace();
		}
		
		return true;
	}
	
	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		
		int begin = 0;
		if(!((contextPath==null) ||("".equals(contextPath)))) {
			begin = contextPath.length();			
		}
		
		int end;
		
		String uri =  (String)request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}
		
		if (uri.indexOf(";") != -1 ) {
			end = uri.indexOf(";");
		}
		else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		}
		else {
			end = uri.length();
		}
		
		String fileName = uri.substring(begin, end);
		if (fileName.indexOf(".") != -1) {
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
		}
		
		if (fileName.lastIndexOf("/") != -1) {
			fileName = fileName.substring(fileName.lastIndexOf("/",1), fileName.length());
		}
		
		return fileName;
	}
	
}
