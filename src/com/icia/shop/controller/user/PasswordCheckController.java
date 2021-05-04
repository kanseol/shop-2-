package com.icia.shop.controller.user;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.icia.shop.dao.*;
import com.icia.shop.entity.*;

@WebServlet("/sboard/user/password_check")
public class PasswordCheckController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("username")==null) {
			response.sendRedirect("/shop/sboard/user/login");
		} else {
			request.setAttribute("viewname", "user/password_check.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("/sboard/main.jsp");
			rd.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("username")==null) {
			response.sendRedirect("/shop/sboard/user/login");
		} else {
			String password = request.getParameter("password");
			String username = (String)session.getAttribute("username");
			User user = MockUserDao.findByIdAndPassword(username, password);
			if(user==null) {
				response.sendRedirect("/shop/sboard/user/password_check?error");
			} else {
				session.setAttribute("passworkCheck", true);
				response.sendRedirect("/shop/sboard/user/info");
			}
		}
	}
}










