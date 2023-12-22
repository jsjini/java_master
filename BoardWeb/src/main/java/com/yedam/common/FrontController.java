package com.yedam.common;
// 컨트롤러 : url 요청 -> 서블릿 실행

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/url매핑.....")
//@WebServlet("*.do")
public class FrontController extends HttpServlet {
	// 생명주기 : 톰캣이 정한 방식에 따름.  생성자 - > init() -> service() -> destroy() 
	
	Map<String, Control> map;
	
	public FrontController() {
		System.out.println("생성자 호출");
		map = new HashMap<String, Control>();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 호출");
		map.put("/main.do", new MainControl());
		map.put("/sub.do", new SubControl());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service() 호출");
		String url = req.getRequestURI(); // /BoardWeb/main.do
		String context = req.getContextPath(); // /BoardWeb
		String path = url.substring(context.length()); // /main.do 가 들어감
		System.out.println(path);
		
		Control ctrl = map.get(path);
		ctrl.execute(req, resp);
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy() 호출");
	}
	
}
