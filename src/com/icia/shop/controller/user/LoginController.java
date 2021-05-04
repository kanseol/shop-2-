package com.icia.shop.controller.user;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.icia.shop.dao.*;
import com.icia.shop.entity.*;

@WebServlet("/sboard/user/login")
public class LoginController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("viewname", "user/login.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/sboard/main.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// select * from users where username='spring' and password='1234' and rownum=1;
		User user = MockUserDao.findByIdAndPassword(username, password);
		if(user!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("/shop/sboard/post/list");
		} else {
			response.sendRedirect("/shop/sboard/user/login?error");
		}
		
	}
}