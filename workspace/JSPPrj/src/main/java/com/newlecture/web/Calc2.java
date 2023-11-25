package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext application = req.getServletContext();
		HttpSession session = req.getSession();
		Cookie[] cookies = req.getCookies();
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String v_ = req.getParameter("v");
		String button = req.getParameter("button");
		
		
		int v = 0;
		
		if(!v_.equals("")) v = Integer.parseInt(v_);
		
		
		// 계산
		
		if(button.equals("=")) {	
			
//			int x = (Integer)application.getAttribute("value");
//			int x = (Integer)session.getAttribute("value");
			int x = 0;
			
			for(Cookie c : cookies) {
				if(c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}				
			}
			
			
			
			int y = v;
//			String btn = (String)application.getAttribute("button");
//			String btn = (String)session.getAttribute("button");
			
			
			String btn = "";
			for(Cookie c : cookies) {
				if(c.getName().equals("button")) {
					btn = c.getValue();
					break;
				}				
			}
			
			
			int result = 0;	
			if(btn.equals("+")) result = x + y;
			if(btn.equals("-")) result = x - y;
			PrintWriter pw = resp.getWriter();
			System.out.println(result);
			pw.write("결과 :" + result);
			
		} else {  // 값을 저장
//			application.setAttribute("value", v);
//			application.setAttribute("button", button);
//			session.setAttribute("value", v);
//			session.setAttribute("button", button);
			
			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie btnCookie = new Cookie("button", button);
			valueCookie.setPath("/Calc2");
			btnCookie.setPath("/Calc2");
			resp.addCookie(valueCookie);
			resp.addCookie(btnCookie);
			
			resp.sendRedirect("calc2.html");
		}		
	}
}
