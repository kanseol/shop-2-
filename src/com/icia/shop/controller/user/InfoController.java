package com.icia.shop.controller.user;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.icia.shop.dao.*;
import com.icia.shop.entity.*;

@WebServlet("/sboard/user/info")
public class InfoController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. if(로그인하지 않았다면)
		// 2. else if(passwordCheck가 존재하지 않는다면)
		// 3. else ?????
		
		HttpSession session = request.getSession();
		if(session.getAttribute("username")==null)
			response.sendRedirect("/shop/sboard/user/login");
		else {
			if(session.getAttribute("passwordCheck")==null) {
				response.sendRedirect("/shop/sboard/user/password_check");
			} else {
				String username = (String)session.getAttribute("username");
				User user = MockUserDao.findById(username);
				request.setAttribute("user", user);
				
				request.setAttribute("viewname", "user/info.jsp");
				RequestDispatcher rd = request.getRequestDispatcher("/sboard/main.jsp");
				rd.forward(request, response);
			}
		}
	}
}