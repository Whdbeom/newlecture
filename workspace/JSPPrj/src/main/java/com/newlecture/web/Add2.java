package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add2")
public class Add2 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String[] numArr = req.getParameterValues("num");

		int result = 0;
		
		for(int i = 0; i<numArr.length; i++) {
			int num = Integer.parseInt(numArr[i]);
			result += num;
		}

		PrintWriter pw = resp.getWriter();
		System.out.println(result);
		pw.write("결과 :" + result);
	}
}
