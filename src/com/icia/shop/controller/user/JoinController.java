package com.icia.shop.controller.user;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.icia.shop.dao.*;
import com.icia.shop.entity.*;


@WebServlet("/sboard/user/join")
public class JoinController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("viewname", "user/join.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/sboard/main.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String irum = request.getParameter("irum");
		User user = User.builder().username(username).password(password).email(email).irum(irum).build();
		MockUserDao.insert(user);
		response.sendRedirect("/shop/sboard/user/login");
	}
}