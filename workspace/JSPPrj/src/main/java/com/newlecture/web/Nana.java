package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class Nana extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter pw = resp.getWriter();
		String temp = req.getParameter("cnt");
		
		int cnt = 0;
		if(temp != null && !temp.equals("")) {
			cnt = Integer.parseInt(temp);			
		}
		
		if(temp == null || temp.equals("")){
			pw.write("뭔가 잘못됐음");
		}
		
		for(int i = 1; i <= cnt; i++) {
			
			pw.println(i + ": 헬로우 Servlet!!<br>");
		}
		
	}
	
	
}
